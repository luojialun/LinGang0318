package com.lingang.activity.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
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
import com.lingang.activity.business.PicListAc;
import com.lingang.adapter.ChanyeDetailAdapter;
import com.lingang.adapter.ChanyeTeamAdapter;
import com.lingang.adapter.ChanyeZoneAdapter;
import com.lingang.adapter.LvGroupAdapter;
import com.lingang.adapter.LvPublicPerAdapter;
import com.lingang.adapter.ZoneAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ChanYDetailesBean;
import com.lingang.bean.FileBean;
import com.lingang.bean.ParkDetailsBean;
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
import com.lingang.utils.DateUtils;
import com.lingang.utils.MapUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AlignTextView;
import com.lingang.view.CustomCircleProgress;
import com.lingang.view.ExtraListView;
import com.lingang.view.dialog.NormalDialog;
import com.lingang.view.video.JCVPlayerTitleAfterFull;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import me.next.tagview.TagCloudView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 产业园区详情
 */
public class ChanYeDetailsAc extends BaseAc implements DialogConfirmListion, PopConfirmClinck, AdapterView.OnItemClickListener {

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
    @BindView(R.id.lv_zone)
    ExtraListView lvZone;
    @BindView(R.id.rv_zone)
    RecyclerView rvZone;
    @BindView(R.id.tv_map)
    TextView tvMap;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_comp)
    TextView tvComp;
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
    @BindView(R.id.lv_zone_pre)
    ExtraListView lvZonePre;
    @BindView(R.id.lv_zone_team)
    ExtraListView lvZoneTeam;
    @BindView(R.id.tv_gs)
    TextView tvGs;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.lv_cail)
    ExtraListView lvCail;
    @BindView(R.id.tv_numgs)
    TextView tvNumgs;
    @BindView(R.id.lv_per)
    ExtraListView lvPer;
    @BindView(R.id.fl_sc_video)
    LinearLayout flScVideo;
    @BindView(R.id.tv_pic)
    TextView tvPic;
    @BindView(R.id.tv_dingw)
    TextView tvDingw;
    @BindView(R.id.tv_compan)
    TextView tvCompan;
    @BindView(R.id.img_team)
    TextView imgTeam;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.tv_dingw_num)
    TextView tvDingwNum;
    @BindView(R.id.tv_wy)
    TextView tvWy;
    @BindView(R.id.cail_sta)
    TextView cailSta;
    @BindView(R.id.p_sta)
    TextView pSta;
    @BindView(R.id.per_sta)
    TextView perSta;

    private boolean isExpend = false;
    private boolean isDingw = false;
    private boolean isTeam = false;
    private DialogTwoCall dialogTwo;
    private String phone;
    private String detailLink;
    private String title;
    private String parkId;
    private String collectState;
    private String collectId;
    private DialogError dialogError;
    private AdapterView.OnItemClickListener listion;
    private List<Users> umanagers;
    private ArrayList<FileBean> pdfList;
    private ArrayList<ChanYDetailesBean> chanYDetailesData;
    private ChanyeDetailAdapter chanyeDetailAdapter;
    private List<Users> chanceUsers;
    private List<ParkDetailsBean.DataBean.StationsBean> stations;
    //下载管理
    private DownloadManager downLoadManager;
    //提示框
    private NormalDialog dialog;
    private CircleProgressHelper circleProgress;
    private ChanyeZoneAdapter chanyeZoneAdapter;
    private ParkDetailsBean.DataBean data;
    private ShareDialog shareDialog;
    private ArrayList<FileBean> videoList;

    private BottomDialog2 bottomDialog2;
    private List<String> bottomList = new ArrayList<>();
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_chan_ye_details);
        listion = this;
        tvPic.setVisibility(View.VISIBLE);
        getParkDetails(true);
        getRightView2().setImageResource(R.mipmap.error);
        tvCompan.setText("开发主体");
        downLoadManager = DownloadService.getDownloadManager();
        dialog = new NormalDialog(this);
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
                        MapUtils.goBaiduMap(ChanYeDetailsAc.this, address);
                        break;
                    case MapType.GAODE:
                        MapUtils.goGaodeMap(ChanYeDetailsAc.this, address);
                        break;
                }
                bottomDialog2.dismiss();
            }
        });
    }

    //获取详情数据
    private void getParkDetails(final boolean isRefresh) {
        String id = getIntent().getStringExtra("id");
        HttpParams httpParams = new HttpParams();
        httpParams.put("parkId", id);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ParkDetails)
                .params(httpParams)
                .execute(new ResCallBack<ParkDetailsBean>(this) {
                    @Override
                    public void onCall(ParkDetailsBean adressBean, Call call, Response response) {//
                        data = adressBean.getData();
                        detailLink = data.getDetailLink();
                        if (TextUtils.isEmpty(detailLink)) {
                            imgMore.setVisibility(View.GONE);
                        }

                        title = data.getParkName();
                        parkId = data.getParkId();
                        collectId = data.getCollectId();

                        //收藏状态
                        collectState = data.getCollectState();
                        if (collectState.equals("1")) {//1:收藏0:未收藏
                            getRightView().setImageResource(R.mipmap.collect_success);
                        } else {
                            getRightView().setImageResource(R.mipmap.collect);
                        }

                        if (isRefresh) {
                            String parkCompany = data.getParkCompany();
                            tvGs.setText(TextUtils.isEmpty(parkCompany) ? "无" : parkCompany);
                            setTitle(title);

                            tvPic.setText(data.getPicCount());
                            GlideImgManager.glideLoader(ChanYeDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + data.getMaxImgPath(), imgGroup);

                            //简介
                            contentGroup.setContent(data.getParkContent());
                            //信息
                            address = data.getParkAddress();
                            tvMap.setText(address);
                            if (!TextUtils.isEmpty(address)) {
                                tvMap.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (bottomList.size() > 0) {
                                            bottomDialog2.show();
                                        } else {
                                            ToastUtils.showToast(ChanYeDetailsAc.this, "请安装百度或者高德地图进行导航");
                                        }
                                    }
                                });
                            }

                            List<ParkDetailsBean.DataBean.WaysBean> ways = data.getWays();
                            if (ways.size() > 0) {
                                StringBuilder phone = new StringBuilder("");
                                for (ParkDetailsBean.DataBean.WaysBean waysBean :
                                        ways) {
                                    phone.append(waysBean.getWayTel() + "  ");
                                }
                                tvPhone.setText(phone);
                            }
                            tvComp.setText(data.getParkLink());

                            //关键字
                            List<ParkDetailsBean.DataBean.LabelsBean> labels = data.getLabels();
                            if (labels.size() > 0) {
                                ArrayList<String> classList = new ArrayList<>();
                                for (ParkDetailsBean.DataBean.LabelsBean LabelsBean :
                                        labels) {
                                    classList.add(LabelsBean.getLabelName());
                                }
                                tfTj.setTags(classList);
                            } else {
                                llTag.setVisibility(View.GONE);
                            }

                            //产业定位
                            List<ParkDetailsBean.DataBean.IndustrysBean> industrys = data.getIndustrys();
                            if (industrys.size() > 0) {
                                chanYDetailesData = new ArrayList<ChanYDetailesBean>();

                                for (ParkDetailsBean.DataBean.IndustrysBean industrysBean : industrys) {

                                    List<ParkDetailsBean.DataBean.IndustrysBean.IndustryLevelsBean> industryLevels = industrysBean.getIndustryLevels();

                                    for (ParkDetailsBean.DataBean.IndustrysBean.IndustryLevelsBean industryLevelsBean : industryLevels) {
                                        ChanYDetailesBean chanYDetailesBean = new ChanYDetailesBean();
                                        chanYDetailesBean.setTitle(industrysBean.getIndustryTitle() + "--" + industryLevelsBean.getLevelTitle());
                                        chanYDetailesBean.setContent(industryLevelsBean.getLevelContent());
                                        chanYDetailesBean.setIndustryId(industrysBean.getIndustryId());
                                        chanYDetailesData.add(chanYDetailesBean);
                                    }
                                }
                                tvDingwNum.setText(chanYDetailesData.size() + "个二级产业");
                                chanyeDetailAdapter = new ChanyeDetailAdapter(ChanYeDetailsAc.this, chanYDetailesData);
                                lvZone.setOnItemClickListener(listion);
                                lvZone.setAdapter(chanyeDetailAdapter);
                            } else {
                                tvDingwNum.setText("0个二级产业");
                            }

                            //租售物业
                            setRecycleHorizontal(rvZone);
                            setRefreshViewLine(rvZone, R.drawable.item_divider_tran_magin5);
                            final List<ParkDetailsBean.DataBean.BusinessBean> business = data.getBusiness();
                            tvWy.setText(business.size() + "家物业");
                            ZoneAdapter zoneAdapter = new ZoneAdapter(ChanYeDetailsAc.this, business);
                            rvZone.setAdapter(zoneAdapter);
                            zoneAdapter.setOnItemClickListener(new RecycleLabAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, Object item, int position) {
                                    if (business.size() > position) {
                                        startActivity(new Intent(ChanYeDetailsAc.this, PropertyDettailsAc.class).putExtra("id", business.get(position).getBusinessId()).putExtra("title", business.get(position).getBusinessName()));
                                    }
                                }
                            });
                            List<FileBean> files = data.getFiles();
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
                                FileBean filesBean = videoList.get(0);
                                tvVdtitle.setText(filesBean.getFileTitle());
                                videoplayer.setUp(HttpApi.IMAGE_BASE_SERVER + filesBean.getFileAddress(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, filesBean.getFileTitle());
                                GlideImgManager.glideLoader(ChanYeDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + filesBean.getImgPathVideo(), videoplayer.thumbImageView);
                                //视频下载
                                initDownloadVideo(filesBean);
                            } else {
                                pSta.setText("无");
                                flScVideo.setVisibility(View.GONE);
                            }

                            //宣传资料
                            cailSta.setText(pdfList.size() > 0 ? "" : "无");
                            lvCail.setAdapter(new LvGroupAdapter(ChanYeDetailsAc.this, pdfList));
                            lvCail.setOnItemClickListener(listion);

                            //招商员
                            chanceUsers = data.getChanceUsers();
                            imgTeam.setText(chanceUsers.size() + "位成员");
                            chanyeZoneAdapter = new ChanyeZoneAdapter(ChanYeDetailsAc.this, chanceUsers);
                            lvZonePre.setOnItemClickListener(listion);
                            lvZonePre.setAdapter(chanyeZoneAdapter);
                            //联络人
                            umanagers = data.getUsers();

                            if (umanagers.size() > 0) {
                                //联系人
                                lvPer.setAdapter(new LvPublicPerAdapter(ChanYeDetailsAc.this, umanagers));
                                lvPer.setOnItemClickListener(listion);
                            } else {
                                perSta.setText("无");
                            }
                            String createTime = data.getCreateTime();
                            tvData.setText(TextUtils.isEmpty(createTime) ? "无" : DateUtils.getTimes(createTime, "yyyy-MM-dd"));

                            //企业列表
                            stations = data.getStations();
                            ChanyeTeamAdapter chanyeTeamAdapter = new ChanyeTeamAdapter(ChanYeDetailsAc.this, stations);
                            lvZoneTeam.setAdapter(chanyeTeamAdapter);
                            lvZoneTeam.setOnItemClickListener(listion);
                            tvNumgs.setText(data.getStationCount() + "家企业");
                        }
                    }
                });

    }

    /**
     * 视频下载
     */
    private void initDownloadVideo(FileBean fileBean) {
        if (fileBean != null) {
            circleProgress = new CircleProgressHelper(ChanYeDetailsAc.this, btnVddown, downloadVdprogress);
            circleProgress.setItemData(fileBean.getFileAddress(), fileBean.getFileTitle(), fileBean.getFileType(), fileBean.getFileSize());
            circleProgress.refreshState(HttpApi.IMAGE_BASE_SERVER + fileBean.getFileAddress());
        }
    }
//            //下载后提示消息
//            dialog.showConfirm("该文件已下载\n可在个人中心查看文件", "取消", "确认", new DialogCallback<Boolean>() {
//                @Override
//                public void selectResult(Boolean aBoolean) {
//                    Intent intent = new Intent(ChanYeDetailsAc.this, DownloadManageActivity.class);
//                    startActivity(intent);
//                }
//            });

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
    public void ibClickRight() {
        super.ibClickRight();
        if (collectState.equals("1")) {//1:收藏0:未收藏
            delUserCollect();
        } else {
            addUserCollect();
        }
    }

    /**
     * 收藏
     */
    private void addUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectType", "1");
        httpParams.put("objId", parkId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        getParkDetails(false);
                        ToastUtils.showToast(ChanYeDetailsAc.this, "收藏成功");
                    }
                });
    }

    /**
     * 取消收藏
     */
    private void delUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectId", collectId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.delUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        getParkDetails(false);
                        ToastUtils.showToast(ChanYeDetailsAc.this, "取消收藏");
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
            if (lineCount > 6) {
                contentGroup.setMaxLines(6);
            }
            isExpend = false;
            imgExpand.setImageResource(R.mipmap.pull);
        }
    }

    @OnClick({R.id.img_more, R.id.tv_phone, R.id.tv_comp,R.id.img_group, R.id.tv_pic, R.id.vd_share, R.id.tv_dingw_num, R.id.img_team, R.id.ll_moregs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_more:
                startActivity(new Intent(this, WebAc.class).putExtra("title", title).putExtra("url", detailLink));
                break;
            case R.id.ll_moregs:
                startActivity(new Intent(this, EntryAc.class).putExtra("name", data.getParkName()).putExtra("id", data.getParkId()).putExtra("tag", "yuanqu"));
                break;
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
            case R.id.img_group:
            case R.id.tv_pic:
                startActivity(new Intent(this, PicListAc.class).putExtra("objId", parkId).putExtra("pictureType", "0"));
                break;
            case R.id.img_team:
                Drawable nav_team;
                if (!isTeam) {
                    if (chanceUsers.size() >= 3)
                        chanyeZoneAdapter.setItmeNum(chanceUsers.size());
                    isTeam = true;
                    nav_team = getResources().getDrawable(R.mipmap.up);
                } else {
                    if (chanceUsers.size() >= 3)
                        chanyeZoneAdapter.setItmeNum(3);
                    isTeam = false;
                    nav_team = getResources().getDrawable(R.mipmap.pull);
                }
                nav_team.setBounds(0, 0, nav_team.getMinimumWidth(), nav_team.getMinimumHeight());
                imgTeam.setCompoundDrawables(null, null, nav_team, null);
                break;
            case R.id.tv_dingw_num:
                Drawable nav_up;
                if (!isDingw) {
                    if (chanYDetailesData != null && chanYDetailesData.size() >= 6)
                        chanyeDetailAdapter.setItmeNum(chanYDetailesData.size());
                    isDingw = true;
                    nav_up = getResources().getDrawable(R.mipmap.up);
                } else {
                    if (chanYDetailesData != null && chanYDetailesData.size() >= 6)
                        chanyeDetailAdapter.setItmeNum(6);
                    isDingw = false;
                    nav_up = getResources().getDrawable(R.mipmap.pull);
                }
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvDingwNum.setCompoundDrawables(null, null, nav_up, null);
                break;
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
            web.setThumb(new UMImage(ChanYeDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + videoList.get(0).getImgPathVideo()));
            web.setTitle(videoList.get(0).getFileTitle().toString());
            web.setDescription(videoList.get(0).getFileTitle().toString());
            shareDialog.share(new ShareAction(this).withMedia(web),
                    new ShareDialog.OnshareResultListener() {
                        @Override
                        public void onResult(int shareType) {
                            ToastUtils.showToast(ChanYeDetailsAc.this, "分享成功");
                        }

                        @Override
                        public void onError(int shareType) {
                            ToastUtils.showToast(ChanYeDetailsAc.this, "分享失败");
                        }

                        @Override
                        public void onCancle(int shareType) {
                            ToastUtils.showToast(ChanYeDetailsAc.this, "分享取消");
                        }
                    });
            shareDialog.show();
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
        httpParams.put("linkType", Constants.CorrectType.PARK);
        httpParams.put("linkId", parkId);
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(ChanYeDetailsAc.this, "提交成功");
                    }
                });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()) {
            case R.id.lv_cail:
                //pdf预览
                Intent intent = new Intent(this, PdfViewerActivity.class);
                intent.putExtra(Constants.PDF_TITLE, pdfList.get(i).getFileTitle());
                intent.putExtra(Constants.PDF_ADDRESS, HttpApi.IMAGE_BASE_SERVER + pdfList.get(i).getFileAddress());
                intent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_PREVIEW);
                startActivity(intent);
                break;
            case R.id.lv_per:
                Users umanagersBean = umanagers.get(i);

                startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", umanagersBean.getUserAccount()).putExtra("tag", "bendi"));
                break;
            case R.id.lv_zone:
                ChanYDetailesBean chanYDetailesBean = chanYDetailesData.get(i);
                startActivity(new Intent(this, JiQunDetailsAc.class).putExtra("id", chanYDetailesBean.getIndustryId()));
                break;
            case R.id.lv_zone_pre:
                Users chanceUsersBean = chanceUsers.get(i);
                startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", chanceUsersBean.getUserAccount()).putExtra("tag", "bendi"));
                break;
            case R.id.lv_zone_team:
                ParkDetailsBean.DataBean.StationsBean stationsBean = stations.get(i);
                startActivity(new Intent(this, EntryDetailsAc.class).putExtra("id", stationsBean.getStationId()));
                break;

        }

    }
}
