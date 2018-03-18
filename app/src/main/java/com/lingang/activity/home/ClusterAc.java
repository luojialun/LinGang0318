package com.lingang.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.ClusterAdapter;
import com.lingang.base.BaseRecycleViewAc;
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

/*产业集群*/
public class ClusterAc extends BaseRecycleViewAc implements RefreshListion, RecycleBaseAdapter.OnItemClickListener {
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
        contentView(R.layout.activity_cluster);
//        getRightView().setImageResource(R.mipmap.search);
        setTitle("产业集群");
        init();
        getIndustry(pageIndex + "");
    }

    //    @Override
//    public void ibClickRight() {
//        startActivity(new Intent(this, SeachClusterAc.class));
//    }
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

    private void getIndustry(final String pageIndex) {
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
                        if (pageIndex.equals("1")) {
                            clusterData.clear();
                        }
                        isRefresh(cluster.getData().getCountRecord(), pageIndex, pageSize + "");
                        List<ClusterBean.DataBean.ListBean> list = cluster.getData().getList();
                        clusterData.addAll(list);
                        clusterAdapter.notifyDataSetChanged();
                    }
                });

    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getIndustry(pageIndex + "");
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getIndustry(pageIndex + "");
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, JiQunDetailsAc.class).putExtra("id", clusterData.get(position).getIndustryId()));
    }
}
