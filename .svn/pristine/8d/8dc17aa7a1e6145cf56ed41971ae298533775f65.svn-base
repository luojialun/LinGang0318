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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.activity.business.PicListAc;
import com.lingang.adapter.LvGroupAdapter;
import com.lingang.adapter.LvPublicPerAdapter;
import com.lingang.adapter.ZoneAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.FileBean;
import com.lingang.bean.ParkDetailsBean;
import com.lingang.bean.PropertyDetailesBean;
import com.lingang.bean.Users;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.common.CircleProgressHelper;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.MapType;
import com.lingang.dialog.BottomDialog2;
import com.lingang.dialog.DialogError;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.dialog.ShareDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppUtils;
import com.lingang.utils.DateUtils;
import com.lingang.utils.MapUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AlignTextView;
import com.lingang.view.CustomCircleProgress;
import com.lingang.view.ExtraListView;
import com.lingang.view.video.JCVPlayerTitleAfterFull;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import me.next.tagview.TagCloudView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 租售物业详情
 */
public class PropertyDettailsAc extends BaseAc implements RecycleLabAdapter.OnItemClickListener,
        DialogConfirmListion, PopConfirmClinck, AdapterView.OnItemClickListener {

    @BindView(R.id.img_group)
    ImageView imgGroup;
    @BindView(R.id.img_more)
    ImageView imgMore;
    @BindView(R.id.ll_intro)
    TextView llIntro;
    @BindView(R.id.img_expand)
    ImageView imgExpand;
    @BindView(R.id.content_group)
    AlignTextView contentGroup;
    @BindView(R.id.tf_tj)
    TagCloudView tfTj;
    @BindView(R.id.tv_class)
    TextView tvClass;
    @BindView(R.id.rv_zone)
    RecyclerView rvZone;
    @BindView(R.id.tv_map)
    TextView tvMap;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.lv_cail)
    ExtraListView lvCail;
    @BindView(R.id.videoplayer)
    JCVPlayerTitleAfterFull videoplayer;
    @BindView(R.id.tv_vdtitle)
    TextView tvVdtitle;
    @BindView(R.id.btn_vddown)
    ImageView btnVddown;
    @BindView(R.id.download_vdprogress)
    CustomCircleProgress downloadVdprogress;
    @BindView(R.id.ll_vdinfo)
    LinearLayout llVdinfo;
    @BindView(R.id.lv_per)
    ExtraListView lvPer;
    @BindView(R.id.tv_gs)
    TextView tvGs;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.fl_sc_video)
    LinearLayout flScVideo;
    @BindView(R.id.tv_pic)
    TextView tvPic;
    @BindView(R.id.tv_comp)
    TextView tvComp;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.tv_ms)
    TextView tvMs;
    @BindView(R.id.tv_compan)
    TextView tvCompan;
    @BindView(R.id.tv_perdata)
    TextView tvPerdata;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.tvcail_state)
    TextView tvcailState;
    @BindView(R.id.tvp_state)
    TextView tvpState;
    private String businessLink;
    private RecycleLabAdapter.OnItemClickListener listener;
    private ArrayList<ParkDetailsBean.DataBean.BusinessBean> industrysBeen;
    private String collectState;
    private String businessId;
    private String collectId;
    private DialogTwoCall dialogTwo;
    private String phone;
    private DialogError dialogError;
    private AdapterView.OnItemClickListener itemClickListener;
    private List<Users> users;
    private ArrayList<FileBean> pdfList;
    private boolean isExpend = false;
    private ShareDialog shareDialog;
    private ArrayList<FileBean> videoList;
    private CircleProgressHelper circleProgress;
    private BottomDialog2 bottomDialog2;
    private List<String> bottomList = new ArrayList<>();
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_property);
        ButterKnife.bind(this);
        setTitle(getIntent().getStringExtra("title"));
        listener = this;
        itemClickListener = this;
        imgMore.setVisibility(View.GONE);
        tvCompan.setText("开发主体");
        tvPerdata.setText("竣工日期");
        getRightView2().setImageResource(R.mipmap.error);
        getBusinessDetails(true);
        initBottomDialog();
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
                        MapUtils.goBaiduMap(PropertyDettailsAc.this, address);
                        break;
                    case MapType.GAODE:
                        MapUtils.goGaodeMap(PropertyDettailsAc.this, address);
                        break;
                }
                bottomDialog2.dismiss();
            }
        });
    }

    private void getBusinessDetails(final boolean isRefresh) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("businessId", getIntent().getStringExtra("id"));
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.BusinessDetails)
                .params(httpParams)
                .execute(new ResCallBack<PropertyDetailesBean>(this) {
                    @Override
                    public void onCall(PropertyDetailesBean cluster, Call call, Response response) {
                        GlideImgManager.glideLoader(PropertyDettailsAc.this, HttpApi.IMAGE_BASE_SERVER + cluster.getData().getMaxImgPath(), imgGroup);
                        tvPic.setText(cluster.getData().getPicCount());
                        tvPic.setVisibility(View.VISIBLE);

                        businessLink = cluster.getData().getBusinessLink();
                        collectState = cluster.getData().getCollectState();
                        businessId = cluster.getData().getBusinessId();
                        collectId = cluster.getData().getCollectId();
                        //收藏状态
                        if (collectState.equals("1")) {//1:收藏0:未收藏
                            getRightView().setImageResource(R.mipmap.collect_success);
                        } else {
                            getRightView().setImageResource(R.mipmap.collect);
                        }

                        if (isRefresh) {
                            //简介
                            contentGroup.setContent(cluster.getData().getBusinessContent());
                            //标签
                            List<PropertyDetailesBean.DataBean.LabelsBean> labels = cluster.getData().getLabels();
                            if (labels.size() > 0) {
                                ArrayList<String> classList = new ArrayList<>();
                                for (PropertyDetailesBean.DataBean.LabelsBean labelsBean :
                                        labels) {
                                    classList.add(labelsBean.getLabelName());
                                }
                                tfTj.setTags(classList);
                            } else {
                                llTag.setVisibility(View.GONE);
                            }
                            //物业类型
                            tvClass.setText(cluster.getData().getTypeBasicsName());
                            address = cluster.getData().getBusinessAddress();
                            tvMap.setText(cluster.getData().getBusinessAddress());
                            if (!TextUtils.isEmpty(address)) {
                                tvMap.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (bottomList.size() > 0) {
                                            bottomDialog2.show();
                                        } else {
                                            ToastUtils.showToast(PropertyDettailsAc.this, "请安装百度或者高德地图进行导航");
                                        }
                                    }
                                });
                            }

                            List<PropertyDetailesBean.DataBean.WaysBean> ways = cluster.getData().getWays();
                            if (ways.size() > 0) {
                                StringBuilder phone = new StringBuilder("");
                                for (PropertyDetailesBean.DataBean.WaysBean waysBean :
                                        ways) {
                                    phone.append(waysBean.getWayTel() + "  ");
                                }
                                tvPhone.setText(phone);
                            }

                            tvData.setText(DateUtils.getTimes(cluster.getData().getCreateTime(), "yyyy-MM-dd"));

                            String businessCompany = cluster.getData().getBusinessCompany();
                            tvGs.setText(TextUtils.isEmpty(businessCompany) ? "无" : businessCompany);
                            tvComp.setText(cluster.getData().getBusinessLink());

                            String businessState = cluster.getData().getProjectState();
                            if (businessState.equals("1")) {
                                tvState.setText("未开始");
                            } else if (businessState.equals("2")) {
                                tvState.setText("进行中");
                            } else if (businessState.equals("3")) {
                                tvState.setText("已完成");
                            }

                            tvMs.setText(cluster.getData().getSaleBasicsName());
//                        所在园区
                            setRecycleHorizontal(rvZone);
                            setRefreshViewLine(rvZone, R.drawable.item_divider_tran_magin5);

                            industrysBeen = new ArrayList<>();

                            ParkDetailsBean.DataBean.BusinessBean industrysBean = new ParkDetailsBean.DataBean.BusinessBean();
                            industrysBean.setBusinessName(cluster.getData().getParkName());
                            industrysBean.setBusinessImgPath(cluster.getData().getParkImgPath());
                            industrysBean.setBusinessId(cluster.getData().getParkId());
                            industrysBeen.add(industrysBean);

                            ZoneAdapter zoneAdapter = new ZoneAdapter(PropertyDettailsAc.this, industrysBeen);
                            zoneAdapter.setOnItemClickListener(listener);

                            rvZone.setAdapter(zoneAdapter);

                            //联系人
                            users = cluster.getData().getUsers();
                            lvPer.setOnItemClickListener(itemClickListener);
                            lvPer.setAdapter(new LvPublicPerAdapter(PropertyDettailsAc.this, users));


                            List<FileBean> files = cluster.getData().getFiles();
                            videoList = new ArrayList<>();
                            pdfList = new ArrayList<>();
                            for (FileBean filesBean :
                                    files) {
                                if (filesBean.getFileType().equals("1")) {//pdf
                                    pdfList.add(filesBean);
                                } else {
                                    videoList.add(filesBean);
                                }
                            }
                            //宣传片
                            if (videoList.size() > 0) {
                                FileBean fileBean = videoList.get(0);
                                tvVdtitle.setText(fileBean.getFileTitle());
                                videoplayer.setUp(HttpApi.IMAGE_BASE_SERVER + fileBean.getFileAddress(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, fileBean.getFileTitle());
                                GlideImgManager.glideLoader(PropertyDettailsAc.this, HttpApi.IMAGE_BASE_SERVER + fileBean.getImgPathVideo(), videoplayer.thumbImageView);
                                //视频下载
                                initDownloadVideo(fileBean);
                            } else {
                                tvpState.setText("无");
                                flScVideo.setVisibility(View.GONE);
                            }

                            //宣传资料
                            if (pdfList.size() > 0) {
                                lvCail.setAdapter(new LvGroupAdapter(PropertyDettailsAc.this, pdfList));
                                lvCail.setOnItemClickListener(itemClickListener);
                            } else {
                                tvcailState.setText("无");
                            }

                        }
                    }
                });

    }

    /**
     * 视频下载
     */
    private void initDownloadVideo(FileBean fileBean) {
        if (fileBean != null) {
            circleProgress = new CircleProgressHelper(this, btnVddown, downloadVdprogress);
            circleProgress.setItemData(fileBean.getFileAddress(), fileBean.getFileTitle(), fileBean.getFileType(), fileBean.getFileSize());
            circleProgress.refreshState(HttpApi.IMAGE_BASE_SERVER + fileBean.getFileAddress());
        }
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
        httpParams.put("collectType", "6");
        httpParams.put("objId", businessId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        getBusinessDetails(false);
                        ToastUtils.showToast(PropertyDettailsAc.this, "收藏成功");
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
                        getBusinessDetails(false);
                        ToastUtils.showToast(PropertyDettailsAc.this, "取消收藏");
                    }
                });
    }

    @OnClick(R.id.img_expand)
    public void onViewClicked() {
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
    }

    @OnClick({R.id.img_more, R.id.tv_phone, R.id.img_group, R.id.tv_pic, R.id.tv_comp, R.id.vd_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_more:
//                startActivity(new Intent(this, WebAc.class).putExtra("title", "租售物业详情").putExtra("url", businessLink));
                break;
            case R.id.tv_phone:
                phone = tvPhone.getText().toString();
                dialogTwo = new DialogTwoCall(this, this);
                dialogTwo.show("取消", "呼叫", phone);
                break;
            case R.id.img_group:
            case R.id.tv_pic:
                startActivity(new Intent(this, PicListAc.class).putExtra("objId", businessId).putExtra("pictureType", "1"));
                break;
            case R.id.tv_comp:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://" + tvComp.getText().toString());
                intent.setData(content_url);
                startActivity(intent);
            case R.id.vd_share:
                shareVideo();
                break;
        }
    }

    //分享视频
    private void shareVideo() {
        if (shareDialog == null) {
            shareDialog = new ShareDialog(this);
        }
        if (videoList.size() > 0) {
            UMWeb web = new UMWeb(HttpApi.IMAGE_BASE_SERVER + "/" + videoList.get(0).getShareUrl());
            web.setThumb(new UMImage(PropertyDettailsAc.this, HttpApi.IMAGE_BASE_SERVER + videoList.get(0).getImgPathVideo()));
            web.setTitle(videoList.get(0).getFileTitle().toString());
            web.setDescription(videoList.get(0).getFileTitle().toString());
            shareDialog.share(new ShareAction(this)
                    .withMedia(web), new ShareDialog.OnshareResultListener() {
                @Override
                public void onResult(int shareType) {
                    ToastUtils.showToast(PropertyDettailsAc.this, "分享成功");
                }

                @Override
                public void onError(int shareType) {
                    ToastUtils.showToast(PropertyDettailsAc.this, "分享失败");
                }

                @Override
                public void onCancle(int shareType) {
                    ToastUtils.showToast(PropertyDettailsAc.this, "分享取消");
                }
            });
            shareDialog.show();
        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, ChanYeDetailsAc.class).putExtra("id", industrysBeen.get(position).getBusinessId()));
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
        httpParams.put("linkType", Constants.CorrectType.Business);
        httpParams.put("linkId", businessId);
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(PropertyDettailsAc.this, "提交成功");
                    }
                });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()) {
            case R.id.lv_cail:
                Intent intent = new Intent(this, PdfViewerActivity.class);
                intent.putExtra(Constants.PDF_TITLE, pdfList.get(i).getFileTitle());
                intent.putExtra(Constants.PDF_ADDRESS, HttpApi.IMAGE_BASE_SERVER + pdfList.get(i).getFileAddress());
                intent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_PREVIEW);
                startActivity(intent);
                break;
            case R.id.lv_per:
                Users user = users.get(i);

                startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", user.getUserAccount()).putExtra("tag", "bendi"));
                break;
        }
    }

}
