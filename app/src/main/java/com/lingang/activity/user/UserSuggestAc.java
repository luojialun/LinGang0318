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
import com.lingang.adapter.UserSuggestFeedAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.MessagePageListBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.dialog.DialogOne;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 意见反馈
 */
public class UserSuggestAc extends BaseAc {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    //数据适配
    private List<MessagePageListBean.DataEntity.ListEntity> dataList;
    private UserSuggestFeedAdapter adapterList;
    //分页
    private PagerHelper pagerHelper;
    private DialogOne dialogOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.recycleview);
        initView();
    }

    /**
     * initView
     */
    private void initView() {
        setTitle(getString(R.string.suggest_feed));
        setRightTv(getString(R.string.suggest));

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) recyclerview.getLayoutParams();
        params.setMargins(0, 30, 0, 0);
        recyclerview.setLayoutParams(params);
        dataList = new ArrayList<>();
        pagerHelper = new PagerHelper(UserSuggestAc.this);

        getRightTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserSuggestAc.this, UserSuggestAddAc.class);
                startActivityForResult(intent, Constants.refreshCode);
            }
        });

        setRecycleSimpleStyle(recyclerview);
        adapterList = new UserSuggestFeedAdapter(UserSuggestAc.this, dataList);
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

    private void handleListHttp() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        httpParams.put("messageType", Constants.MessageType_Suggest);
        OkGo.post(HttpApi.MessagePageList)
                .params(httpParams)
                .execute(new ResCallBack<HomeSearchResponse<MessagePageListBean.DataEntity.ListEntity>>(UserSuggestAc.this, false) {
                    @Override
                    public void onCall(HomeSearchResponse<MessagePageListBean.DataEntity.ListEntity> responseBean, Call call, Response response) {

                        List<MessagePageListBean.DataEntity.ListEntity> list = new ArrayList<MessagePageListBean.DataEntity.ListEntity>();
                        if (responseBean != null && responseBean.getData() != null && null != responseBean.getData().getList()) {
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
                });
    }

    /**
     * 跳转页面
     */
    public static void goUserSuggestFeedAc(Context context) {
        Intent intent = new Intent(context, UserSuggestAc.class);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Constants.refreshCode) {
            dataList.clear();
            pagerHelper.refreshPage();
            adapterList = new UserSuggestFeedAdapter(UserSuggestAc.this, dataList);
            recyclerview.setAdapter(adapterList);
            handleListHttp();

            if (dialogOne == null)
                dialogOne = new DialogOne(this);
            dialogOne.show("您的反馈对我们非常重要，我们将更加努力的改善我们的APP");
        }
    }
}
