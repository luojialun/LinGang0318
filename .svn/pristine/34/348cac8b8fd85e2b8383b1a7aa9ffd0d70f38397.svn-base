package com.lingang.activity.contacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.adapter.ContactsCpAdapter;
import com.lingang.adapter.ContactsDepAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.ContactsBean;
import com.lingang.bean.ContactsDepBean;
import com.lingang.bean.GroupConnectionBean;
import com.lingang.bean.UserPageBean;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.RefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 通讯录-部门页面
 */
public class ContactsDepAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ContactsDepAdapter adapter;
    private ArrayList<ContactsBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_contacts_company);
        initView();
    }

    private void initView() {

        getRightView().setImageResource(R.mipmap.search);
        list = new ArrayList<>();
        adapter = new ContactsDepAdapter(this, list);

        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);

        refresh.setEnableRefresh(false);
        refresh.setOverScrollTopShow(false);
        refresh.setEnableLoadmore(false);
        refresh.setOverScrollBottomShow(false);//刷新控件bug 设置之后就没事了
        adapter.setOnItemClickListener(this);
        recyclerview.setAdapter(adapter);

        String IsJob = getIntent().getStringExtra("IsJob");
        String GroupCD = getIntent().getStringExtra("GroupCD");
        String IssubNode = getIntent().getStringExtra("IssubNode");
        String GroupName = getIntent().getStringExtra("GroupName");
        setTitle(GroupName);

        if (!IsJob.equals("0")) {//有没有人员
            getContactInfo(GroupCD, IssubNode);
        } else if (!IssubNode.equals("0")) {//有没有组织
            groupConnection(GroupCD, false);
        }
    }

    //取岗位列表
    private void getContactInfo(final String groupCD, final String IssubNode) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("GroupCD", groupCD);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getContactInfo)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        String result = adressBean.getData();
                        Gson gson = new Gson();
                        ContactsDepBean depBean = gson.fromJson(result.replaceAll("\\\\", ""), ContactsDepBean.class);
                        List<ContactsDepBean.DataBean> data = depBean.getData();
                        for (ContactsDepBean.DataBean dataBean :
                                data) {
                            ContactsBean bean = new ContactsBean();
                            bean.setSign("1");
                            bean.setJobid(dataBean.getJobid());
                            bean.setGroupCD(dataBean.getGroupCD());
                            bean.setUserID(dataBean.getUserID());
                            bean.setUserCHName(dataBean.getUserCHName());
                            bean.setJobName(dataBean.getJobName());
                            bean.setJobInnerTel(dataBean.getJobInnerTel());
                            bean.setJobDirectTel(dataBean.getJobDirectTel());
                            bean.setUserEmail(dataBean.getUserEmail());
                            bean.setIsVisible(dataBean.getIsVisible());
                            bean.setUserPhoto(dataBean.getUserPhoto());
                            bean.setUserMb(dataBean.getUserMb());
                            bean.setShowLine(false);
                            list.add(bean);
                        }
                        if (!IssubNode.equals("0")) {
                            groupConnection(groupCD, true);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

    }

    //获取组织信息
    private void groupConnection(String groupCD, final boolean isShow) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("useraccount", LoginManager.getInstance().getUserInfo().getUserAccount());//
        httpParams.put("ParentGroupCD", groupCD);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.groupConnection)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        String result = adressBean.getData();
                        Gson gson = new Gson();
                        List<GroupConnectionBean.DataBean> data = gson.fromJson(result.replaceAll("\\\\", ""), GroupConnectionBean.class).getData();

                        for (int i = 0; i < data.size(); i++) {

                            GroupConnectionBean.DataBean dataBean = data.get(i);
                            ContactsBean bean = new ContactsBean();
                            bean.setSign("2");
                            bean.setIssubNode(dataBean.getIssubNode());
                            bean.setIsJob(dataBean.getIsJob());
                            bean.setGroupCD(dataBean.getGroupCD());
                            bean.setGroupName(dataBean.getGroupName());
                            bean.setGroupParentCD(dataBean.getGroupParentCD());
                            bean.setGroupAscription(dataBean.getGroupAscription());
                            bean.setGroupType(dataBean.getGroupType());
                            bean.setGroupLevel(dataBean.getGroupLevel());
                            bean.setGroupViewRightName(dataBean.getGroupViewRightName());
                            if (i == 0) {
                                bean.setShowLine(isShow);
                            } else {
                                bean.setShowLine(false);
                            }
                            list.add(bean);
                        }

                        adapter.notifyDataSetChanged();
                    }
                });

    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        startActivity(new Intent(this, ContactsSearchAc.class));
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        Intent intent = new Intent();
        ContactsBean contactsBean = list.get(position);
        if (list.get(position).getSign().equals("2")) {
            intent.setClass(this, ContactsDepAc.class);
            intent.putExtra("IsJob", contactsBean.getIsJob());
            intent.putExtra("GroupCD", contactsBean.getGroupCD());
            intent.putExtra("IssubNode", contactsBean.getIssubNode());
            intent.putExtra("GroupName", contactsBean.getGroupName());
        } else {
            intent.setClass(this, PersonInfoActivity.class);
            intent.putExtra("userid", contactsBean.getJobid());
            intent.putExtra("email", contactsBean.getUserEmail());
            intent.putExtra("mb", contactsBean.getUserMb());
            intent.putExtra("name", contactsBean.getUserCHName());
            intent.putExtra("photo", contactsBean.getUserPhoto());
            intent.putExtra("tag", "oa");
            intent.putExtra("imguserid", contactsBean.getUserID());
        }
        startActivity(intent);
    }
}
