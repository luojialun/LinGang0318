package com.lingang.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.adapter.NoticeAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.NoticeBean;
import com.lingang.callback.RefreshListion;
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

public class NoticeAc extends BaseRecycleViewAc implements RecycleBaseAdapter.OnItemClickListener, RefreshListion {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private List<NoticeBean.DataBean.ListBean> data;
    private NoticeAdapter noticeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_notice);
        setTitle("系统公告");
        initView();
        allRead();
        getNotice(pageIndex + "");
    }


    private void initView() {
        data = new ArrayList<>();
        noticeAdapter = new NoticeAdapter(this, data);
        noticeAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(noticeAdapter);

        setRefreshHead(refresh);
        setRefreshViewLine(recyclerview, R.drawable.item_divider_tran);
        setRecycleAspect(recyclerview);

        setRefreshLison(refresh, this);
    }

    /**
     * 全部消息已读
     */
    public void allRead() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        params.put("messageType", "9");
        OkGo.post(HttpApi.ALL_READ).params(params).tag(this).execute(new ResCallBack<BaseEntity<Object, Object>>(this) {
            @Override
            public void onCall(BaseEntity<Object, Object> responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    EventBus.getDefault().post(new UpdateSysmsgEvent());
                }
            }
        });
    }


    private void getNotice(final String pageIndex) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex + "");
        httpParams.put("pageSize", pageSize + "");
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.EnterpriseNotice)
                .params(httpParams)
                .execute(new ResCallBack<NoticeBean>(this) {
                    @Override
                    public void onCall(NoticeBean notice, Call call, Response response) {

                        if (pageIndex.equals("1")) {
                            data.clear();
                        }

                        isRefresh(notice.getData().getCountRecord(), pageIndex, pageSize + "");

                        data.addAll(notice.getData().getList());
                        noticeAdapter.notifyDataSetChanged();
                        Log.e("NOTICE", notice.getStateCode());
                    }
                });
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, NoticeDetailsAc.class).putExtra("id", data.get(position).getEnterpriseId()));
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getNotice(pageIndex + "");
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getNotice(pageIndex + "");
    }
}
