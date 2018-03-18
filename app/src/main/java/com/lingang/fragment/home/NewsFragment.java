package com.lingang.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.NewsSearchAc;
import com.lingang.base.BaseFragment;
import com.lingang.bean.NewsTabBean;
import com.lingang.common.LoginManager;
import com.lingang.event.NewsEvent;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by luojialun on 2017/9/12.
 */

public class NewsFragment extends BaseFragment implements OnTabSelectListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.news_category_stl)
    SlidingTabLayout newsCategoryStl;
    @BindView(R.id.news_category_viewPager)
    ViewPager newsCategoryViewPager;
    @BindView(R.id.tv_title)
    TextView titleTv;
    @BindView(R.id.ib_right)
    ImageView rightIv;

    private List<NewsCategoryFragment> viewPagerFragement;
    private ArrayList<NewsTabBean.DataBean> tabList;
    private CategoryPagerAdapter pagerAdapter;

    private String keyWords = App.Empty;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        titleTv.setText("资讯");
        rightIv.setVisibility(View.VISIBLE);
        rightIv.setImageResource(R.mipmap.search);
        pagerAdapter = new CategoryPagerAdapter(getChildFragmentManager());
        viewPagerFragement = new ArrayList<>();
        newsCategoryViewPager.setAdapter(pagerAdapter);
        getTab();
    }

    @OnClick(R.id.ib_right)
    public void onClick() {
        NewsSearchAc.goToNewsSearchAc(getActivity());
    }

    @Override
    public void onTabSelect(int position) {
        //viewPagerFragement.get(position).search(keyWords);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        viewPagerFragement.get(position).search(keyWords);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabReselect(int position) {
    }

    //获取tab标签
    private void getTab() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("basicsType", "6");
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.basicsList)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<String>(getActivity()) {
                    @Override
                    public void onCall(String s, Call call, Response response) {
                        if (!TextUtils.isEmpty(s)) {
                            Gson gson = new Gson();
                            NewsTabBean newstab = gson.fromJson(s, NewsTabBean.class);
                            if (tabList == null) {
                                tabList = new ArrayList<>();
                            }
                            tabList.addAll(newstab.getData());
                            tabList.add(0, createNormalAll());

                            for (int i = 0; i < tabList.size(); i++) {
                                viewPagerFragement.add(NewsCategoryFragment.newInstance(tabList.get(i).getBasicsId(), ""));
                            }

                            pagerAdapter.notifyDataSetChanged();
                            newsCategoryViewPager.setOffscreenPageLimit(1);
                            newsCategoryStl.setViewPager(newsCategoryViewPager);
                            newsCategoryStl.setOnTabSelectListener(NewsFragment.this);
                            newsCategoryViewPager.addOnPageChangeListener(NewsFragment.this);
                            newsCategoryViewPager.setCurrentItem(0);//设置Fragement页面索引
                            viewPagerFragement.get(0).search(keyWords);//默认加载第一个fragment
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }


    /**
     * 创建默认全部
     *
     * @return
     */
    private NewsTabBean.DataBean createNormalAll() {
        NewsTabBean.DataBean bean = new NewsTabBean.DataBean();
        bean.setBasicsId(String.valueOf(App.IntNormal));
        bean.setBasicsName(getResources().getString(R.string.new_category_all));
        return bean;
    }

    /**
     * viewPager Adapter
     */
    public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
        public CategoryPagerAdapter(FragmentManager fm) {
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

        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position).getBasicsName();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsEvent(NewsEvent event) {
        pagerAdapter=null;
        viewPagerFragement=null;
        tabList=null;
        initView();
    }
}
