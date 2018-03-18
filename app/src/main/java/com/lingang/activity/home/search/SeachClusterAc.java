package com.lingang.activity.home.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.JiQunDetailsAc;
import com.lingang.adapter.ClusterAdapter;
import com.lingang.base.BaseSeachAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ClusterBean;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class SeachClusterAc extends BaseSeachAc implements RefreshListion, RecycleBaseAdapter.OnItemClickListener {
    @BindView(R.id.ll_cluster)
    LinearLayout llCluster;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ArrayList<ClusterBean.DataBean.ListBean> clusterData;
    private ClusterAdapter clusterAdapter;
    private String keyWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_seach_cluster);
        init();
    }

    private void init() {
        clusterData = new ArrayList<>();
        clusterAdapter = new ClusterAdapter(this, clusterData);
        recyclerview.setAdapter(clusterAdapter);
        clusterAdapter.setOnItemClickListener(this);

        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRefreshHead(refresh);
        setRefreshLison(refresh, this);
    }

    private void getIndustry(final String pageIndex, final String pageSize, final boolean isRefresh) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize);
        httpParams.put("keywords", keyWord);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.INDUSTRY)
                .params(httpParams)
                .execute(new ResCallBack<ClusterBean>(this) {
                    @Override
                    public void onCall(ClusterBean cluster, Call call, Response response) {
                        if (isRefresh) {
                            clusterData.clear();
                        }
                        isRefresh(cluster.getData().getCountRecord(),pageIndex,pageSize+"");
                        List<ClusterBean.DataBean.ListBean> list = cluster.getData().getList();
                        clusterData.addAll(list);
                        clusterAdapter.notifyDataSetChanged();
                    }
                });

    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getIndustry(pageIndex + "", pageSize + "", true);
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getIndustry(pageIndex + "", pageSize + "", false);
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, JiQunDetailsAc.class).putExtra("id", clusterData.get(position).getIndustryId()));
    }

    @Override
    public void seachCall(String seachContent) {
        super.seachCall(seachContent);
        keyWord = seachContent;
        llCluster.setVisibility(View.VISIBLE);
        refresh();
    }
}
