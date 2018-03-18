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
import com.lingang.activity.home.PropertyDettailsAc;
import com.lingang.adapter.BusinessAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BusinessBean;
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
 * Created by luojialun on 2018/1/8.
 */

public class BusinessFragment extends BaseFragment implements RefreshListion,RecycleBaseAdapter.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private String messageType = "";
    Unbinder unbinder;
    private ArrayList<BusinessBean.DataBean.ListBean> clusterData;
    private BusinessAdapter businessAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.newadd_fragment, null);
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
        messageType = (String) arguments.get("messageType");

        queryMessageList(pageIndex + "");
    }

    private void initView() {
        clusterData = new ArrayList<>();
        businessAdapter = new BusinessAdapter(getActivity(), clusterData);
        setRefreshHead(refresh);
        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview,R.drawable.main_item_divider);
        setRefreshLison(refresh, this);
        businessAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(businessAdapter);
    }

    private void queryMessageList(final String pageIndex) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize + "");
        httpParams.put("messageType", messageType);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.queryMessageList)
                .params(httpParams)
                .execute(new ResCallBack<BusinessBean>(getActivity(),false) {
                    @Override
                    public void onCall(BusinessBean cluster, Call call, Response response) {
                        if (pageIndex.equals("1")) {
                            clusterData.clear();
                        }

                        isRefresh(cluster.getData().getCountRecord(), pageIndex, pageSize + "");

                        clusterData.addAll(cluster.getData().getList());
                        businessAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        queryMessageList(pageIndex + "");
    }

    @Override
    public void loadMore() {
        pageIndex++;
        queryMessageList(pageIndex + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(getActivity(), PropertyDettailsAc.class).putExtra("id", clusterData.get(position).getBusinessId()).putExtra("title",clusterData.get(position).getBusinessName()));
    }
}
