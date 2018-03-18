package com.lingang.activity.home.search;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.lingang.R;
import com.lingang.adapter.PolicyVpAdapter;
import com.lingang.base.BaseSeachAc;
import com.lingang.bean.PolicyListBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.other.SeachPolicyFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class SeachPolicyListAc extends BaseSeachAc implements ViewPager.OnPageChangeListener {

    @BindView(R.id.tb_policy)
    TabLayout tbPolicy;
    @BindView(R.id.vp_policy)
    ViewPager vpPolicy;
    @BindView(R.id.ll_policy)
    LinearLayout llPolicy;
    private ArrayList<PolicyListBean.DataMapBean.ListBeanX> dataBeen;
    private PolicyVpAdapter policyVpAdapter;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_seach_policy_list);
        initView();
    }

    private void getPolicyPage(final String keyWords) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", "1");
        httpParams.put("pageSize", "1");
        httpParams.put("basicsId", "");
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keywords", keyWords);
        OkGo.post(HttpApi.PolicyPageList)
                .params(httpParams)
                .execute(new ResCallBack<PolicyListBean>(this, false) {
                    @Override
                    public void onCall(PolicyListBean cluster, Call call, Response response) {
                        dataBeen.clear();
                        fragments.clear();

                        List<PolicyListBean.DataMapBean.ListBeanX> list = cluster.getDataMap().getList();
                        dataBeen.addAll(list);
                        for (PolicyListBean.DataMapBean.ListBeanX listBeanX :
                                list) {
                            SeachPolicyFragment policyFragment = new SeachPolicyFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("basicsId", listBeanX.getId());
                            bundle.putString("keyword", keyWords);
                            policyFragment.setArguments(bundle);
                            fragments.add(policyFragment);
                        }
                        policyVpAdapter.notifyDataSetChanged();
//                        if (dataBeen.size() != 0) {
//                            SeachPolicyFragment item = (SeachPolicyFragment) policyVpAdapter.getItem(vpPolicy.getCurrentItem());
//                            item.seachData(keyWords);
//                        }
                    }
                });
    }

    private void initView() {
        dataBeen = new ArrayList<>();
        fragments = new ArrayList<>();
        policyVpAdapter = new PolicyVpAdapter(getSupportFragmentManager(), fragments, dataBeen);
        vpPolicy.setAdapter(policyVpAdapter);
        //将tabLayout与viewpager连起来
        tbPolicy.setupWithViewPager(vpPolicy);
        vpPolicy.setOnPageChangeListener(this);
    }

    @Override
    public void seachCall(String seachContent) {
        super.seachCall(seachContent);

        llPolicy.setVisibility(View.VISIBLE);
        getPolicyPage(seachContent);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        SeachPolicyFragment item = (SeachPolicyFragment) policyVpAdapter.getItem(position);
//        if (item != null)
//            item.refresh();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}