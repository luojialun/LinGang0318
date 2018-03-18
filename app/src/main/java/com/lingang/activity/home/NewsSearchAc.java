package com.lingang.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.systembar.SystemBarHelper;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BannerBean;
import com.lingang.bean.NewsTabBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.home.NewsCategoryFragment;
import com.lingang.fragment.home.NewsSearchFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.ClearableEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 新闻搜索页面
 */
public class NewsSearchAc extends BaseAc implements OnTabSelectListener {


    @BindView(R.id.news_search_category_stl)
    SlidingTabLayout newsCategoryStl;
    @BindView(R.id.news_search_category_viewPager)
    ViewPager newsCategoryViewPager;
    @BindView(R.id.search_input_ed)
    ClearableEditText searchInputEd;
    @BindView(R.id.search_cancel)
    TextView searchCancel;
    @BindView(R.id.search_toolbar)
    LinearLayout searchToolbar;

    private List<NewsSearchFragment> viewPagerFragement;
    private CategoryPagerAdapter pagerAdapter;
    private ArrayList<NewsTabBean.DataBean> tabList;
    private List<String> tabLabel;
    private int loadIndex=0;
    private String keyWords = App.Empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_search);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        SystemBarHelper.setHeightAndPadding(this, searchToolbar);
        tabLabel=new ArrayList<>();
        pagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager());
        viewPagerFragement = new ArrayList<>();
        newsCategoryViewPager.setAdapter(pagerAdapter);
        newsCategoryStl.setViewPager(newsCategoryViewPager);
        newsCategoryViewPager.setOffscreenPageLimit(1);
        newsCategoryViewPager.setCurrentItem(0);//设置Fragement页面索引

        newsCategoryStl.setOnTabSelectListener(NewsSearchAc.this);
        /*****************搜索事件**************/
        searchInputEd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    keyWords = searchInputEd.getText().toString().trim();
                    getTab();
                    return true;
                }
                return false;
            }
        });

        //setFocus
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputMethodManager.showSoftInput(searchInputEd, 0);
    }



    @Override
    public void onTabReselect(int position) {
    }

    @Override
    public void onTabSelect(int position) {

    }

    @OnClick(R.id.search_cancel)
    public void onClick() {
        keyWords = App.Empty;
        onBackPressed();
        finish();
    }

    //获取tab表情
    private void getTab() {
        loadIndex=0;
        tabLabel.clear();
        viewPagerFragement.clear();
        HttpParams httpParams = new HttpParams();
        httpParams.put("basicsType", "6");
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.basicsList)
                .params(httpParams)
                .execute(new ResCallBack<NewsTabBean>(this) {
                    @Override
                    public void onCall(NewsTabBean newstab, Call call, Response response) {
                        if (tabList == null) {
                            tabList = new ArrayList<>();
                        }
                        tabList.clear();

                        tabList.addAll(newstab.getData());
                        tabList.add(0, createNormalAll());
//                        for (int i = 0; i < tabList.size(); i++) {
//                            viewPagerFragement.add(NewsSearchFragment.newInstance(tabList.get(i).getBasicsId()));
//                        }
                        loadCategory();
                    }
                });
    }

    /**
     *加载分类
     */
    private void loadCategory()
    {
        if(loadIndex <tabList.size())
        {
            HttpParams httpParams = new HttpParams();
            httpParams.put("pageIndex", 1);
            httpParams.put("pageSize", 100);
            httpParams.put("basicsId", tabList.get(loadIndex).getBasicsId());
            httpParams.put("token", LoginManager.getInstance().getToken());
            if(!TextUtils.isEmpty(keyWords)) {
                httpParams.put("keywords", keyWords);
            }
            OkGo.post(HttpApi.HOME_BANNER)
                    .params(httpParams)
                    .execute(new ResCallBack<BannerBean>(NewsSearchAc.this,false) {
                        @Override
                        public void onCall(BannerBean banner, Call call, Response response) {
                            ArrayList<BannerBean.DataBean.ListBean> arrayList=(ArrayList<BannerBean.DataBean.ListBean>) banner.getData().getList();
                            if(arrayList !=null && arrayList.size()>0)
                            {
                                tabLabel.add(tabList.get(loadIndex).getBasicsName());
                                viewPagerFragement.add(NewsSearchFragment.newInstance(arrayList));
                            }
                            loadIndex++;
                            loadCategory();
                        }
                    });
        }else
        {
            if(viewPagerFragement.size()>0){
                newsCategoryViewPager.setVisibility(View.VISIBLE);
            }else
            {
                newsCategoryViewPager.setVisibility(View.GONE);
            }
            newsCategoryStl.notifyDataSetChanged();
            pagerAdapter.notifyDataSetChanged();
        }
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
            return tabLabel.get(position);
        }
    }

    /**
     * 页面跳转
     */
    public static void goToNewsSearchAc(Context context) {
        Intent intent = new Intent(context, NewsSearchAc.class);
        context.startActivity(intent);
    }
}
