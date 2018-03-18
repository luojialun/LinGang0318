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
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.adapter.YuanQuAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.YuanQuBean;
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
public class ChanYFragment extends BaseFragment implements RefreshListion ,RecycleBaseAdapter.OnItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private String messageType = "";
    Unbinder unbinder;
    private ArrayList<YuanQuBean.DataBean.ListBean> clusterData;
    private YuanQuAdapter newAddAdapter;

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
        newAddAdapter = new YuanQuAdapter(getActivity(), clusterData);
        setRefreshHead(refresh);
        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview,R.drawable.main_item_divider);
        setRefreshLison(refresh, this);
        newAddAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(newAddAdapter);
    }

    private void queryMessageList(final String pageIndex) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize + "");
        httpParams.put("messageType", messageType);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.queryMessageList)
                .params(httpParams)
                .execute(new ResCallBack<YuanQuBean>(getActivity(),false) {
                    @Override
                    public void onCall(YuanQuBean cluster, Call call, Response response) {
                        if (pageIndex.equals("1")) {
                            clusterData.clear();
                        }

                        isRefresh(cluster.getData().getCountRecord(), pageIndex, pageSize + "");

                        clusterData.addAll(cluster.getData().getList());
                        newAddAdapter.notifyDataSetChanged();
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
        startActivity(new Intent(getActivity(), ChanYeDetailsAc.class).putExtra("id", clusterData.get(position).getParkId()));

    }
}
