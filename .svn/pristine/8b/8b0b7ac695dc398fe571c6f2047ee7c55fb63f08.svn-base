package com.lingang.activity.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.ContactFragmentBean;
import com.lingang.bean.ContactTabBean;
import com.lingang.bean.GroupBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.home.ContactsFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 通讯录
 */
public class ContactsAc extends BaseAc implements OnTabSelectListener {
    @BindView(R.id.contacts_tab_title)
    CommonTabLayout contactsTabTitle;
    @BindView(R.id.contacts_viewPager)
    ViewPager contactsViewPager;

    private List<Fragment> viewPagerFragement;
    private ContactPagerAdapter pagerAdapter;
    private ArrayList<CustomTabEntity> mTabEntities;

    private int[] mIconUnselectIds = {R.mipmap.ic_xingzhneg, R.mipmap.ic_dangwu, R.mipmap.ic_gonghui, R.mipmap.ic_tuanwei};
    private int[] mIconSelectIds = {R.mipmap.ic_xingzhneg_ed, R.mipmap.ic_dangwu_ed, R.mipmap.ic_gonghui_ed, R.mipmap.ic_tuanwei_ed};

    private String[] mTabName = {"行政通讯录", "党务通讯录", "工会通讯录", "团务通讯录"};
    private ArrayList<ContactTabBean> tabContactList;
    private ArrayList<ContactFragmentBean> contactFragmentBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_contacts);
        setTitle("通讯录");
        getRightView().setImageResource(R.mipmap.search);
        getAscription();
    }

    private void initView(List<GroupBean.DataBean> data) {
        mTabEntities = new ArrayList<>();
        viewPagerFragement = new ArrayList<>();
        tabContactList = new ArrayList<>();
        contactFragmentBeen = new ArrayList<>();

        for (GroupBean.DataBean bean : data) {

            String groupCD = bean.getGroupCD();
            if (!TextUtils.isEmpty(groupCD) && (groupCD.equals("603103CE-46AB-4A19-BB3C-A9B8C305923C")
                    || groupCD.equals("DAFC4847-0515-47A4-8984-4A30FF944D02")
                    || groupCD.equals("5FF6FDC5-4957-476C-8DFD-8FB752853CA5")
                    || groupCD.equals("8F3CEBE2-94F3-425B-9B8E-D663EAA1FD82"))) {
                //联系人碎片
                ContactsFragment contactsFragment = new ContactsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("GroupCD", groupCD);
                contactsFragment.setArguments(bundle);

                if (groupCD.equals("5FF6FDC5-4957-476C-8DFD-8FB752853CA5")) {//行政通讯录
                    contactFragmentBeen.add(new ContactFragmentBean(contactsFragment, 0));
                    tabContactList.add(new ContactTabBean(mTabName[0], mIconSelectIds[0], mIconUnselectIds[0], 0));
                } else if (groupCD.equals("603103CE-46AB-4A19-BB3C-A9B8C305923C")) {//党务通讯录
                    contactFragmentBeen.add(new ContactFragmentBean(contactsFragment, 1));
                    tabContactList.add(new ContactTabBean(mTabName[1], mIconSelectIds[1], mIconUnselectIds[1], 1));
                } else if (groupCD.equals("DAFC4847-0515-47A4-8984-4A30FF944D02")) {//工会通讯录
                    contactFragmentBeen.add(new ContactFragmentBean(contactsFragment, 2));
                    tabContactList.add(new ContactTabBean(mTabName[2], mIconSelectIds[2], mIconUnselectIds[2], 2));
                } else if (groupCD.equals("8F3CEBE2-94F3-425B-9B8E-D663EAA1FD82")) { //团务通讯录
                    contactFragmentBeen.add(new ContactFragmentBean(contactsFragment, 3));
                    tabContactList.add(new ContactTabBean(mTabName[3], mIconSelectIds[3], mIconUnselectIds[3], 3));
                }
            }
        }

        //排序btn
        Collections.sort(tabContactList, new Comparator<ContactTabBean>() {
            /*
             * int compare(ContactTabBean o1, ContactTabBean o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(ContactTabBean o1, ContactTabBean o2) {
                //升序排列
                if (o1.getOrder() > o2.getOrder()) {
                    return 1;
                }
                if (o1.getOrder() == o2.getOrder()) {
                    return 0;
                }
                return -1;
            }
        });

        //排序fragment
        Collections.sort(contactFragmentBeen, new Comparator<ContactFragmentBean>() {
            /*
             * int compare(ContactFragmentBean o1, ContactFragmentBean o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(ContactFragmentBean o1, ContactFragmentBean o2) {
                //升序排列
                if (o1.getFragmentTag() > o2.getFragmentTag()) {
                    return 1;
                }
                if (o1.getFragmentTag() == o2.getFragmentTag()) {
                    return 0;
                }
                return -1;
            }
        });
        for (ContactFragmentBean contactFragmentBean : contactFragmentBeen) {
            viewPagerFragement.add(contactFragmentBean.getFragment());
        }

        mTabEntities.addAll(tabContactList);

        pagerAdapter = new ContactPagerAdapter(getSupportFragmentManager());
        contactsViewPager.setAdapter(pagerAdapter);
        contactsViewPager.setOffscreenPageLimit(viewPagerFragement.size());
        contactsTabTitle.setTabData(mTabEntities);
        contactsTabTitle.setOnTabSelectListener(this);
        contactsViewPager.setCurrentItem(0);//设置Fragement页面索引
        contactsTabTitle.setCurrentTab(0);

        contactsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                contactsTabTitle.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    //获取组织信息
    private void getAscription() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.Ascription)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        String result = adressBean.getData();
                        if (!TextUtils.isEmpty(result)) {
                            Gson gson = new Gson();
                            List<GroupBean.DataBean> data = gson.fromJson(result.replaceAll("\\\\", ""), GroupBean.class).getData();
                            initView(data);
                        }
                    }
                });

    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        startActivity(new Intent(this, ContactsSearchAc.class));
    }

    @Override
    public void onTabSelect(int position) {
        contactsViewPager.setCurrentItem(position);
        contactsTabTitle.setCurrentTab(position);
    }

    @Override
    public void onTabReselect(int position) {
    }

    /**
     * viewPager Adapter
     */
    public class ContactPagerAdapter extends FragmentStatePagerAdapter {
        public ContactPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return viewPagerFragement.get(position);
        }

        @Override
        public int getCount() {
            return viewPagerFragement.size();
        }

    }
}
