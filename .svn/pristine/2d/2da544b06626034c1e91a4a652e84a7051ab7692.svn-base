package com.lingang.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.NewsTabBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.home.NewsCategoryFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 新闻页
 */
public class NewsAc extends BaseAc implements OnTabSelectListener,ViewPager.OnPageChangeListener {

//    @BindView(R.id.new_titlebar)
//    TitleBar mTitlebar;
//    @BindView(R.id.searchLL)
//    RelativeLayout searchLL;
//    @BindView(R.id.search_input_ed)
//    EditText searchInputEd;
//    @BindView(R.id.search_input_clear_btn)
//    Button searchInputClearBtn;
//    @BindView(R.id.search_cancel)
//    TextView searchCancel;
//    @BindView(R.id.search_level2_toolbar_title)
//    TextView searchLevel2ToolbarTitle;

    @BindView(R.id.news_category_stl)
    SlidingTabLayout newsCategoryStl;
    @BindView(R.id.news_category_viewPager)
    ViewPager newsCategoryViewPager;
    private List<NewsCategoryFragment> viewPagerFragement;
    private ArrayList<NewsTabBean.DataBean> tabList;
    private CategoryPagerAdapter pagerAdapter;
//    @BindView(R.id.tabLayout)
//    TabLayout tabLayout;
//    @BindView(R.id.recyclerview)
//    RecyclerView recyclerview;
//    @BindView(R.id.refresh)
//    TwinklingRefreshLayout refresh;
//    private int pageIndex = 1;
//    private int pageSize = 10;
//    private ArrayList<BannerBean.DataBean.ListBean> data;
//    private NewsAdapter newsAdapter;
//    private ArrayList<NewsTabBean.DataBean> tabList;
//    private String basicsId;
    private String keyWords=App.Empty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_news);
        ButterKnife.bind(this);

        //com.flyco.systembar.SystemBarHelper.setHeightAndPadding(this, mTitlebar);
        initView();
    }

    /**
     *初始化
     */
    private void initView()
    {
        setTitle("资讯");
        getRightView().setImageResource(R.mipmap.search);
        //mTitlebar.setOnClickTitleBarListener(this);
        pagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager());
        viewPagerFragement=new ArrayList<>();
        getTab();
//        initView();

        /*****************搜索事件**************/
//        searchInputEd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    keyWords=searchInputEd.getText().toString().trim();
//                    int curFrame= newsCategoryViewPager.getCurrentItem();
//                    for (int i = 0; i <viewPagerFragement.size() ; i++) {
//                        if(i==curFrame)
//                        {//搜索
//                            viewPagerFragement.get(curFrame).search(keyWords);
//                        }else
//                        {//清除搜索关键字
//                            viewPagerFragement.get(i).clearKeywords();
//                        }
//                    }
//                    return true;
//                }
//                return false;
//            }
//        });
    }
//    @Override
//    public void onClickTitle(View v) {}
//
//    @Override
//    public void onClickLeft(View v) {
//        onBackPressed();
//        finish();
//    }
//
//    @Override
//    public void onClickRight(View v) {
//        mTitlebar.hiddenTitleTextView();
//        mTitlebar.hiddenRightTextView();
//        searchCancel.setVisibility(View.VISIBLE);
//        searchLL.setVisibility(View.VISIBLE);
//        searchLevel2ToolbarTitle.setVisibility(View.VISIBLE);
  //  }
//    @OnClick(R.id.search_cancel)
//    public void onClick() {
//        keyWords=App.Empty;
//        mTitlebar.showTitleTextView();
//        mTitlebar.showRightTextView();
//        searchLL.setVisibility(View.GONE);
//        searchCancel.setVisibility(View.GONE);
//        searchLevel2ToolbarTitle.setVisibility(View.GONE);
//    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        NewsSearchAc.goToNewsSearchAc(this);
    }

    @Override
    public void onTabSelect(int position) {
        viewPagerFragement.get(position).search(keyWords);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        viewPagerFragement.get(position).search(keyWords);
    }
    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onTabReselect(int position) {}

    //获取tab表情
    private void getTab() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("basicsType", "6");
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.basicsList)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<NewsTabBean>(this,false) {
                    @Override
                    public void onCall(NewsTabBean newstab, Call call, Response response) {
                        if (tabList == null) {
                            tabList = new ArrayList<>();
                        }
                        tabList.addAll(newstab.getData());
                        tabList.add(0,createNormalAll());
//                        for (NewsTabBean.DataBean dataBean : tabList) {
//                            tabLayout.addTab(tabLayout.newTab().setText(dataBean.getBasicsName()));
//                        }
//                        tabLayout.addOnTabSelectedListener(NewsAc.this);

                        for (int i = 0; i < tabList.size(); i++) {
                            viewPagerFragement.add(NewsCategoryFragment.newInstance(tabList.get(i).getBasicsId(),""));
                        }
                        newsCategoryViewPager.setAdapter(pagerAdapter);
                        newsCategoryViewPager.setOffscreenPageLimit(1);
                        newsCategoryStl.setViewPager(newsCategoryViewPager);
                        newsCategoryStl.setOnTabSelectListener(NewsAc.this);
                        newsCategoryViewPager.addOnPageChangeListener(NewsAc.this);
                        newsCategoryViewPager.setCurrentItem(0);//设置Fragement页面索引
                        viewPagerFragement.get(0).search(keyWords);//默认加载第一个fragment
                        //getBanner(pageIndex + "", pageSize + "", true, basicsId);
                    }
                });
    }


    /**
     * 创建默认全部
     * @return
     */
    private NewsTabBean.DataBean createNormalAll()
    {
        NewsTabBean.DataBean bean=new NewsTabBean.DataBean();
        bean.setBasicsId(String.valueOf(App.IntNormal));
        bean.setBasicsName(getResources().getString(R.string.new_category_all));
        return bean;
    }
    /**
     * viewPager Adapter
     */
    public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
        public CategoryPagerAdapter(FragmentManager fm) {super(fm);}
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

    /**
     * 跳转
     * @param context
     */
    public static void goToNewsAc(Context context)
    {
        Intent intent = new Intent(context, NewsAc.class);
        context.startActivity(intent);
    }
    /**
     * 初始化控件
     */
//    private void initView() {
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerview.setLayoutManager(layoutManager);
//
//        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        dividerItemDecoration1.setDrawable(getResources().getDrawable(R.drawable.main_item_divider));
//        recyclerview.addItemDecoration(dividerItemDecoration1);
//
//        data = new ArrayList<>();
//        newsAdapter = new NewsAdapter(this, data);
//        newsAdapter.setOnItemClickListener(this);
//        recyclerview.setAdapter(newsAdapter);
//
//        RefreshView headerView = new RefreshView(this);
//        refresh.setHeaderView(headerView);
//        refresh.setAutoLoadMore(true);
//        refresh.setOnRefreshListener(new RefreshListenerAdapter() {
//
//            @Override
//            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        pageIndex = 1;
//                        getBanner(pageIndex + "", pageSize + "", true, basicsId);
//
//                        refresh.finishRefreshing();
//                    }
//                }, 2000);
//            }
//
//            @Override
//            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        pageIndex++;
//                        getBanner(pageIndex + "", pageSize + "", false, basicsId);
//                        refresh.finishLoadmore();
//                    }
//                }, 2000);
//            }
//        });
//    }
//
//    private void getBanner(String pageIndex, String pageSize, final boolean isRefresh, String basicsId) {
//        HttpParams httpParams = new HttpParams();
//        httpParams.put("pageIndex", pageIndex);
//        httpParams.put("pageSize", pageSize);
//        httpParams.put("basicsId", basicsId);
//        httpParams.put("token", LoginManager.getInstance().getToken());
//        OkGo.post(HttpApi.HOME_BANNER)
//                .params(httpParams)
//                .execute(new ResCallBack<BannerBean>(this) {
//                    @Override
//                    public void onCall(BannerBean banner, Call call, Response response) {
//                        if (isRefresh) {
//                            data.clear();
//                        }
//                        List<BannerBean.DataBean.ListBean> list = banner.getData().getList();
//                        data.addAll(list);
//                        newsAdapter.notifyDataSetChanged();
//                    }
//                });
//
//    }
//
//    //获取tab表情
//    private void getTab() {
//        HttpParams httpParams = new HttpParams();
//        httpParams.put("basicsType", "6");
//        httpParams.put("token", LoginManager.getInstance().getToken());
//        OkGo.post(HttpApi.basicsList)
//                .params(httpParams)
//                .execute(new ResCallBack<NewsTabBean>(this) {
//                    @Override
//                    public void onCall(NewsTabBean newstab, Call call, Response response) {
//                        if (tabList == null) {
//                            tabList = new ArrayList<>();
//                        }
//                        tabList.addAll(newstab.getData());
//                        for (NewsTabBean.DataBean dataBean : tabList) {
//                            tabLayout.addTab(tabLayout.newTab().setText(dataBean.getBasicsName()));
//                        }
//                        tabLayout.addOnTabSelectedListener(NewsAc.this);
//                        basicsId = tabList.get(0).getBasicsId();
//                        getBanner(pageIndex + "", pageSize + "", true, basicsId);
//                    }
//                });
//    }
//
//    @Override
//    public void onTabSelected(TabLayout.Tab tab) {
//        basicsId = tabList.get(tab.getPosition()).getBasicsId();
//        getBanner(pageIndex + "", pageSize + "", true, basicsId);
//    }
//
//    @Override
//    public void onTabUnselected(TabLayout.Tab tab) {
//
//    }
//
//    @Override
//    public void onTabReselected(TabLayout.Tab tab) {
//
//    }
//
//    @Override
//    public void onItemClick(View view, Object item, int position) {
//        Intent intent = new Intent(this, NewsDetailsAc.class);
//        intent.putExtra("newsId",data.get(position).getNewsId());
//        startActivity(intent);
//    }
}
