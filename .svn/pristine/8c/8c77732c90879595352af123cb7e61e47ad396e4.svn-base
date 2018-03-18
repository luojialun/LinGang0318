package com.lingang.activity.home.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.systembar.SystemBarHelper;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.NewsDetailsBean;
import com.lingang.bean.SearchHistory;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.fragment.home.search.SearchNewsFragment;
import com.lingang.greendao.DaoSession;
import com.lingang.greendao.SearchHistoryDao;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lingang.view.ClearableEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 搜索结果页面☆☆☆☆☆(已废弃)☆☆☆☆☆
 */

public class HomeSearchResultActivity extends BaseAc implements OnTabSelectListener{
    @BindView(R.id.search_result_stl)
    SlidingTabLayout searchResultSTL;
    @BindView(R.id.search_result_viewpager)
    ViewPager searchResultViewpager;
    @BindView(R.id.home_search_result_left_back_iv)
    ImageView homeSearchResultLeftBackIv;
    @BindView(R.id.home_search_result_input_et)
    ClearableEditText homeSearchResultInputEt;
    @BindView(R.id.search_all_toolbar_rl)
    LinearLayout searchAllToolbarRl;

    private int pageIndex = 1;
    private int pageSize = Constants.PAGE_SIZE;
    private int type;    //类型(1.新闻 2.政策 3.产业园区 4.合作伙伴 5.服务机构 6.入驻企业 7.公共平台 8.产业集群)
    private String keywords;   //用户输入的关键字
    //private SearchResultFragmentAdapter adapter;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> titlesTab;
    private DaoSession daoSession;
    private SearchHistoryDao searchHistoryDao;
    private SearchResultPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search_result);
        ButterKnife.bind(this);
        daoSession = App.getInstance().getDaoSession();
        searchHistoryDao = daoSession.getSearchHistoryDao();
        Intent intent = getIntent();
        keywords = intent.getStringExtra("keywords");
        initData();
        initView();
        SystemBarHelper.setHeightAndPadding(this, searchAllToolbarRl);
    }

    private void initData() {
        if (!TextUtils.isEmpty(keywords)) {
            homeSearchResultInputEt.setText(keywords);
            homeSearchResultInputEt.setSelection(homeSearchResultInputEt.getText().length());
            handleSearchHttp();
        }
    }

    private void initView() {
        //设置顶部搜索框的搜索事件
        homeSearchResultInputEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    keywords = homeSearchResultInputEt.getText().toString().trim();
                    if (!TextUtils.isEmpty(keywords)) {
                        handleSearchHttp();
                    } else {
                        ToastUtils.showToast(HomeSearchResultActivity.this,"请输入搜索关键字");
                    }
                }
                return false;
            }
        });
    }

    //设置viewpager数据
    private void initViewpager() {
        pagerAdapter = new SearchResultPagerAdapter(getSupportFragmentManager());
        searchResultViewpager.setAdapter(pagerAdapter);
        searchResultViewpager.setOffscreenPageLimit(10);
        searchResultViewpager.setCurrentItem(0);

        searchResultSTL.setViewPager(searchResultViewpager);
        searchResultSTL.setOnTabSelectListener(HomeSearchResultActivity.this);
    }

    @Override
    public void onTabSelect(int position) {}

    @Override
    public void onTabReselect(int position) {}

    @OnClick(R.id.home_search_result_left_back_iv)
    public void leftBack(View view) {
        finish();
    }


    //处理搜索的网络请求
    private void handleSearchHttp() {
        savaKeywords();

        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex",String.valueOf(pageIndex));
        httpParams.put("pageSize", String.valueOf(pageSize));
        httpParams.put("keywords", keywords);
        OkGo.post(HttpApi.HOME_SEARCH)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String s, Call call, Response response) {
                    if (!TextUtils.isEmpty(s)) {
                        handleResulData(s);
                    }
                }
        });
    }

    /**
     * 保存搜索过的关键字
     */
    private void savaKeywords() {
        //判断搜索的关键字是否已经存在,如果不存在则存入数据库
        List<SearchHistory> result = searchHistoryDao.queryBuilder()
                .where(SearchHistoryDao.Properties.Title.eq(keywords)).list();
        if (result != null && result.isEmpty()) {
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setCreateTime(System.currentTimeMillis());
            searchHistory.setTitle(keywords);
            //把数据保存的数据库
            searchHistoryDao.save(searchHistory);
        }
    }


    //☆☆☆☆☆(此类已废弃)☆☆☆☆☆




    //处理回复数据解析
    private void handleResulData(String responseData) {
        try {
            ////类型(1.新闻 2.政策 3.产业园区 4.合作伙伴 5.服务机构 6.入驻企业 7.公共平台 8.产业集群)
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(responseData);
            JSONObject dataObj = jsonObject.optJSONObject("data");
            JSONObject dataMapObject = jsonObject.optJSONObject("dataMap");
            String dataListJson = null;
            String typelistJson = null;
            ArrayList<HomeSearchResponse.TypeBean> typeList = null;
            if (dataObj != null) {
                dataListJson = dataObj.optJSONArray("list").toString();
            }
            if (dataMapObject != null) {
                typelistJson = dataMapObject.optJSONArray("list").toString();
                Type dataMapType = new TypeToken<ArrayList<HomeSearchResponse.TypeBean>>() {
                }.getType();
                typeList = gson.fromJson(typelistJson, dataMapType);
            }
            if(titlesTab !=null)
                titlesTab.clear();
            else
                titlesTab=new ArrayList<>();

            if (fragmentList != null)
                fragmentList.clear();
             else
                fragmentList = new ArrayList<>();

            Bundle bundle = new Bundle();
            bundle.putString("keywords", keywords);
            Type dataType;
            if (typeList != null && !typeList.isEmpty()) {
                for (int i = 0; i < typeList.size(); i++) {
                    int id = typeList.get(i).getId();
                    titlesTab.add(typeList.get(i).getName());
                    switch (id) {
                        case 1:  //新闻
                            SearchNewsFragment newsFragment = new SearchNewsFragment();
                            if (i == 0) {
                                dataType = new TypeToken<ArrayList<NewsDetailsBean.DataBean>>() {
                                }.getType();
                                ArrayList<NewsDetailsBean.DataBean> newsList = gson.fromJson(dataListJson, dataType);

                                bundle.putParcelableArrayList("data", newsList);
                                newsFragment.setArguments(bundle);
                            }
                            fragmentList.add(newsFragment);
                            break;

                        case 2:  //政策
//                            SearchPolicyFragment policyFragment = new SearchPolicyFragment();
//                            if (i == 0) {
//                                dataType = new TypeToken<ArrayList<HomePolicyList.PolicyListData.PolicyDetail>>() {
//                                }.getType();
//                                ArrayList<HomePolicyList.PolicyListData.PolicyDetail> policyList = gson.fromJson(dataListJson, dataType);
//                                bundle.putParcelableArrayList("data", policyList);
//                                policyFragment.setArguments(bundle);
//                            }
//                            fragmentList.add(policyFragment);
                            break;

                        case 3:  //产业园区
//                            SearchParkFragment parkFragment = new SearchParkFragment();
//                            if (i == 0) {
//                                dataType = new TypeToken<ArrayList<ParkBean>>() {
//                                }.getType();
//                                ArrayList<ParkBean> parkList = gson.fromJson(dataListJson, dataType);
//
//                                bundle.putParcelableArrayList("data", parkList);
//                                parkFragment.setArguments(bundle);
//                            }
//                            fragmentList.add(parkFragment);
                            break;

                        case 4:  //合作伙伴
//                            SearchPartnerFragment partnerFragment = new SearchPartnerFragment();
//                            if (i == 0) {
//                                dataType = new TypeToken<ArrayList<PartnerBean>>() {
//                                }.getType();
//                                ArrayList<PartnerBean> partnerList = gson.fromJson(dataListJson, dataType);
//                                bundle.putParcelableArrayList("data", partnerList);
//                                partnerFragment.setArguments(bundle);
//                            }
//                            fragmentList.add(partnerFragment);
                            break;

                        case 5:  //服务机构
//                            SearchServiceFragment serviceFragment = new SearchServiceFragment();
//                            if (i == 0) {
//                                dataType = new TypeToken<ArrayList<ServiceDetailsBean>>() {
//                                }.getType();
//                                ArrayList<ServiceDetailsBean> serviceList = gson.fromJson(dataListJson, dataType);
//                                bundle.putParcelableArrayList("data", serviceList);
//                                serviceFragment.setArguments(bundle);
//                            }
//                            fragmentList.add(serviceFragment);
                            break;
                        case 6:  //入住企业
//                            SearchStationFragment stationFragment = new SearchStationFragment();
//                            if (i == 0) {
//                                dataType = new TypeToken<ArrayList<StationDetailsBean>>() {
//                                }.getType();
//                                ArrayList<StationDetailsBean> stationList = gson.fromJson(dataListJson, dataType);
//                                bundle.putParcelableArrayList("data", stationList);
//                                stationFragment.setArguments(bundle);
//                            }
//                            fragmentList.add(stationFragment);
                            break;

                        case 7:  //公共平台
//                            SearchPublicFragment publicFragment = new SearchPublicFragment();
//                            if (i == 0) {
//                                dataType = new TypeToken<ArrayList<PublicDetailsBean>>() {
//                                }.getType();
//                                ArrayList<PublicDetailsBean> publicList = gson.fromJson(dataListJson, dataType);
//                                bundle.putParcelableArrayList("data", publicList);
//                                publicFragment.setArguments(bundle);
//                            }
//                            fragmentList.add(publicFragment);
                            break;

                        case 8:  //产业集群
//                            SearchIndustryFragment industryFragment = new SearchIndustryFragment();
//                            if (i == 0) {
//                                dataType = new TypeToken<ArrayList<IndustryItem>>() {
//                                }.getType();
//                                ArrayList<IndustryItem> stationList = gson.fromJson(dataListJson, dataType);
//                                bundle.putParcelableArrayList("data", stationList);
//                                industryFragment.setArguments(bundle);
//                            }
//                            fragmentList.add(industryFragment);
                            break;
                    }
                }
            }
            //初始化viewpager的数据
            initViewpager();
            //初始化指示器
            //renderTabTitle(titles);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    /**
     * viewPager Adapter
     */
    public class SearchResultPagerAdapter extends FragmentStatePagerAdapter {
        public SearchResultPagerAdapter(FragmentManager fm) {super(fm);}
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titlesTab.get(position);
        }
    }
}
