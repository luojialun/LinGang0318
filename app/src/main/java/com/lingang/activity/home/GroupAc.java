package com.lingang.activity.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.LvGroupAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.FileBean;
import com.lingang.bean.GroupIntroBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.common.CircleProgressHelper;
import com.lingang.common.Constants;
import com.lingang.common.DownloadFileEnum;
import com.lingang.common.LoginManager;
import com.lingang.common.MapType;
import com.lingang.dialog.BottomDialog2;
import com.lingang.dialog.DialogError;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.dialog.ShareDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.MapUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AlignTextView;
import com.lingang.view.CustomCircleProgress;
import com.lingang.view.ExtraListView;
import com.lingang.view.ObservableScrollView;
import com.lingang.view.RefreshView;
import com.lingang.view.video.JCVPlayerTitleAfterFull;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.Call;
import okhttp3.Response;

public class GroupAc extends BaseAc implements DialogConfirmListion,
        AdapterView.OnItemClickListener, PopConfirmClinck {
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
    @BindView(R.id.tv_map)
    TextView tvMap;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_comp)
    TextView tvComp;
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
    @BindView(R.id.fl_sc_video)
    LinearLayout flScVideo;
    @BindView(R.id.sc_group)
    ObservableScrollView scGroup;
    @BindView(R.id.refreshlayout)
    TwinklingRefreshLayout refreshlayout;
    private boolean isExpend = false;
    private DialogTwoCall dialogTwo;
    private String phone;
    private GroupIntroBean.DataBean data;
    private AdapterView.OnItemClickListener itemClick;
    private ArrayList<FileBean> pdfList;
    private DialogError dialogError;
    private String basicsId;
    private ShareDialog shareDialog;
    private ArrayList<FileBean> videoList;
    private CircleProgressHelper circleProgress;

    private BottomDialog2 bottomDialog2;
    private List<String> bottomList = new ArrayList<>();
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_group);
        setTitle("临港集团");
        itemClick = this;
        getRightView().setImageResource(R.mipmap.error);
        initView();
        initBottomDialog();

    }

    private void initView() {
        RefreshView headerView = new RefreshView(this);
        refreshlayout.setHeaderView(headerView);
        refreshlayout.setEnableLoadmore(false);
        refreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                getGroupIntroduction();
            }
        });
        refreshlayout.startRefresh();
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
                        MapUtils.goBaiduMap(GroupAc.this, address);
                        break;
                    case MapType.GAODE:
                        MapUtils.goGaodeMap(GroupAc.this, address);
                        break;
                }
                bottomDialog2.dismiss();
            }
        });
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (dialogError == null) {
            dialogError = new DialogError(this, this);
        }
        dialogError.show();
    }

    //获取新闻详情
    private void getGroupIntroduction() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GROUPINTRODUCTIONDETAILS)
                .params(httpParams)
                .execute(new ResCallBack<GroupIntroBean>(this) {
                    @Override
                    public void onCall(GroupIntroBean groupintrobean, Call call, Response response) {
                        refreshlayout.finishRefreshing();
                        data = groupintrobean.getData();
                        basicsId = data.getBasicsId();

                        if(TextUtils.isEmpty(data.getDetailLink())){
                            imgMore.setVisibility(View.GONE);
                        }

                        GlideImgManager.glideLoader(GroupAc.this, HttpApi.IMAGE_BASE_SERVER + data.getMaxImgPath(), imgGroup);
                        contentGroup.setContent(data.getBusinessContent());

                        address=data.getBusinessAddress();
                        tvMap.setText(address);
                        if (!TextUtils.isEmpty(address)) {
                            tvMap.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (bottomList.size() > 0) {
                                        bottomDialog2.show();
                                    } else {
                                        ToastUtils.showToast(GroupAc.this, "请安装百度或者高德地图进行导航");
                                    }
                                }
                            });
                        }

                        List<GroupIntroBean.DataBean.WaysBean> ways = data.getWays();
                        if (ways.size() > 0) {
                            StringBuilder phone = new StringBuilder("");
                            for (GroupIntroBean.DataBean.WaysBean waysBean :
                                    ways) {
                                phone.append(waysBean.getWayTel() + "  ");
                            }
                            tvPhone.setText(phone);
                        }

                        tvComp.setText(data.getBusinessLink());

                        List<FileBean> files = data.getFiles();
                        videoList = new ArrayList<>();
                        pdfList = new ArrayList<>();
                        for (FileBean filesBean :
                                files) {
                            if (filesBean.getFileType().equals(String.valueOf(DownloadFileEnum.pdf))) {//pdf
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
                            GlideImgManager.glideLoader(GroupAc.this, HttpApi.IMAGE_BASE_SERVER + fileBean.getImgPathVideo(), videoplayer.thumbImageView);
                            //视频下载
                            initDownloadVideo(fileBean);
                        } else {
                            flScVideo.setVisibility(View.GONE);
                        }
                        //宣传资料
                        lvCail.setAdapter(new LvGroupAdapter(GroupAc.this, pdfList));
                        lvCail.setOnItemClickListener(itemClick);
                        scGroup.smoothScrollTo(0, 0);
                    }
                });
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

    @OnClick({R.id.img_expand, R.id.tv_phone, R.id.tv_comp, R.id.img_more, R.id.vd_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_more:
                if (data != null) {
                    startActivity(new Intent(this, WebAc.class).putExtra("title", getTitleView().getText().toString()).putExtra("url", data.getDetailLink()));
                }
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
                    if (lineCount > 6) {
                        contentGroup.setMaxLines(6);
                    }
                    isExpend = false;
                    imgExpand.setImageResource(R.mipmap.pull);
                }
                break;
            case R.id.tv_phone:
                phone = tvPhone.getText().toString();
                if (dialogTwo == null)
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
            case R.id.vd_share:
                shareVideo();
                break;
        }
    }

    /**
     * 视频下载
     */
    private void initDownloadVideo(FileBean fileBean) {
        if (fileBean != null) {
            circleProgress = new CircleProgressHelper(GroupAc.this, btnVddown, downloadVdprogress);
            circleProgress.setItemData(fileBean.getFileAddress(), fileBean.getFileTitle(), fileBean.getFileType(), fileBean.getFileSize());
            circleProgress.refreshState(HttpApi.IMAGE_BASE_SERVER + fileBean.getFileAddress());
        }
    }

    //分享视频
    private void shareVideo() {
        if (shareDialog == null) {
            shareDialog = new ShareDialog(this);
        }
        if (videoList.size() > 0) {
            UMWeb web = new UMWeb(HttpApi.IMAGE_BASE_SERVER + "/" + videoList.get(0).getShareUrl());
            web.setThumb(new UMImage(GroupAc.this,HttpApi.IMAGE_BASE_SERVER + videoList.get(0).getImgPathVideo()));
            web.setTitle(videoList.get(0).getFileTitle().toString());
            web.setDescription(videoList.get(0).getFileTitle().toString());
            shareDialog.share(new ShareAction(this).withMedia(web),
                    new ShareDialog.OnshareResultListener() {
                @Override
                public void onResult(int shareType) {
                    ToastUtils.showToast(GroupAc.this, "分享成功");
                }

                @Override
                public void onError(int shareType) {
                    ToastUtils.showToast(GroupAc.this, "分享失败");
                }

                @Override
                public void onCancle(int shareType) {
                    ToastUtils.showToast(GroupAc.this, "分享取消");
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, PdfViewerActivity.class);
        intent.putExtra(Constants.PDF_TITLE, pdfList.get(i).getFileTitle());
        intent.putExtra(Constants.PDF_ADDRESS, HttpApi.IMAGE_BASE_SERVER + pdfList.get(i).getFileAddress());
        intent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_PREVIEW);
        startActivity(intent);
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
        httpParams.put("linkId", basicsId);
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(GroupAc.this, "提交成功");
                    }
                });
    }

//    @Override
//    public void scollChange(int x, int y, int oldx, int oldy) {
//        if (instance == null) {
//            instance = ScreenSizeUtils.getInstance(this);
//        }
//
//        if (!instance.viewInScreen(videoplayer)) {
//            videoplayer.startWindowTiny();
//        }else {
//            videoplayer.stop
//        }
//
//        Log.e("sss",""+instance.viewInScreen(videoplayer));
//    }
}
