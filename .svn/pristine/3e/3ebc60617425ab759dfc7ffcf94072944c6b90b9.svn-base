package com.lingang.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.contacts.ContactsCompanyAc;
import com.lingang.activity.contacts.ContactsDepAc;
import com.lingang.adapter.ContactsCpAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.GroupConnectionBean;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.RefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jason on 17/5/31.
 * 通讯录fragment
 */
public class ContactsFragment extends BaseFragment implements RecycleBaseAdapter.OnItemClickListener {
    @BindView(R.id.recyclerview)
    RecyclerView contactsRecyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout contactsRefresh;

    private List<GroupConnectionBean.DataBean> mData;
    private ContactsCpAdapter cpAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_contacts_company, null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }


    /**
     * 初始化控件
     */
    private void initView() {

        String groupCD = getArguments().getString("GroupCD");


        setRecycleAspect(contactsRecyclerview);
        setRefreshViewLine(contactsRecyclerview,R.drawable.main_item_divider);
        contactsRefresh.setEnableRefresh(false);
        contactsRefresh.setOverScrollTopShow(false);
        contactsRefresh.setEnableLoadmore(false);
        contactsRefresh.setOverScrollBottomShow(false);//刷新控件bug 设置之后就没事了
        mData = new ArrayList<>();
        cpAdapter = new ContactsCpAdapter(getActivity(), mData);
        cpAdapter.setOnItemClickListener(this);
        contactsRecyclerview.setAdapter(cpAdapter);
        groupConnection(groupCD);

    }
    //获取组织信息
    private void groupConnection(String groupCD) {
        HttpParams httpParams = new HttpParams();//LoginManager.getInstance().getUserInfo().getUserAccount()
        httpParams.put("ParentGroupCD", groupCD);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.groupConnection)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(getActivity()) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        String result = adressBean.getData();
                        Gson gson = new Gson();
                        GroupConnectionBean meetingByWeekBean = gson.fromJson(result.replaceAll("\\\\", ""), GroupConnectionBean.class);
                        mData.addAll(meetingByWeekBean.getData());
                        cpAdapter.notifyDataSetChanged();
                    }
                });

    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        Intent intent = new Intent(getActivity(), ContactsDepAc.class);
        intent.putExtra("IsJob",mData.get(position).getIsJob());
        intent.putExtra("GroupCD",mData.get(position).getGroupCD());
        intent.putExtra("IssubNode",mData.get(position).getIssubNode());
        intent.putExtra("GroupName",mData.get(position).getGroupName());
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
