package com.lingang.fragment.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.ImgBigAc;
import com.lingang.activity.home.PolicyDetialesAc;
import com.lingang.adapter.PicAdapter;
import com.lingang.adapter.PolicyListAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.PicListBean;
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
public class PicFragment extends BaseFragment implements RefreshListion ,RecycleBaseAdapter.OnItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private int pageIndex = 1;
    private int pageSize = 10;
    private String basicsId = "",objId,pictureType;
    Unbinder unbinder;
    private ArrayList<PicListBean.DataBean> clusterData;
    private PicAdapter clusterAdapter;
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
        objId = (String) arguments.get("objId");
        pictureType = (String) arguments.get("pictureType");
        getPolicyPage();
    }

    private void initView() {
        clusterData = new ArrayList<>();
        clusterAdapter = new PicAdapter(getActivity(), clusterData);
        setRefreshHead(refresh);
        refresh.setEnableLoadmore(false);
        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview,R.drawable.item_divider_tran_magin15);
        setRefreshLison(refresh, this);
        clusterAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(clusterAdapter);
    }

    private void getPolicyPage() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("objType", objId);
        httpParams.put("pictureType", pictureType);
        httpParams.put("basicsId", basicsId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GetAllPicture)
                .params(httpParams)
                .execute(new ResCallBack<PicListBean>(getActivity()) {
                    @Override
                    public void onCall(PicListBean cluster, Call call, Response response) {
                        clusterData.clear();
                        clusterData.addAll(cluster.getData());
                        if (clusterData.size() > 0) {

                            int dimension = (int) getResources().getDimension(R.dimen.margin_10);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) refresh.getLayoutParams();
                            layoutParams.setMargins(dimension,0,dimension,0);
                            refresh.setLayoutParams(layoutParams);

                            setRecycleGvAspect(recyclerview);
                            clusterAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void refresh() {
        getPolicyPage();
    }

    @Override
    public void loadMore() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(getActivity(), ImgBigAc.class).putExtra("imgList", clusterData).putExtra("position",position));
    }
}
