package com.lingang.activity.business;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lingang.R;
import com.lingang.activity.user.UserBigHeadAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.JobInfoBean;
import com.lingang.bean.UserInfoBenBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class PersonInfoActivity extends BaseAc implements DialogConfirmListion {

    @BindView(R.id.img_userhead)
    ImageView imgUserhead;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_userstation)
    TextView tvUserstation;
    @BindView(R.id.tv_homeline)
    TextView tvHomeline;
    @BindView(R.id.tv_directline)
    TextView tvDirectline;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    private DialogTwoCall dialogTwo;
    private UserInfoBenBean.DataBean data;
    private String tag;
    private String imguserid;
    private String userPic;
    private JobInfoBean.DataBean dataBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_person_indo);
        setTitle("个人主页");
        getRightTextView().setText("保存联系人");

        tag = getIntent().getStringExtra("tag");
        String userid = getIntent().getStringExtra("userid");
        imguserid = getIntent().getStringExtra("imguserid");

        if (!TextUtils.isEmpty(tag) && tag.equals("oa")) {//第三方接口
            getJobInfo(userid);
            if (!TextUtils.isEmpty(imguserid)) {
//                getUserHeaderImg(imguserid);
//                String imgUrl = "https://apptest.shlingang.com/lingang-consumer/apiUtil/getUserPhoto.do?token=8E1BBC05281E4F1AAFF98D32B2F02950&userid=E07BE549-45B1-4414-BD43-1DA6621AD202";
                String imgUrl = HttpApi.HEADER + "?token=" + LoginManager.getInstance().getToken() + "&userid=" + imguserid;
                //Log.i("TAG", "imgUrl-->" + imgUrl);
                GlideImgManager.glideLoaderHead(this, imgUrl, imgUserhead);

            }
        } else {//本地接口
            getuserInfo(userid);
        }
    }

   /* private void getUserHeaderImg(String imguserid) {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        params.put("userid", "E07BE549-45B1-4414-BD43-1DA6621AD202");
        OkGo.post(HttpApi.HEADER).params(params).tag(this).execute(new ResCallBack<String>(this) {
            @Override
            public void onCall(String s, Call call, Response response) throws JSONException {
                Log.i("TAG", "getUserHeaderImg-->" + s);
                //GlideImgManager.glideLoaderHead(PersonInfoActivity.this, s, imgUserhead);
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                Log.i("TAG", e.toString());
            }
        });
    }*/

    @Override
    public void ibClickRight() {
        super.ibClickRight();

        if (!TextUtils.isEmpty(tag) && tag.equals("oa")) {//第三方接口
            if (dataBean != null)
                seveTx();
        } else {//本地接口
            if (data != null)
                seveTx2();
        }

    }

    private void seveTx2() {
        Intent it = new Intent(Intent.ACTION_INSERT,
                Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
        it.setType("vnd.android.cursor.dir/person");
        // it.setType("vnd.android.cursor.dir/contact");
        // it.setType("vnd.android.cursor.dir/raw_contact");
        // 联系人姓名
        it.putExtra(ContactsContract.Intents.Insert.NAME, tvUsername.getText().toString());
        // 公司
        it.putExtra(ContactsContract.Intents.Insert.COMPANY, data.getUserCompany());
        // email
        it.putExtra(ContactsContract.Intents.Insert.EMAIL, tvEmail.getText().toString());
        it.putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, "邮箱");
        // 手机号码
        it.putExtra(ContactsContract.Intents.Insert.PHONE, tvPhone.getText().toString());
        it.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, "手机");
        // 单位电话
//        it.putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE, tvHomeline.getText().toString());
//        it.putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE_TYPE,"内线电话");
        // 住宅电话
        it.putExtra(ContactsContract.Intents.Insert.TERTIARY_PHONE, tvDirectline.getText().toString());
        it.putExtra(ContactsContract.Intents.Insert.TERTIARY_PHONE_TYPE, "工作");
        // 职位信息
        it.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, data.getUserPost() + "-" + data.getUserDepartment());

        startActivity(it);
    }

    private void seveTx() {
        Intent it = new Intent(Intent.ACTION_INSERT,
                Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
        it.setType("vnd.android.cursor.dir/person");
        // it.setType("vnd.android.cursor.dir/contact");
        // it.setType("vnd.android.cursor.dir/raw_contact");
        // 联系人姓名
        it.putExtra(ContactsContract.Intents.Insert.NAME, tvUsername.getText().toString());
        // 公司
        it.putExtra(ContactsContract.Intents.Insert.COMPANY, dataBean.getCompanyName());
        // email
        it.putExtra(ContactsContract.Intents.Insert.EMAIL, tvEmail.getText().toString());
        it.putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, "邮箱");
        // 手机号码
        it.putExtra(ContactsContract.Intents.Insert.PHONE, tvPhone.getText().toString());
        it.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, "手机");
        // 单位电话
//        it.putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE, tvHomeline.getText().toString());
//        it.putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE_TYPE,"内线电话");
        // 住宅电话
        it.putExtra(ContactsContract.Intents.Insert.TERTIARY_PHONE, tvDirectline.getText().toString());
        it.putExtra(ContactsContract.Intents.Insert.TERTIARY_PHONE_TYPE, "工作");
        // 职位信息
        it.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, dataBean.getJobName() + "-" + dataBean.getGroupName());

        ArrayList<ContentValues> data = new ArrayList<>();
        ContentValues row = new ContentValues();
        row.put(ContactsContract.CommonDataKinds.Organization.COMPANY, "Android");
        it.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, data);

        startActivity(it);
    }

    //获取用户信息  第三方
/*    private void getUserInfo(String userid) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("Userid", userid);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GetUserInfo)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<String, Object> addressBean, Call call, Response response) {
                        String result = addressBean.getData();
                        Gson gson = new Gson();
                        GetUserInfoBean userInfo = gson.fromJson(result.replaceAll("\\\\", ""), GetUserInfoBean.class);
                        if (userInfo != null) {
                            setUserInfo(userInfo);
                        }
                    }
                });
    }*/

    //获取用户信息  第三方
    private void getJobInfo(String userid) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("Jobid", userid);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getJobInfo)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<String, Object> addressBean, Call call, Response response) {
                        String result = addressBean.getData();
                        Gson gson = new Gson();
                        JobInfoBean userInfo = gson.fromJson(result.replaceAll("\\\\", ""), JobInfoBean.class);
                        List<JobInfoBean.DataBean> data = userInfo.getData();
                        if (data.size() != 0) {
                            dataBean = data.get(0);
                            setUserInfo();
                        }
                    }
                });
    }

    //获取用户信息   本地
    private void getuserInfo(String userid) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("account", userid);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getUserInfo)
                .params(httpParams)
                .execute(new ResCallBack<UserInfoBenBean>(this) {
                    @Override
                    public void onCall(UserInfoBenBean addressBean, Call call, Response response) {

                        if (addressBean.getData() != null) {
                            data = addressBean.getData();
                            setUserInfoBen();
                        }
                    }
                });
    }

    //本地服务器数据
    private void setUserInfoBen() {
        tvEmail.setText(data.getUserEmail());           //电子邮箱
        tvPhone.setText(data.getUserMobile());          //手机号码
        tvDirectline.setText(data.getUserTel());        //直线电话
        tvHomeline.setText(data.getIpphone());          //内线电话
        tvUserstation.setText(data.getUserPost() + "-" + data.getUserDepartment() + "\n" + data.getUserCompany());
        tvUsername.setText(data.getUserName());

        userPic = HttpApi.IMAGE_BASE_SERVER + data.getImgPath();
        GlideImgManager.glideLoaderHead(this, HttpApi.IMAGE_BASE_SERVER + data.getImgPath(), imgUserhead);

    }

    //第三方服务器数据
    private void setUserInfo() {
        tvEmail.setText(getIntent().getStringExtra("email"));//电子邮箱
        tvPhone.setText(getIntent().getStringExtra("mb"));   //手机号码
        tvDirectline.setText(dataBean.getDirectTel());       //直线电话
        tvHomeline.setText(dataBean.getInnnerTel());         //内线电话
        tvUserstation.setText(dataBean.getJobName() + "-" + dataBean.getGroupName() + "\n" + dataBean.getCompanyName());
        tvUsername.setText(getIntent().getStringExtra("name"));

       // GlideImgManager.glideLoaderHead(this, getIntent().getStringExtra("photo"), imgUserhead);

    }

    @OnClick({R.id.ll_neix, R.id.ll_zhix, R.id.ll_phone, R.id.ll_email, R.id.btn_msg, R.id.btn_phone, R.id.btn_email})
    public void onViewClicked(View view) {//R.id.btn_wx,
        if (dialogTwo == null) {
            dialogTwo = new DialogTwoCall(this, this);
        }
        switch (view.getId()) {
            case R.id.ll_neix:
                dialogTwo.show("取消", "呼叫", tvHomeline.getText().toString());
                break;
            case R.id.ll_zhix:
                dialogTwo.show("取消", "呼叫", tvDirectline.getText().toString());
                break;
            case R.id.btn_phone:
            case R.id.ll_phone:
                dialogTwo.show("取消", "呼叫", tvPhone.getText().toString());
                break;
            case R.id.btn_msg:
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + tvPhone.getText().toString())));
                break;
//            case R.id.btn_wx:
//                break;
            case R.id.ll_email:
            case R.id.btn_email:
                startActivity(new Intent(Intent.ACTION_SENDTO).setData(Uri.parse("mailto:" + tvEmail.getText().toString())));
                break;
        }
    }

    @Override
    public void confirmClick(String sign) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPiss();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri data = Uri.parse("tel:" + sign);
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

    @OnClick(R.id.img_userhead)
    public void onViewClicked() {
//        if (!TextUtils.isEmpty(userPic))
        startActivity(new Intent(this, UserBigHeadAc.class).putExtra("pic", userPic));
    }
}
