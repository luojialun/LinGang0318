package com.lingang.activity.user;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.dialog.BottomDialog2;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.dialog.ShareDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.ToastUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jason on 17/7/31.
 * 应用分享
 */
public class UserAppShare extends BaseAc implements BottomDialog2.OnItemClickListener ,DialogConfirmListion {

    @BindView(R.id.share_path_iv)
    ImageView sharePathIv;
    @BindView(R.id.install_iv)
    ImageView installIv;
    @BindView(R.id.phone_tv)
    TextView phoneTv;

    private ShareDialog shareDialog;
    private BottomDialog2 bottomDialog2;
    private List<String> bottomList = new ArrayList<>();
    private DialogTwoCall dialogTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_me_share);
        setTitle(getString(R.string.user_app_share));
        shareDialog = new ShareDialog(this);
        initBottomDialog();
        getRightView().setImageResource(R.mipmap.home_more);
        getRightView2().setImageResource(R.mipmap.share_white);
        GlideImgManager.glideLoader(UserAppShare.this, HttpApi.qrcodeShare, sharePathIv);
//        getUserInfo();
        phoneTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTwo = new DialogTwoCall(UserAppShare.this, UserAppShare.this);
                dialogTwo.show("取消", "呼叫", "18916167610");
            }
        });
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

    private void initBottomDialog() {
        bottomList.add("安卓用户安装步骤");
        bottomList.add("苹果用户安装步骤");
        bottomDialog2 = new BottomDialog2(this, bottomList);
        bottomDialog2.setOnItemClickListener(this);
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();

        if (null != bottomDialog2) {
            bottomDialog2.show();
        }
    }

    @Override
    public void ibClickRight2() {
        super.ibClickRight2();
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                    , Manifest.permission.ACCESS_FINE_LOCATION
                    , Manifest.permission.CALL_PHONE
                    , Manifest.permission.READ_LOGS
                    , Manifest.permission.READ_PHONE_STATE
                    , Manifest.permission.READ_EXTERNAL_STORAGE
                    , Manifest.permission.SET_DEBUG_APP
                    , Manifest.permission.SYSTEM_ALERT_WINDOW
                    , Manifest.permission.GET_ACCOUNTS
                    , Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 999);
        } else {
            shareApp();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 999:
                shareApp();
                break;
            case Constants.MY_PERMISSIONS_REQUEST_CALL_PHONE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ToastUtils.showToast(this, "授权成功！"); // 授权成功，继续打电话
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    Uri data = Uri.parse("tel:" + "18916167610");
                    intent.setData(data);
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(intent);
                } else {
                    ToastUtils.showToast(this, "授权失败！"); // 授权失败！
                }
                break;
        }
    }


    /**
     * 刷新二维码
     */
//    private void getUserInfo() {
//        HttpParams httpParams = new HttpParams();
//        httpParams.put("account", LoginManager.getInstance().getLoginAccount());
//        httpParams.put("token", LoginManager.getInstance().getToken());
//        OkGo.post(HttpApi.getUserInfo)
//                .params(httpParams)
//                .execute(new ResCallBack<UserInfoBenBean>(this) {
//                    @Override
//                    public void onCall(UserInfoBenBean addressBean, Call call, Response response) {
//                        if (addressBean.getData() != null) {
//                            GlideImgManager.glideLoader(UserAppShare.this, HttpApi.IMAGE_BASE_SERVER+addressBean.getData().getQrcodeSharePath(), sharePathIv);
//                        }
//                    }
//                });
//
//    }
    public void shareApp() {
//        UMImage image = new UMImage(this, HttpApi.qrcodeShare);//网络图片
//        UMImage image = new UMImage(this, R.mipmap.install);//资源文件
//        image.compressStyle = UMImage.CompressStyle.QUALITY;

        UMWeb web = new UMWeb(HttpApi.shareHtml);
        web.setTitle("i-Lingang");//标题
        web.setThumb(new UMImage(this, R.mipmap.ic_launcher_new));  //缩略图
        web.setDescription("全员招商，资讯及时送达，轻松移动办公");//描述
        shareDialog.share(new ShareAction(this).withMedia(web), new ShareDialog.OnshareResultListener() {
            @Override
            public void onResult(int shareType) {
                LogUtil.d("TAG", "分享成功");
            }

            @Override
            public void onError(int shareType) {
                LogUtil.d("TAG", "分享失败");
            }

            @Override
            public void onCancle(int shareType) {
                LogUtil.d("TAG", "分享取消");
            }
        });
        shareDialog.show();

    }

    /**
     * 跳转到分享页面
     *
     * @param context
     */
    public static void gotoUserAppShare(Context context) {
        Intent intent = new Intent(context, UserAppShare.class);
        context.startActivity(intent);
    }

    @Override
    public void onItemClick(View view, String item, int position) {
        switch (position) {
            case 0:
                installIv.setImageResource(R.mipmap.install);
                break;
            case 1:
                installIv.setImageResource(R.mipmap.install2);
                break;
        }
        bottomDialog2.dismiss();
    }

    @Override
    public void confirmClick(String sign) {
        if (ActivityCompat.checkSelfPermission(UserAppShare.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPiss();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri data = Uri.parse("tel:" + "18916167610");
            intent.setData(data);
            startActivity(intent);
        }

    }
}
