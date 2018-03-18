package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.adapter.UserCorrectAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.MessagePageListBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 信息纠错
 */
public class UserCorrectAc extends BaseRecycleViewAc {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    //数据适配
    private List<MessagePageListBean.DataEntity.ListEntity> dataList;
    private UserCorrectAdapter adapterList;
    //分页
    private PagerHelper pagerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.recycleview);
        initView();
    }

    /**
     * 全部设为已读
     */
    @Override
    public void ibClickRight() {
        HttpParams params=new HttpParams();
        params.put("token",LoginManager.getInstance().getToken());
        params.put("messageType","1");
        OkGo.post(HttpApi.CORRECT_READ_ALL).params(params).tag(this).execute(new ResCallBack<String>(this) {
            @Override
            public void onCall(String s, Call call, Response response) throws JSONException {
                dataList.clear();
                pagerHelper.refreshPage();
                handleListHttp();
            }
        });
    }

    private void initView() {
        setTitle(getString(R.string.correct));
        setRightTv("全部设为已读");
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) recyclerview.getLayoutParams();
        params.setMargins(0, 30, 0, 0);
        recyclerview.setLayoutParams(params);
        dataList = new ArrayList<>();
        pagerHelper = new PagerHelper(UserCorrectAc.this);

        setRecycleSimpleStyle(recyclerview);
        adapterList = new UserCorrectAdapter(UserCorrectAc.this, dataList);
        recyclerview.setAdapter(adapterList);
        setRefreshHead(refresh);
        refresh.startRefresh();
        refresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                dataList.clear();
                pagerHelper.refreshPage();
                handleListHttp();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                if (pagerHelper.loadMore()) {
                    handleListHttp();
                } else {
                    refreshLayout.finishLoadmore();
                }
            }
        });
    }

    /**
     *数据列表详情
     */
    private void handleListHttp() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        httpParams.put("messageType", Constants.MessageType_Correct);
        OkGo.post(HttpApi.MessagePageList)
                .params(httpParams)
                .execute(new ResCallBack<HomeSearchResponse<MessagePageListBean.DataEntity.ListEntity>>(UserCorrectAc.this, false) {
                    @Override
                    public void onCall(HomeSearchResponse<MessagePageListBean.DataEntity.ListEntity> responseBean, Call call, Response response) {
                        List<MessagePageListBean.DataEntity.ListEntity> list = new ArrayList<MessagePageListBean.DataEntity.ListEntity>();
                        if (null != responseBean.getData() && null != responseBean.getData().getList()) {
                            list = responseBean.getData().getList();
                            dataList.addAll(list);
                            adapterList.notifyDataSetChanged();
                        }
                        if (pagerHelper.loadFinish(list.size())) {
                            refresh.finishRefreshing();
                        } else {
                            refresh.finishLoadmore();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        if (pagerHelper.isRefresh()) {
                            refresh.finishRefreshing();
                        } else {
                            refresh.finishLoadmore();
                        }
                    }
                });
    }

    /**
     * 跳转页面
     */
    public static void goToUserCorrectAc(Context context) {
        Intent intent = new Intent(context, UserCorrectAc.class);
        context.startActivity(intent);
    }
}
