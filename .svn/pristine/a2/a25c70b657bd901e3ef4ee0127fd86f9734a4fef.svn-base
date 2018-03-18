package com.lingang.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.search.SeachPolicyListAc;
import com.lingang.adapter.PolicyVpAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.BaseSeachAc;
import com.lingang.bean.AllClassBean;
import com.lingang.bean.PolicyListBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.other.PolicyFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class PolicyListAc extends BaseAc {

    @BindView(R.id.tb_policy)
    TabLayout tbPolicy;
    @BindView(R.id.vp_policy)
    ViewPager vpPolicy;
    private ArrayList<PolicyListBean.DataMapBean.ListBeanX> dataBeen;
    private PolicyVpAdapter policyVpAdapter;
    private ArrayList<Fragment> fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_policy_list);
        setTitle("招商政策");
        getRightView().setImageResource(R.mipmap.search);
        initView();
        getPolicyPage();
    }

    @Override
    public void ibClickRight() {
        startActivity(new Intent(this, SeachPolicyListAc.class));
    }


    private void getPolicyPage() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", "1");
        httpParams.put("pageSize", "1");
        httpParams.put("basicsId", "");
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keywords","");
        OkGo.post(HttpApi.PolicyPageList)
                .params(httpParams)
                .execute(new ResCallBack<PolicyListBean>(this,false) {
                    @Override
                    public void onCall(PolicyListBean cluster, Call call, Response response) {
                        List<PolicyListBean.DataMapBean.ListBeanX> list = cluster.getDataMap().getList();
                        dataBeen.addAll(list);
                        for (PolicyListBean.DataMapBean.ListBeanX listBeanX:
                                list) {
                            PolicyFragment policyFragment = new PolicyFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("basicsId", listBeanX.getId());
                            policyFragment.setArguments(bundle);
                            fragments.add(policyFragment);
                        }
                        policyVpAdapter.notifyDataSetChanged();
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
    }

}
