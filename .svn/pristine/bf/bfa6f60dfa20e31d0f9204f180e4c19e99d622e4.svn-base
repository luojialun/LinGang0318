package com.lingang.dialog;

import android.content.Context;

import com.lingang.App;
import com.lingang.bean.BaseEntity;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jason on 17/6/15.
 * 收藏弹出框
 */
public class FavoritesDialog {
    private DialogTwoCall dialogTwo;
    private Context mContext;
    private DialogClickCallback callback;
    public FavoritesDialog(Context context) {
        mContext=context;
        dialogTwo=new DialogTwoCall(context);
    }

    public void show(int collectId)
    {
        show(collectId,null);
    }
    /**
     *显示弹出框
     * @param collectId
     */
    public void show(final int collectId,DialogClickCallback callback)
    {
        this.callback=callback;
        dialogTwo.show("取消", "确认", "是否确认取消收藏？");
        dialogTwo.setDialogListener(new DialogConfirmListion() {
            @Override
            public void confirmClick(String sign) {
                delUserCollectHttp(collectId);
            }
        });
    }
    /**
     * 取消收藏
     * @param collectId
     */
    private void delUserCollectHttp(int collectId) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("collectId", collectId);
        OkGo.post(HttpApi.delUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(mContext,false) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) throws JSONException {
                        if(entity.getStateCode().equals(App.stateCode)) {
                            ToastUtils.showToast(mContext, "取消成功");
//                            mData.remove(item);
//                            notifyDataSetChanged();
                            if(callback !=null)
                            {
                                callback.clickCallback(Constants.DialogSelectType.ok);
                            }
                        }else
                        {
                            ToastUtils.showToast(mContext, entity.getMessage());
                            if(callback !=null)
                            {
                                callback.clickCallback(Constants.DialogSelectType.cancel);
                            }
                        }
                    }
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(mContext,"取消失败");
                    }
                });
    }
    /**
     * 设置回调
     * @param clickCallback
     */
    public void setDialogClickCallback(DialogClickCallback clickCallback)
    {
        this.callback=clickCallback;
    }
    public interface DialogClickCallback
    {
        //返回类型参考：Constants.DialogSelectType
        void clickCallback(int selectType);
    }
}
