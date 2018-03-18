package com.lingang.activity.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.ContactsCpAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.GetUserInfoBean;
import com.lingang.bean.GroupConnectionBean;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 通讯录-公司页面
 */
public class ContactsCompanyAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ContactsCpAdapter adapter;
    private ArrayList<GroupConnectionBean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_contacts_company);
        initView();
    }

    private void initView() {
        setTitle(getString(R.string.contacts_company));
        getRightView().setImageResource(R.mipmap.ic_txl_suosou);
        getRightView2().setImageResource(R.mipmap.ic_tongxunlu);

        list = new ArrayList<>();
        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview,R.drawable.main_item_divider);
        adapter=new ContactsCpAdapter(this,list);
        adapter.setOnItemClickListener(this);
        recyclerview.setAdapter(adapter);
        refresh.setEnableRefresh(false);
        refresh.setOverScrollTopShow(false);
        refresh.setEnableLoadmore(false);
        refresh.setOverScrollBottomShow(false);//刷新控件bug 设置之后就没事了

        getUserInfo();
    }

    //获取用户信息
    private void getUserInfo() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("Userid", "huangshuai");//LoginManager.getInstance().getUserInfo().getUserAccount()
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GetUserInfo)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String,Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<String,Object> addressBean, Call call, Response response){
                        String result =  addressBean.getData();
                        Gson gson = new Gson();
                        GetUserInfoBean userInfo = gson.fromJson(result.replaceAll("\\\\", ""),GetUserInfoBean.class);

                        if (userInfo.getData().size() != 0){
                            String groupCD = userInfo.getData().get(0).getLabourRelationCD();
                            groupConnection(groupCD);
                        }
                    }
                });

    }
    //获取组织信息
    private void groupConnection(String groupCD) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("useraccount", "huangshuai");//LoginManager.getInstance().getUserInfo().getUserAccount()
        httpParams.put("ParentGroupCD", groupCD);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.groupConnection)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        String result = adressBean.getData();
                        Gson gson = new Gson();
                        GroupConnectionBean meetingByWeekBean = gson.fromJson(result.replaceAll("\\\\", ""), GroupConnectionBean.class);
                        list.addAll(meetingByWeekBean.getData());
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        startActivity(new Intent(this,ContactsSearchAc.class));
    }

    @Override
    public void ibClickRight2() {
        super.ibClickRight2();
        startActivity(new Intent(this,ContactsAc.class));
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        Intent intent = new Intent(this, ContactsDepAc.class);
        intent.putExtra("IsJob",list.get(position).getIsJob());
        intent.putExtra("GroupCD",list.get(position).getGroupCD());
        intent.putExtra("IssubNode",list.get(position).getIssubNode());
        intent.putExtra("GroupName",list.get(position).getGroupName());
        startActivity(intent);
    }
}
