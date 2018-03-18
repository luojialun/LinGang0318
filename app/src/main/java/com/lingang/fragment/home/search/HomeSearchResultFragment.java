package com.lingang.fragment.home.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseFragment;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.SearchHistory;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.greendao.DaoSession;
import com.lingang.greendao.SearchHistoryDao;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 搜索结果页
 */

public class HomeSearchResultFragment extends BaseFragment implements OnTabSelectListener {
    @BindView(R.id.search_result_stl)
    SlidingTabLayout searchResultSTL;
    @BindView(R.id.search_result_viewpager)
    ViewPager searchResultViewpager;
    @BindView(R.id.empty_ll)
    LinearLayout emptyLl;

    private int pageIndex = 1;
    private int pageSize = Constants.PAGE_SIZE;
    private int type;    //类型(1.新闻 2.招商政策 3.产业园区 4.入驻企业 5.合作伙伴 6.租售物业 7.配套服务)
    private String keywords;   //用户输入的关键字
    //private SearchResultFragmentAdapter adapter;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> titlesTab;
    private DaoSession daoSession;
    private SearchHistoryDao searchHistoryDao;
    private SearchResultPagerAdapter pagerAdapter;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_search_result, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        keywords = getArguments().getString("keywords", App.Empty);;
        initData();
        handleSearchHttp();
    }

    private void initData() {
        daoSession = App.getInstance().getDaoSession();
        searchHistoryDao = daoSession.getSearchHistoryDao();
    }

    //设置viewpager数据
    private void initViewpager() {
        pagerAdapter = new SearchResultPagerAdapter(getActivity().getSupportFragmentManager());
        searchResultViewpager.setAdapter(pagerAdapter);
        searchResultViewpager.setOffscreenPageLimit(10);
        searchResultViewpager.setCurrentItem(0);

        searchResultSTL.setViewPager(searchResultViewpager);
        searchResultSTL.setOnTabSelectListener(this);
    }

    /**
     * 搜索
     * @param key
     */
    public void searchKey(String key)
    {
        keywords=key;
        searchResultViewpager.setCurrentItem(0);
        handleSearchHttp();
    }
    @Override
    public void onTabSelect(int position) {}

    @Override
    public void onTabReselect(int position) {}

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
                .execute(new ResCallBack<String>(getContext()) {
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
    //处理回复数据解析
    private void handleResulData(String responseData) {
        try {
            ////类型(1.新闻 2.招商政策 3.产业园区 4.入驻企业 5.合作伙伴 6.租售物业 7.配套服务)
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


            Type dataType;
            if (typeList != null && !typeList.isEmpty()) {
                emptyLl.setVisibility(View.GONE);
                for (int i = 0; i < typeList.size(); i++) {
                    int id = typeList.get(i).getId();
                    titlesTab.add(typeList.get(i).getName());
                    Bundle bundle = new Bundle();
                    bundle.putString("keywords", keywords);
                    bundle.putInt("type", id);
                    switch (id) {
                        case 1://新闻
                            SearchNewsFragment newsFragment = new SearchNewsFragment();
                            newsFragment.setArguments(bundle);
                            fragmentList.add(newsFragment);
                            break;
                        case 2://招商政策
                            SearchPolicyFragment policyFragment = new SearchPolicyFragment();
                            policyFragment.setArguments(bundle);
                            fragmentList.add(policyFragment);
                            break;
                        case 3://产业园区
                            SearchParkFragment parkFragment = new SearchParkFragment();
                            parkFragment.setArguments(bundle);
                            fragmentList.add(parkFragment);
                            break;
                        case 4://入驻企业
                            SearchStationFragment stationFragment = new SearchStationFragment();
                            stationFragment.setArguments(bundle);
                            fragmentList.add(stationFragment);
                            break;
                        case 5://合作伙伴
                            SearchPartnerFragment partnerFragment = new SearchPartnerFragment();
                            partnerFragment.setArguments(bundle);
                            fragmentList.add(partnerFragment);
                            break;
                        case 6://租售物业
                            SearchRentalFragment rentalFragment=new SearchRentalFragment();
                            rentalFragment.setArguments(bundle);
                            fragmentList.add(rentalFragment);
                            break;
                        case 7://配套服务
                            SearchServiceFragment servicesFragment = new SearchServiceFragment();
                            servicesFragment.setArguments(bundle);
                            fragmentList.add(servicesFragment);
                        break;
                        case 8://公共平台
                            SearchPublicFragment publicFragment = new SearchPublicFragment();
                            publicFragment.setArguments(bundle);
                            fragmentList.add(publicFragment);
                            break;
                        case 9://产业集群
                            SearchClusterFragment clusterFragment = new SearchClusterFragment();
                            clusterFragment.setArguments(bundle);
                            fragmentList.add(clusterFragment);
                            break;
                    }
                }
            }else{
                emptyLl.setVisibility(View.VISIBLE);
            }
            //初始化viewpager的数据
            initViewpager();
            //初始化指示器
            //renderTabTitle(titles);

        } catch (JSONException e) {
            e.printStackTrace();
        }
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
