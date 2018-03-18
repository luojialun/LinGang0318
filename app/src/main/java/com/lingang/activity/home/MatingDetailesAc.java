package com.lingang.activity.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.adapter.LvPublicPerAdapter;
import com.lingang.adapter.MatingZoneAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.MatingDetailesBean;
import com.lingang.bean.Users;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.MapType;
import com.lingang.dialog.BottomDialog2;
import com.lingang.dialog.DialogError;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.utils.MapUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AlignTextView;
import com.lingang.view.ExtraListView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.next.tagview.TagCloudView;
import okhttp3.Call;
import okhttp3.Response;

public class MatingDetailesAc extends BaseAc implements RecycleLabAdapter.OnItemClickListener,
        DialogConfirmListion, PopConfirmClinck, AdapterView.OnItemClickListener {

    @BindView(R.id.img_entry)
    ImageView imgEntry;
    @BindView(R.id.tv_entry)
    TextView tvEntry;
    @BindView(R.id.tv_entry_lable)
    TextView tvEntryLable;
    @BindView(R.id.ll_intro)
    TextView llIntro;
    @BindView(R.id.img_expand)
    ImageView imgExpand;
    @BindView(R.id.content_group)
    AlignTextView contentGroup;
    @BindView(R.id.tf_tj)
    TagCloudView tfTj;
    @BindView(R.id.tv_fwClass)
    TextView tvFwClass;
    @BindView(R.id.tv_fwprj)
    AlignTextView tvFwprj;
    @BindView(R.id.rv_zone)
    RecyclerView rvZone;
    @BindView(R.id.tv_map)
    TextView tvMap;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_comp)
    TextView tvComp;
    @BindView(R.id.lv_per)
    ExtraListView lvPer;
    @BindView(R.id.tv_gs)
    TextView tvGs;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.img_service)
    ImageView imgService;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.tv_yqnum)
    TextView tvYqnum;
    @BindView(R.id.per_sta)
    TextView perSta;

    private boolean isService = false;
    private boolean isExpend = false;
    private RecycleLabAdapter.OnItemClickListener listener;
    private List<MatingDetailesBean.DataBean.ParksBean> parks;
    private String collectState;
    private String serviceId;
    private String collectId;
    private DialogTwoCall dialogTwo;
    private String phone;
    private DialogError dialogError;
    private AdapterView.OnItemClickListener itmeListion;
    private List<Users> umanagers;

    private BottomDialog2 bottomDialog2;
    private List<String> bottomList = new ArrayList<>();
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_mating_detailes);
        setTitle("配套服务详情");
        listener = this;
        itmeListion = this;
        getRightView2().setImageResource(R.mipmap.error);
        initBottomDialog();
        getServiceDetails(true);
    }

    /**
     * 初始化地图导航底部弹窗
     */
    private void initBottomDialog() {
        if (MapUtils.isAvilible(this, "com.baidu.BaiduMap")) {
            bottomList.add(MapType.BAIDU);
        }
        if (MapUtils.isAvilible(this, "com.autonavi.minimap")) {
            bottomList.add(MapType.GAODE);
        }

        bottomDialog2 = new BottomDialog2(this, bottomList);
        bottomDialog2.setOnItemClickListener(new BottomDialog2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String item, int position) {
                switch (item) {
                    case MapType.BAIDU:
                        MapUtils.goBaiduMap(MatingDetailesAc.this, address);
                        break;
                    case MapType.GAODE:
                        MapUtils.goGaodeMap(MatingDetailesAc.this, address);
                        break;
                }
                bottomDialog2.dismiss();
            }
        });
    }

    private void getServiceDetails(final boolean isRefresh) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("serviceId", getIntent().getStringExtra("id"));
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ServiceDetails)
                .params(httpParams)
                .execute(new ResCallBack<MatingDetailesBean>(this) {
                    @Override
                    public void onCall(MatingDetailesBean cluster, Call call, Response response) {
                        GlideImgManager.glideLoaderNormal(MatingDetailesAc.this, HttpApi.IMAGE_BASE_SERVER + cluster.getData().getImgPath(), imgEntry);

                        collectId = cluster.getData().getCollectId();
                        serviceId = cluster.getData().getServiceId();
                        collectState = cluster.getData().getCollectState();
                        //收藏状态 1:收藏0:未收藏
                        if (collectState.equals("1")) {
                            getRightView().setImageResource(R.mipmap.collect_success);
                        } else {
                            getRightView().setImageResource(R.mipmap.collect);
                        }

                        if (isRefresh) {
                            //简介
                            contentGroup.setContent(cluster.getData().getServiceContent());
                            tvEntry.setText(cluster.getData().getServiceName());
                            tvEntryLable.setText(cluster.getData().getServiceSimple());

                            //关键字

                            List<MatingDetailesBean.DataBean.LabelsBean> labels = cluster.getData().getLabels();
                            if (labels.size() > 0) {
                                ArrayList<String> classList = new ArrayList<>();
                                for (MatingDetailesBean.DataBean.LabelsBean labelsBean :
                                        labels) {
                                    classList.add(labelsBean.getLabelName());
                                }
                                tfTj.setTags(classList);
                            } else {
                                llTag.setVisibility(View.GONE);
                            }


                            tvFwClass.setText(cluster.getData().getBasicsName());

                            tvFwprj.setContent(cluster.getData().getServiceTeam());

                            //覆盖园区
                            parks = cluster.getData().getParks();
                            if (parks != null)
                                tvYqnum.setText(parks.size() + "个园区");
                            setRecycleHorizontal(rvZone);
                            setRefreshViewLine(rvZone, R.drawable.item_divider_tran_magin5);
                            MatingZoneAdapter matingZoneAdapter = new MatingZoneAdapter(MatingDetailesAc.this, parks);
                            matingZoneAdapter.setOnItemClickListener(listener);
                            rvZone.setAdapter(matingZoneAdapter);

                            //联系方式
                            address=cluster.getData().getServiceAddress();
                            tvMap.setText(address);
                            if (!TextUtils.isEmpty(address)) {
                                tvMap.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (bottomList.size() > 0) {
                                            bottomDialog2.show();
                                        } else {
                                            ToastUtils.showToast(MatingDetailesAc.this, "请安装百度或者高德地图进行导航");
                                        }
                                    }
                                });
                            }

                            List<MatingDetailesBean.DataBean.WaysBean> ways = cluster.getData().getWays();
                            if (ways.size() > 0)
                                tvPhone.setText(ways.get(0).getWayTel());
                            tvComp.setText(cluster.getData().getServiceLink());

                            //联络人
                            umanagers = cluster.getData().getUsers();
                            lvPer.setAdapter(new LvPublicPerAdapter(MatingDetailesAc.this, umanagers));
                            if (null == umanagers || umanagers.size() == 0) {
                                perSta.setText("无");
                            }
                            lvPer.setOnItemClickListener(itmeListion);

                            tvGs.setText(cluster.getData().getServiceCompany());
                            String createTime = cluster.getData().getCreateTime();
                            if (!TextUtils.isEmpty(createTime)) {
                                tvData.setText(DateUtils.getTimes(createTime, "yyyy-MM-dd"));
                            } else {
                                tvData.setText("无");
                            }
                        }
                    }

                });
    }


    @Override
    public void ibClickRight2() {
        super.ibClickRight2();
        if (dialogError == null) {
            dialogError = new DialogError(this, this);
        }
        dialogError.show();
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (collectState.equals("1")) {//1:收藏0:未收藏
            delUserCollect();
        } else {
            addUserCollect();
        }
    }

    //收藏
    private void addUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectType", "3");
        httpParams.put("objId", serviceId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        getServiceDetails(false);
                        ToastUtils.showToast(MatingDetailesAc.this, "收藏成功");
                    }
                });
    }

    //取消收藏
    private void delUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectId", collectId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.delUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        getServiceDetails(false);
                        ToastUtils.showToast(MatingDetailesAc.this, "取消收藏");
                    }
                });
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, ChanYeDetailsAc.class).putExtra("id", parks.get(position).getParkId()));
    }

    @OnClick({R.id.tv_phone, R.id.tv_comp, R.id.img_service, R.id.img_expand})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_phone:
                phone = tvPhone.getText().toString();
                dialogTwo = new DialogTwoCall(this, this);
                dialogTwo.show("取消", "呼叫", phone);
                break;
            case R.id.tv_comp:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://" + tvComp.getText().toString());
                intent.setData(content_url);
                startActivity(intent);
                break;
            case R.id.img_expand:
                int lineCount = contentGroup.getLinesNum();
                if (!isExpend) {
                    if (lineCount > 6) {
                        contentGroup.setMaxLines(lineCount);
                    }
                    isExpend = true;
                    imgExpand.setImageResource(R.mipmap.up);
                } else {
                    // 复原
                    if (lineCount > 6) {
                        contentGroup.setMaxLines(6);
                    }
                    isExpend = false;
                    imgExpand.setImageResource(R.mipmap.pull);
                }
                break;
            case R.id.img_service:
                int fwLineCount = tvFwprj.getLinesNum();
                if (!isService) {
                    if (fwLineCount > 6) {
                        tvFwprj.setMaxLines(fwLineCount);
                    }
                    isService = true;
                    imgService.setImageResource(R.mipmap.up);
                } else {
                    // 复原
                    if (fwLineCount > 6) {
                        tvFwprj.setMaxLines(6);
                    }
                    isService = false;
                    imgService.setImageResource(R.mipmap.pull);
                }
                break;
        }
    }

    @Override
    public void confirmClick(String sign) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPiss();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri data = Uri.parse("tel:" + phone.replace("-", ""));
            intent.setData(data);
            startActivity(intent);
        }

    }

    private void requestPiss() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
            // 返回值：
            //如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
            //如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
            //如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
            // 弹窗需要解释为何需要该权限，再次请求授权

            // 帮跳转到该应用的设置界面，让用户手动授权
            ToastUtils.showToast(this, "请授权！");
            Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            i.setData(uri);
            startActivity(i);
        } else {
            // 不需要解释为何需要该权限，直接请求授权
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    Constants.MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }
    }

    // 处理权限申请的回调
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Constants.MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 授权成功，继续打电话
                    ToastUtils.showToast(this, "授权成功！");
                } else {
                    // 授权失败！
                    ToastUtils.showToast(this, "授权失败！");
                }
                break;
            }
        }

    }

    @Override
    public void popConfirmClinck(String sign, String value) {
        UserOpinion(value);
    }

    //信息纠错
    private void UserOpinion(String value) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("messageType", "1");
        httpParams.put("messageContent", value);
        httpParams.put("linkType", Constants.CorrectType.Mating);
        httpParams.put("linkId", serviceId);
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(MatingDetailesAc.this, "提交成功");
                    }
                });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", umanagers.get(i).getUserAccount()).putExtra("tag", "bendi"));
    }
}
