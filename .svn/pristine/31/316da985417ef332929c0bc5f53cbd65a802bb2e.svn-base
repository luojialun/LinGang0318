package com.lingang.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.SysMsgAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.SysMsgBean;
import com.lingang.callback.RefreshListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.event.UpdateSysmsgEvent;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class MessageAc extends BaseRecycleViewAc implements RefreshListion {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;

    private SysMsgAdapter adapter;
    private List<SysMsgBean.SysMsg> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_message_ac);
        setTitle("系统消息");
        initView();
        getSysMsg(1);
    }

    public void initView() {
        setRefreshHead(refresh);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        setRecycleAspect(recyclerview);
        setRefreshLison(refresh, this);

        adapter = new SysMsgAdapter(this, mList);
        recyclerview.setAdapter(adapter);

    }

    /**
     * 设置全部消息已读
     */
    public void allRead() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ALL_READ).params(params).tag(this).execute(new ResCallBack<BaseEntity<Object, Object>>(this) {
            @Override
            public void onCall(BaseEntity<Object, Object> responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    EventBus.getDefault().post(new UpdateSysmsgEvent());
                }
            }
        });
    }

    @Override
    public void refresh() {
        getSysMsg(1);
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getSysMsg(pageIndex);
    }

    /**
     * 获取系统消息数据
     *
     * @param page
     */
    public void getSysMsg(int page) {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        params.put("pageIndex", page);
        params.put("pageSize", pageSize);
        OkGo.post(HttpApi.SYS_MSG).params(params).tag(this).execute(new ResCallBack<SysMsgBean>(this) {
            @Override
            public void onCall(SysMsgBean responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean && null != responseBean.getData()) {
                    if (null != responseBean.getData().getList()) {
                        if (1 == pageIndex) {
                            mList.clear();
                        }
                        if (null != responseBean.getData().getList()) {
                            mList.addAll(responseBean.getData().getList());
                            adapter.notifyDataSetChanged();
                        }
                        String countRecord = responseBean.getData().getCountRecord() + "";
                        isRefresh(countRecord, pageIndex + "", pageSize + "");
                    }
                    allRead();  //调用全部已读接口
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.refreshCode:
                getSysMsg(1);
                break;
        }
    }
}
