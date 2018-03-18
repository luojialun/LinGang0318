package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.UserInfo;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 昵称修改
 */
public class UserNickAc extends BaseAc {
    @BindView(R.id.user_nick_ed)
    EditText userNickEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_user_change_nick);
        initView();
    }

    /**
     *
     */
    private void initView() {
        setTitle(getString(R.string.nick));
        setRightTv(getString(R.string.save));
        UserInfo userInfo = LoginManager.getInstance().getUserInfo();
        if (userInfo != null) {
            userNickEd.setText(userInfo.getUserNickname());
        }

        getRightTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNick();
            }
        });
    }
    private void saveNick()
    {
        final String nickName=userNickEd.getText().toString().trim();
        if(TextUtils.isEmpty(nickName))
        {
            userNickEd.findFocus();
            ToastUtils.showToast(UserNickAc.this,getString(R.string.nick_empty));
            return;
        }

        HttpParams httpParams = new HttpParams();
        httpParams.put("token",LoginManager.getInstance().getToken());
        httpParams.put("userId",LoginManager.getInstance().getUserInfo().getUserId());
        httpParams.put("userNickname",nickName);
        OkGo.post(HttpApi.UpdateUser)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<UserInfo,Object>>(UserNickAc.this) {
                    @Override
                    public void onCall(BaseEntity<UserInfo,Object> responseData, Call call, Response response) {
                        if(responseData !=null && responseData.getStateCode().equals(App.stateCode))
                        {
//                            UserInfo userInfo=responseData.getData();
                           LoginManager.getInstance().setNickName(nickName);
//                            LoginManager.getInstance().saveUserInfo(userInfo);

                            ToastUtils.showToast(UserNickAc.this,getString(R.string.save_success));
                            finish();
                        }
                    }
                });
    }

    /**
     * 页面跳转
     * @param context
     */
    public static void goToUserNickAc(Context context)
    {
        Intent intent=new Intent(context,UserNickAc.class);
        context.startActivity(intent);
    }
}
