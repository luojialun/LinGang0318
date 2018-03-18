package com.lingang.adapter;

import android.content.Context;
import android.view.View;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.user.UserCorrectDetailsAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.MessagePageListBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 纠错信息-数据适配器
 */
public class UserCorrectAdapter extends RecycleBaseAdapter<MessagePageListBean.DataEntity.ListEntity> {

    private List<MessagePageListBean.DataEntity.ListEntity> mData;
    private Context mContext;
    private DialogTwoCall dialogTwo;

    public UserCorrectAdapter(Context context, List<MessagePageListBean.DataEntity.ListEntity> data) {
        super(context, data);
        mContext = context;
        this.mData = data;
        dialogTwo = new DialogTwoCall(context);
    }

    @Override
    protected void convert(BaseViewHolder holder, final MessagePageListBean.DataEntity.ListEntity item, int position) {
        holder.setText(R.id.user_correct_msg, item.getMessageContent());
        if (2 == item.getMessageState()) {
            holder.setImageResource(R.id.replay_iv, R.mipmap.yihuifu);
        } else {
            holder.setImageResource(R.id.replay_iv, R.mipmap.weihuifu);
        }

        holder.setText(R.id.user_correct_date, DateUtils.getTimestamp(item.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        holder.setOnClickListener(R.id.btnDelete, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTwo.show("取消", "确认", "是否确认要删除？");
                dialogTwo.setDialogListener(new DialogConfirmListion() {
                    @Override
                    public void confirmClick(String sign) {
                        deleteCorrecttHttp(item);
                    }
                });
            }
        });
        holder.setOnClickListener(R.id.user_correct_ll, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserCorrectDetailsAc.goToUserCorrectDetailsAc(mContext, item.getMessageId());
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, MessagePageListBean.DataEntity.ListEntity item) {
        return R.layout.item_user_correct;
    }

    /**
     * 删除纠错内容
     *
     * @param item
     */
    private void deleteCorrecttHttp(final MessagePageListBean.DataEntity.ListEntity item) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("messageIds", item.getMessageId());
        httpParams.put("messageState", Constants.MessageState.delete);
        OkGo.post(HttpApi.UpdateUserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(mContext, false) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) throws JSONException {
                        if (entity.getStateCode().equals(App.stateCode)) {
                            ToastUtils.showToast(mContext, "删除成功");
                            mData.remove(item);
                            notifyDataSetChanged();
                        } else {
                            ToastUtils.showToast(mContext, entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(mContext, "删除失败");
                    }
                });
    }
}
