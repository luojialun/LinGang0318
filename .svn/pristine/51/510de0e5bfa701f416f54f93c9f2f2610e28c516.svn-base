package com.lingang.activity.contacts;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.lingang.R;
import com.lingang.adapter.NewAddVpAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.NewAddBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.other.BusinessFragment;
import com.lingang.fragment.other.ChanYFragment;
import com.lingang.fragment.other.ChanYeJiQuanFragment;
import com.lingang.fragment.other.CoopFragment;
import com.lingang.fragment.other.JoinFragment;
import com.lingang.fragment.other.MatingFragment;
import com.lingang.fragment.other.PublicPlatformFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class NewAddAc extends BaseAc {

    @BindView(R.id.tb_new)
    TabLayout tbNew;
    @BindView(R.id.vp_new)
    ViewPager vpNew;
    @BindView(R.id.fl_entry)
    FrameLayout flEntry;
    @BindView(R.id.ll_newadd)
    LinearLayout llNewadd;
    private ArrayList<NewAddBean.DataMapBean.ListBeanX> dataBeen;
    private ArrayList<Fragment> fragments;
    private NewAddVpAdapter policyVpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_newadd);
        setTitle("最近新增");
        initView();
        queryMessageList();
    }

    private void initView() {
        dataBeen = new ArrayList<>();
        fragments = new ArrayList<>();
        policyVpAdapter = new NewAddVpAdapter(getSupportFragmentManager(), fragments, dataBeen);
        vpNew.setAdapter(policyVpAdapter);
        //将tabLayout与viewpager连起来
        tbNew.setupWithViewPager(vpNew);
    }

    private void queryMessageList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", "1");
        httpParams.put("pageSize", "1");
        httpParams.put("messageType", "");
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.queryMessageList)
                .params(httpParams)
                .execute(new ResCallBack<NewAddBean>(this) {
                    @Override
                    public void onCall(NewAddBean cluster, Call call, Response response) {

                        List<NewAddBean.DataMapBean.ListBeanX> list = cluster.getDataMap().getList();
                        if (list.size() > 0) {
                            dataBeen.addAll(list);
                            for (NewAddBean.DataMapBean.ListBeanX listBeanX : list) {
                                Bundle coopbundle = new Bundle();
                                coopbundle.putString("messageType", listBeanX.getId());
                                switch (listBeanX.getId()) {
                                    case "1"://产业园区
                                        ChanYFragment chanYFragment = new ChanYFragment();
                                        chanYFragment.setArguments(coopbundle);
                                        tbNew.addTab(tbNew.newTab().setText(listBeanX.getName()));
                                        fragments.add(chanYFragment);
                                        break;
                                    case "2"://产业集群
                                        ChanYeJiQuanFragment chanYeJiQuanFragment = new ChanYeJiQuanFragment();
                                        chanYeJiQuanFragment.setArguments(coopbundle);
                                        tbNew.addTab(tbNew.newTab().setText(listBeanX.getName()));
                                        fragments.add(chanYeJiQuanFragment);
                                        break;
                                    case "3"://存量用户
                                        JoinFragment policyFragment = new JoinFragment();
                                        policyFragment.setArguments(coopbundle);
                                        tbNew.addTab(tbNew.newTab().setText(listBeanX.getName()));
                                        fragments.add(policyFragment);
                                        break;
                                    case "4"://租售物业
                                        BusinessFragment businessFragment = new BusinessFragment();
                                        businessFragment.setArguments(coopbundle);
                                        tbNew.addTab(tbNew.newTab().setText(listBeanX.getName()));
                                        fragments.add(businessFragment);
                                        break;
                                    case "5"://配套服务
                                        MatingFragment matingFragment = new MatingFragment();
                                        matingFragment.setArguments(coopbundle);
                                        tbNew.addTab(tbNew.newTab().setText(listBeanX.getName()));
                                        fragments.add(matingFragment);
                                        break;
                                    case "6"://公共平台
                                        PublicPlatformFragment publicPlatformFragment = new PublicPlatformFragment();
                                        publicPlatformFragment.setArguments(coopbundle);
                                        tbNew.addTab(tbNew.newTab().setText(listBeanX.getName()));
                                        fragments.add(publicPlatformFragment);
                                        break;
                                    case "7"://合作伙伴
                                        CoopFragment coopFragment = new CoopFragment();
                                        coopFragment.setArguments(coopbundle);
                                        tbNew.addTab(tbNew.newTab().setText(listBeanX.getName()));
                                        fragments.add(coopFragment);
                                        break;
                                }
                            }
                            policyVpAdapter.notifyDataSetChanged();
                        } else {
                            flEntry.setVisibility(View.VISIBLE);
                            llNewadd.setVisibility(View.GONE);
                        }
                    }
                });
    }


}
