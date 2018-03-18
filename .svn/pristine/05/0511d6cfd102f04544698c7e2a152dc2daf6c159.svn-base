package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.DataMapLoginBean;
import com.lingang.bean.UserInfo;
import com.lingang.callback.PermissionCallback;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogError;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.CutPictureUtils;
import com.lingang.utils.PermissionUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.CircleImageView;
import com.lingang.view.SettingItem;
import com.lingang.view.dialog.DialogOnItemClickListener;
import com.lingang.view.dialog.NormalSelectionDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jason on 17/6/12.
 * 我的信息
 */
public class UserInfoAc extends BaseAc implements PopConfirmClinck {

    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.user_name_st)
    SettingItem userNameSt;
    @BindView(R.id.user_park_st)
    SettingItem userParkSt;
    @BindView(R.id.user_dep_st)
    SettingItem userDepSt;
    @BindView(R.id.user_post_st)
    SettingItem userPostSt;
    @BindView(R.id.user_tel_st)
    SettingItem userTelSt;
    @BindView(R.id.user_mobile_st)
    SettingItem userMobileSt;
    @BindView(R.id.user_email_st)
    SettingItem userEmailSt;
    @BindView(R.id.user_head_iv)
    CircleImageView userHeadIv;
    @BindView(R.id.user_nick_st)
    SettingItem userNickSt;
    //    @BindView(R.id.user_info_st)
//    SettingItem userInfoSt;
    @BindView(R.id.select_phone_head)
    RelativeLayout selectPhoneHead;

    private NormalSelectionDialog startDialog;
    private DialogError dialogError;
    /**********裁剪图片************/
    private CutPictureUtils cutPictureUtils = new CutPictureUtils(UserInfoAc.this);

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_user_info);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        renderChangeView();
    }

    private void initView() {
        refresh.setEnableRefresh(false);
        refresh.setEnableLoadmore(false);
        setTitle(getString(R.string.user_info));
        userId = getIntent().getStringExtra("userId");
        if (TextUtils.isEmpty(userId)) {
            getRightView().setImageResource(R.mipmap.error);
        } else {
            updateUserInfo();
        }
    }

    /**
     * 渲染可改变视图
     */
    public void renderChangeView() {
        UserInfo userInfo = LoginManager.getInstance().getUserInfo();
        if (userInfo != null) {
            userNameSt.setRightText(userInfo.getUserName());
            userParkSt.setRightText(userInfo.getUserCompany());
            userDepSt.setRightText(userInfo.getUserDepartment());
            userPostSt.setRightText(userInfo.getUserPost());
            userTelSt.setRightText(userInfo.getUserTel());
            userMobileSt.setRightText(userInfo.getUserMobile());
            userEmailSt.setRightText(userInfo.getUserEmail());
            userNickSt.setRightText(userInfo.getUserNickname());
//            userInfoSt.setRightText(userInfo.getUserDepartment());
            if (!TextUtils.isEmpty(userInfo.getImgPath())) {
                //加载图片
                GlideImgManager.glideLoader(this, HttpApi.IMAGE_BASE_SERVER + userInfo.getImgPath(), userHeadIv, new GlideImgManager.LoadImageListener() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError(String errorInfo) {
                        userHeadIv.setImageResource(R.mipmap.user_pic);
                    }
                });

            } else {
                userHeadIv.setImageResource(R.mipmap.user_pic);
            }
            //身份信息
        }
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (TextUtils.isEmpty(userId)) {
            if (dialogError == null) {
                dialogError = new DialogError(this, this);
            }
            dialogError.show();
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    /**
     * 跳转页面
     *
     * @param context
     */
    public static void goToUserInfoAc(Context context) {
        Intent intent = new Intent(context, UserInfoAc.class);
        context.startActivity(intent);
    }

    public static void goToUserInfoAc(Context context, String userId) {
        Intent intent = new Intent(context, UserInfoAc.class);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }

    @OnClick({R.id.select_phone_head, R.id.user_nick_st})
    public void onViewClicked(View view) {
        if (TextUtils.isEmpty(userId)) {
            switch (view.getId()) {
                case R.id.select_phone_head:
                    //申请SD卡权限
                    PermissionUtils.checkPermission(this, PermissionUtils.SD_PERMISSIONS, getString(R.string.permission_failed), new PermissionCallback() {
                        @Override
                        public void onRequestCallBack(boolean isSuccess) {
                            if (isSuccess) {//具备SD卡访问权限
                                if (startDialog == null) {
                                    initImageSelectDialog();
                                }
                                startDialog.show();
                            }
                        }
                    });
                    break;
                case R.id.user_nick_st:
                    UserNickAc.goToUserNickAc(this);
                    break;
            }
        }
    }

    private void initImageSelectDialog() {
        ArrayList<String> data = new ArrayList<>();
        data.add("从相册选择");
        data.add("拍照选择");
        startDialog = new NormalSelectionDialog.Builder(this)
                .setlTitleVisible(false)   //设置是否显示标题
                .setItemHeight(50)  //设置item的高度
                .setItemWidth(0.9f)  //屏幕宽度*0.9
                .setItemTextColor(R.color.word_black_color_50)  //设置item字体颜色
                .setItemTextSize(16)  //设置item字体大小
                .setCancleButtonText("取消")  //设置最底部“取消”按钮文本
                .setCancleButtonTextColor(R.color.black)
                .setCanceledOnTouchOutside(false)
                .setCancleButtonTextSize(16)
                .setOnItemListener(new DialogOnItemClickListener() {
                    @Override
                    public void onItemClick(Button button, List data, int position) {
                        if (position == 0) {
                            choseHeadImageFromGallery();
                        } else if (position == 1) {
                            choseHeadImageFromCameraCapture();
                        }
                        startDialog.dismiss();
                    }
                })
                .setCanceledOnTouchOutside(false)  //设置是否可点击其他地方取消dialog
                .build();
        startDialog.setDataList(data);
    }

    // 从本地相册选取图片作为头像
    private void choseHeadImageFromGallery() {
        Intent intentFromGallery = new Intent();
        // 设置文件类型
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_PICK);
        startActivityForResult(intentFromGallery, CutPictureUtils.CODE_GALLERY_REQUEST);
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可用，存储照片文件
        if (hasSdcard()) {
            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, cutPictureUtils.imageUri);
        }
        startActivityForResult(intentFromCapture, CutPictureUtils.CODE_CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }
        switch (requestCode) {
            case CutPictureUtils.CODE_GALLERY_REQUEST:
                cutPictureUtils.imageUri = cutPictureUtils.crop(UserInfoAc.this, intent.getData(), cutPictureUtils.imageUri);
                break;
            case CutPictureUtils.CODE_CAMERA_REQUEST:
                if (hasSdcard()) {
                    cutPictureUtils.imageUri = cutPictureUtils.crop(UserInfoAc.this, cutPictureUtils.imageUri, cutPictureUtils.imageUri);
                } else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }
                break;
            case CutPictureUtils.CODE_RESULT_REQUEST:
                if (cutPictureUtils.imageUri != null) {
                    Bitmap bitmap = cutPictureUtils.decodeUriAsBitmap(cutPictureUtils.imageUri);
                    if (bitmap != null) {
                        //bitmap类型图片使用
                        uploadUserHead();
                        userHeadIv.setImageBitmap(bitmap);
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }

    /**
     * 上传头像
     */
    private void uploadUserHead() {
        File file = new File(cutPictureUtils.imageUri.getPath());
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("myFile", file);
        OkGo.post(HttpApi.UserImgUpload)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<UserInfo, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<UserInfo, Object> userEntity, Call call, Response response) throws JSONException {
                        if (userEntity != null && userEntity.getStateCode().equals(App.stateCode)) {
                            UserInfo userInfo = userEntity.getData();
                            if (userInfo != null) {
                                LoginManager.getInstance().updateUserImage(userInfo.getImgPath());
                            }
                            renderChangeView();
                            ToastUtils.showToast(UserInfoAc.this, "头像修改成功！");
                        }
                    }
                });
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
        httpParams.put("linkType", Constants.CorrectType.Mine);
        httpParams.put("linkId", LoginManager.getInstance().getUserInfo().getUserId());
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(UserInfoAc.this, "提交成功");
                    }
                });
    }

    /**
     * 更新用户信息
     */
    private void updateUserInfo() {
        String pwd = LoginManager.getInstance().getUserInfo().getUserPassword() != null ? String.valueOf(LoginManager.getInstance().getUserInfo().getUserPassword()) : "";
        HttpParams httpParams = new HttpParams();
        httpParams.put("account", LoginManager.getInstance().getLoginAccount());
        httpParams.put("pwd", pwd);
        httpParams.put("loginType", Constants.LoginType.defaultNormal);
        httpParams.put("terminalType", "1");
        OkGo.post(HttpApi.LOGIN_URL)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<UserInfo, DataMapLoginBean>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<UserInfo, DataMapLoginBean> user, Call call, Response response) {
                        //储存用户账号密码
                        UserInfo userInfo = user.getData();
                        userInfo.setUserPassword(LoginManager.getInstance().getUserInfo().getUserPassword());
                        userInfo.setToken(LoginManager.getInstance().getToken());
                        LoginManager.getInstance().saveUserInfo(userInfo);

                        renderChangeView();
                    }
                });
    }
}
