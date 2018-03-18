package com.lingang.activity.home.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.systembar.SystemBarHelper;
import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.SearchHistory;
import com.lingang.fragment.home.search.HomeSearchFragment;
import com.lingang.fragment.home.search.HomeSearchResultFragment;
import com.lingang.greendao.DaoSession;
import com.lingang.greendao.SearchHistoryDao;
import com.lingang.utils.ToastUtils;
import com.lingang.view.ClearableEditText;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页搜索结果页面
 */
public class HomeSearchActivity extends BaseAc {
    private String keywords;   //用户输入的关键字
    @BindView(R.id.home_search_left_back_iv)
    ImageView homeSearchLeftBackIv;
    @BindView(R.id.home_search_input_et)
    ClearableEditText homeSearchInputEt;
    @BindView(R.id.search_all_toolbar_rl)
    LinearLayout searchAllToolbarRl;
    @BindView(R.id.home_search_fragment)
    FrameLayout homeSearchFragment;

    private DaoSession daoSession;
    private SearchHistoryDao searchHistoryDao;
    private List<SearchHistory> searchHistories;
    private Fragment newFragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);
        ButterKnife.bind(this);
        SystemBarHelper.setHeightAndPadding(this, searchAllToolbarRl);
        initData();
        initView();
    }

    private void initData() {
        daoSession = App.getInstance().getDaoSession();
        searchHistoryDao = daoSession.getSearchHistoryDao();
        searchHistories = searchHistoryDao.loadAll();
    }

    private void initView() {
        homeSearchInputEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    keywords = homeSearchInputEt.getText().toString().trim();
                    if (!TextUtils.isEmpty(keywords)) {
                        //把搜索关键字保存的本地数据库
                        List<SearchHistory> result = searchHistoryDao.queryBuilder()
                                .where(SearchHistoryDao.Properties.Title.eq(keywords)).list();
                        if (result != null && result.isEmpty()) {
                            SearchHistory searchHistory = new SearchHistory();
                            searchHistory.setCreateTime(System.currentTimeMillis());
                            searchHistory.setTitle(keywords);
                            //把数据保存的数据库
                            searchHistoryDao.save(searchHistory);
                            //通知界面增加关键字
                            searchHistories.add(searchHistory);
                        }
//                        Intent intent = new Intent(getContext(), HomeSearchResultActivity.class);
//                        intent.putExtra("keywords", keywords);
//                        startActivity(intent);
                        if (newFragment instanceof HomeSearchFragment) {
                            loadFragment(SearchResultFragmentIndex, keywords);
                        } else {
                            ((HomeSearchResultFragment) newFragment).searchKey(keywords);
                        }
                    } else {
                        ToastUtils.showToast(HomeSearchActivity.this, "请输入搜索关键字");
                    }
                }
                return false;
            }
        });

        loadFragment(SearchFragmentIndex, "");
    }

    @OnClick(R.id.home_search_left_back_iv)
    public void leftBack(View view) {
        finish();
    }

    public void loadFragment(int fragmentIndex, String key) {
        keywords = key;
        switch (fragmentIndex) {
            case SearchFragmentIndex:
                newFragment = new HomeSearchFragment();
                break;
            case SearchResultFragmentIndex:
                newFragment = new HomeSearchResultFragment();
                Bundle args = new Bundle();
                args.putString("keywords", keywords);
                newFragment.setArguments(args);
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 将 fragment_container View 中的内容替换为此 Fragment ，
        // 然后将该事务添加到返回堆栈，以便用户可以向后导航
        transaction.replace(R.id.home_search_fragment, newFragment);
        //transaction.addToBackStack(null);
        // 执行事务
        transaction.commit();
    }

    public static final int SearchFragmentIndex = 1;
    public static final int SearchResultFragmentIndex = 2;

    /**
     * 设置搜索文本
     */
    public void setSearchEditText(String key) {
        homeSearchInputEt.setText(key);
    }

    /**
     * 页面跳转
     *
     * @param context
     */
    public static void goToHomeSearchActivity(Context context) {
        Intent intent = new Intent(context, HomeSearchActivity.class);
        context.startActivity(intent);
    }
}