package com.lingang.fragment.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.PolicyDetialesAc;
import com.lingang.adapter.PolicyListAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.PolicyListBean;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @name LinGang
 * @class name：com.lingang.fragment.other
 * @class describe
 * @anthor Administrator
 * @time 2017/5/31 0031 11:21
 * @change
 * @chang time
 * @class describe
 */
public class SeachPolicyFragment extends BaseFragment implements RefreshListion ,RecycleBaseAdapter.OnItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private String basicsId = "";
    Unbinder unbinder;
    private ArrayList<PolicyListBean.DataBean.ListBean> clusterData;
    private PolicyListAdapter clusterAdapter;
    private String keywords = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.policy_fragment, null);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        basicsId = (String) arguments.get("basicsId");
        keywords = (String) arguments.get("keyword");
        refresh();
    }

    public void seachData(String keyword){
        this.keywords = keyword;
        refresh();
    }

    private void initView() {
        clusterData = new ArrayList<>();
        clusterAdapter = new PolicyListAdapter(getActivity(), clusterData);
        setRefreshHead(refresh);
        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview,R.drawable.main_item_divider);
        setRefreshLison(refresh, this);
        clusterAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(clusterAdapter);
    }

    private void getPolicyPage(final String pageIndex, final boolean isRefresh) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize + "");
        httpParams.put("basicsId", basicsId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keywords",keywords);
        OkGo.post(HttpApi.PolicyPageList)
                .params(httpParams)
                .execute(new ResCallBack<PolicyListBean>(getActivity(),false) {
                    @Override
                    public void onCall(PolicyListBean cluster, Call call, Response response) {
                        if (isRefresh) {
                            clusterData.clear();
                        }
                        isRefresh(cluster.getData().getCountRecord(),pageIndex,pageSize+"");
                        clusterData.addAll(cluster.getData().getList());
                        clusterAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getPolicyPage(pageIndex + "", true);
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getPolicyPage(pageIndex + "", false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(getActivity(), PolicyDetialesAc.class).putExtra("id", clusterData.get(position).getPolicyId()));

    }
}
