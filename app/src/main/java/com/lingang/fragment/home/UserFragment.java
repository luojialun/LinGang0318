package com.lingang.fragment.home;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoFragment;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.model.TakePhotoOptions;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.login.LoginAc;
import com.lingang.activity.user.DownloadManageActivity;
import com.lingang.activity.user.UserAppShare;
import com.lingang.activity.user.UserCorrectAc;
import com.lingang.activity.user.UserFavoritesAc;
import com.lingang.activity.user.UserInfoAc;
import com.lingang.activity.user.UserRecordAc;
import com.lingang.activity.user.UserSettingAc;
import com.lingang.activity.user.UserSuggestAc;
import com.lingang.activity.user.UserSuggestAddAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.UserInfo;
import com.lingang.callback.PermissionCallback;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.CutPictureUtils;
import com.lingang.utils.PermissionUtils;
import com.lingang.utils.ToastUtils;
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
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

public class UserFragment extends TakePhotoFragment {

    @BindView(R.id.ib_left)
    ImageView ibLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.mine_modify)
    SettingItem mineModify;
    @BindView(R.id.mine_favorites)
    SettingItem mineFavorites;
    @BindView(R.id.mine_download_manage)
    SettingItem mineDownloadManage;
    @BindView(R.id.mine_suggest_feed)
    SettingItem mineSuggestFeed;
    @BindView(R.id.mine_setting)
    SettingItem mineSetting;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    Unbinder unbinder;
    @BindView(R.id.user_info_ll)
    LinearLayout userInfoLl;
    @BindView(R.id.user_icon)
    ImageView userIcon;
    @BindView(R.id.mine_user_name_tv)
    TextView mineUserNameTv;
    @BindView(R.id.mine_user_company_tv)
    TextView mineUserCompanyTv;
    @BindView(R.id.mine_user_nick)
    TextView mineUserNick;
    @BindView(R.id.mine_share)
    SettingItem mineShare;
    /**
     * 用户头像地址备份
     */
    private String userHeadBak = App.Empty;

    private UserFragment forResultChildFragment;

    private Uri imageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshUser();
    }

    /**
     * initView
     */
    private void initView() {
        refresh.setEnableRefresh(false);
        refresh.setEnableLoadmore(false);
        tvTitle.setText(getString(R.string.mine));
        ibLeft.setVisibility(View.GONE);
    }

    /**
     * 刷新用户信息
     */
    private void refreshUser() {
        final UserInfo userInfo = LoginManager.getInstance().getUserInfo();
        if (userInfo != null) {
            mineUserNameTv.setText(userInfo.getUserName());
            mineUserNick.setText(userInfo.getUserName());
            mineUserCompanyTv.setText(userInfo.getUserCompany());
            mineUserNick.setText(userInfo.getUserNickname());
            renderHead(userInfo.getImgPath());
        } else {
            LoginManager.getInstance().clearLogin();
            LoginAc.goToLoginAc(getContext());
        }
    }

    @OnClick({R.id.ib_left, R.id.tv_title, R.id.mine_modify, R.id.mine_favorites, R.id.mine_download_manage, R.id.mine_suggest_feed, R.id.mine_setting, R.id.user_info_ll, R.id.mine_share, R.id.mine_record, R.id.user_icon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_left:
                break;
            case R.id.tv_title:
                break;
            case R.id.user_icon:
                cutPictureUtils = new CutPictureUtils((Activity) this.getContext());
                //申请SD卡权限
                PermissionUtils.checkPermission(getContext(), PermissionUtils.SD_CAMERA_PERMISSIONS, getString(R.string.permission_failed), new PermissionCallback() {
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
            case R.id.mine_modify:
                UserCorrectAc.goToUserCorrectAc(getContext());
                break;
            case R.id.mine_favorites:
                UserFavoritesAc.goToUserFavoritesAc(getContext());
                break;
            case R.id.mine_download_manage:
                DownloadManageActivity.goToDownloadManageActivity(getContext());
                break;
            case R.id.mine_suggest_feed:
//                UserSuggestAc.goUserSuggestFeedAc(getContext());
                startActivityForResult(new Intent(getActivity(), UserSuggestAddAc.class), Constants.SUGGEST_FEEDBACK);
                break;
            case R.id.mine_setting:
                UserSettingAc.goUserSettingAc(getContext());
                break;
            case R.id.user_info_ll:
                UserInfoAc.goToUserInfoAc(getContext());
                break;
            case R.id.mine_share:
                UserAppShare.gotoUserAppShare(getContext());
                break;
            case R.id.mine_record:
                UserRecordAc.goToUserRecordAc(getContext());
                break;
        }
    }

    /*****************************上传头像***********************************/

    private NormalSelectionDialog startDialog;//弹出框
    private CutPictureUtils cutPictureUtils;//裁剪图片

    private void renderHead(final String imgPath) {
        /*if (!TextUtils.isEmpty(imgPath)) {
            if (!userHeadBak.equals(imgPath)) {
                GlideImgManager.glideLoader(getContext(), HttpApi.IMAGE_BASE_SERVER + imgPath, userIcon, new GlideImgManager.LoadImageListener() {
                    @Override
                    public void onSuccess() {
                        userHeadBak = imgPath;
                    }
                    @Override
                    public void onError() {
                        userIcon.setImageResource(R.mipmap.pic);
                    }
                });
            }
        } else {
            userIcon.setImageResource(R.mipmap.pic);
        }*/
        Glide.with(getActivity()).load(HttpApi.IMAGE_BASE_SERVER + imgPath).placeholder(R.mipmap.user_pic).error(R.mipmap.user_pic).into(userIcon);
    }

    private void initImageSelectDialog() {
        ArrayList<String> data = new ArrayList<>();
        data.add("从相册选择");
        data.add("拍照");
        startDialog = new NormalSelectionDialog.Builder(getContext())
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

                        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
                        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
                        imageUri = Uri.fromFile(file);
                        TakePhoto takePhoto = getTakePhoto();
                        configCompress(takePhoto);
                        configTakePhotoOption(takePhoto);

                        if (position == 0) {
//                            choseHeadImageFromGallery();
                            takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
                        } else if (position == 1) {
//                            choseHeadImageFromCameraCapture();
                            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
                        }
                        startDialog.dismiss();
                    }
                })
                .setCanceledOnTouchOutside(false)  //设置是否可点击其他地方取消dialog
                .build();
        startDialog.setDataList(data);
    }

    private CropOptions getCropOptions() {
        int height = 480;
        int width = 480;
        boolean withWonCrop = false;
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setOutputX(width).setOutputY(height);
        builder.setWithOwnCrop(withWonCrop);
        return builder.create();
    }

    private void configCompress(TakePhoto takePhoto) {
        int width = 480;
        int height = 480;
        CompressConfig config = new CompressConfig.Builder()
                .setMaxSize(102400)
                .setMaxPixel(width >= height ? width : height)
                .enableReserveRaw(true)
                .create();
        takePhoto.onEnableCompress(config, true);
    }

    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        builder.setWithOwnGallery(false);
        takePhoto.setTakePhotoOptions(builder.create());
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);

        if (null != result && null != result.getImages() && result.getImages().size() > 0) {
            Glide.with(this).load(new File(result.getImages().get(result.getImages().size() - 1).getCompressPath())).into(userIcon);
        }
        uploadUserHead(result.getImages().get(result.getImages().size() - 1).getCompressPath());

    }

    /*// 从本地相册选取图片作为头像
    private void choseHeadImageFromGallery() {
        Intent intentFromGallery = new Intent();
        // 设置文件类型
        intentFromGallery.setType("image*//*");
        intentFromGallery.setAction(Intent.ACTION_PICK);
        startActivityForResult(intentFromGallery, CutPictureUtils.CODE_GALLERY_REQUEST);
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intentFromCapture = new Intent();
        intentFromCapture.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intentFromCapture.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // 判断存储卡是否可用，存储照片文件
        if (hasSdcard()) {
            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, cutPictureUtils.imageUri);
        }
        startActivityForResult(intentFromCapture, CutPictureUtils.CODE_CAMERA_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // 用户没有进行有效的设置操作，返回
      *//*  if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getContext(), "取消", Toast.LENGTH_LONG).show();
            return;
        }*//*
        switch (requestCode) {
            case CutPictureUtils.CODE_GALLERY_REQUEST:
                if (null != intent && null != intent.getData()) {
                    cutPictureUtils.imageUri = cutPictureUtils.crop((Activity) this.getContext(), intent.getData(), cutPictureUtils.imageUri);
                }
                break;
            case CutPictureUtils.CODE_CAMERA_REQUEST:

                if (hasSdcard()) {
                    cutPictureUtils.imageUri = cutPictureUtils.crop((Activity) this.getContext(), cutPictureUtils.imageUri, cutPictureUtils.imageUri);
                } else {
                    Toast.makeText(getContext(), "没有SDCard!", Toast.LENGTH_LONG).show();
                }
                break;
            case CutPictureUtils.CODE_RESULT_REQUEST:
                if (cutPictureUtils.imageUri != null) {
                    Bitmap bitmap = cutPictureUtils.decodeUriAsBitmap(cutPictureUtils.imageUri);
                    if (bitmap != null) {
                        //bitmap类型图片使用
                        uploadUserHead();
                        userIcon.setImageBitmap(bitmap);
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }


    *//**
     * 检查设备是否存在SDCard的工具方法
     *//*
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }*/

    /**
     * 上传头像
     */
    private void uploadUserHead(String path) {
//        File file = new File(cutPictureUtils.imageUri.getPath());
        File file = new File(path);
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("myFile", file);
        OkGo.post(HttpApi.UserImgUpload)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<UserInfo, Object>>(getContext()) {
                    @Override
                    public void onCall(BaseEntity<UserInfo, Object> userEntity, Call call, Response response) throws JSONException {
                        if (userEntity != null && userEntity.getStateCode().equals(App.stateCode)) {
                            UserInfo userInfo = userEntity.getData();
                            if (userInfo != null) {
                                LoginManager.getInstance().updateUserImage(userInfo.getImgPath());
                            }
                            refreshUser();
                            ToastUtils.showToast(getContext(), "头像修改成功！");
                        }
                    }
                });
    }

    /*****************************上传头像  结束***********************************/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

