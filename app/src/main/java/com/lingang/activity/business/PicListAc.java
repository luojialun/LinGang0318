package com.lingang.activity.business;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lingang.R;
import com.lingang.adapter.PicVpAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.GetBasicsBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.other.PicFragment;
import com.lingang.fragment.other.PolicyFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class PicListAc extends BaseAc {

    @BindView(R.id.tb_pic)
    TabLayout tbPic;
    @BindView(R.id.vp_pci)
    ViewPager vpPci;
    private ArrayList<GetBasicsBean.DataBean> dataTab;
    private PicVpAdapter policyVpAdapter;
    private ArrayList<Fragment> fragments;
    private String objId,pictureType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_pic_list);

        initView();
        getPolicyPage();
    }

    private void getPolicyPage() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("objType", objId);
        httpParams.put("pictureType", pictureType);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GetBasicsList)
                .params(httpParams)
                .execute(new ResCallBack<GetBasicsBean>(this, false) {
                    @Override
                    public void onCall(GetBasicsBean cluster, Call call, Response response) {
//                        Log.e("cluster",cluster);
                        List<GetBasicsBean.DataBean> data = cluster.getData();
                        GetBasicsBean.DataBean bean = new GetBasicsBean.DataBean();
                        bean.setBasicsName("全部");
                        bean.setBasicsId("");
                        dataTab.add(bean);
                        dataTab.addAll(data);
                        for (GetBasicsBean.DataBean dataBean : dataTab
                                ) {
                            PicFragment policyFragment = new PicFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("objId",objId);
                            bundle.putString("basicsId", dataBean.getBasicsId());
                            bundle.putString("pictureType", pictureType);
                            policyFragment.setArguments(bundle);
                            fragments.add(policyFragment);
                        }
                        policyVpAdapter.notifyDataSetChanged();

                    }
                });
    }

    private void initView() {
        setTitle("图集");
        objId = getIntent().getStringExtra("objId");
        pictureType = getIntent().getStringExtra("pictureType");
        dataTab = new ArrayList<>();
        fragments = new ArrayList<>();
        policyVpAdapter = new PicVpAdapter(getSupportFragmentManager(), fragments, dataTab);
        vpPci.setAdapter(policyVpAdapter);
        //将tabLayout与viewpager连起来
        tbPic.setupWithViewPager(vpPci);
    }
}
