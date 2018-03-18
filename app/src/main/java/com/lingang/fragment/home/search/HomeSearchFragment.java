package com.lingang.fragment.home.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.search.HomeSearchActivity;
import com.lingang.adapter.HomeSearchHistoryAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.bean.HotKeywordsResponse;
import com.lingang.bean.SearchHistory;
import com.lingang.common.LoginManager;
import com.lingang.greendao.DaoSession;
import com.lingang.greendao.SearchHistoryDao;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.ExtraListView;
import com.lingang.view.flowlayout.FlowLayout;
import com.lingang.view.flowlayout.TagAdapter;
import com.lingang.view.flowlayout.TagFlowLayout;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 全部页面查找
 */
public class HomeSearchFragment extends BaseFragment {
    @BindView(R.id.Home_search_listview)
    ExtraListView HomeSearchListview;
    @BindView(R.id.main_search_tagflowlayout)
    TagFlowLayout mainSearchTagflowlayout;
    @BindView(R.id.main_search_history_clear_ll)
    LinearLayout mainSearchHistoryClearLl;

    private String keywords;   //用户输入的关键字
    private List<HotKeywordsResponse.KeywordBean> keywordList;
    private List<SearchHistory> searchHistories;
    private HomeSearchHistoryAdapter historyAdapter;
    private DaoSession daoSession;
    private SearchHistoryDao searchHistoryDao;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_search, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initListener();
    }

    private void initData() {
        daoSession = App.getInstance().getDaoSession();
        searchHistoryDao = daoSession.getSearchHistoryDao();
        searchHistories = searchHistoryDao.loadAll();
        Collections.reverse(searchHistories);
        //设置是否显示清空历史按钮
        setClearRecoidVisible();
        handleHotSearchHttp();
    }


    private void initListener() {
//      String[] record = new String[]{"上海", "临港集团", "临港集团", "临港集团", "临港集团", "临港集团"};
        historyAdapter = new HomeSearchHistoryAdapter(getContext());
        historyAdapter.setItems(searchHistories);
        HomeSearchListview.setAdapter(historyAdapter);
        HomeSearchListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getContext(), HomeSearchResultActivity.class);
//                intent.putExtra("keywords", historyAdapter.getItem(position).getTitle());
//                startActivity(intent);
                ((HomeSearchActivity)getActivity()).setSearchEditText(historyAdapter.getItem(position).getTitle());
                ((HomeSearchActivity)getActivity()).loadFragment(HomeSearchActivity.SearchResultFragmentIndex,historyAdapter.getItem(position).getTitle());
            }
        });



    }

    //初始化标签
    private void initLables() {
        mainSearchTagflowlayout.setAdapter(new TagAdapter<HotKeywordsResponse.KeywordBean>(keywordList) {
            @Override
            public View getView(FlowLayout parent, int position, HotKeywordsResponse.KeywordBean keywordBean) {
                TextView labelTv = (TextView) getActivity().getLayoutInflater().inflate(R.layout.item_search_hot_lable, null);
                labelTv.setText(keywordList.get(position).getKeywords());
                return labelTv;
            }
        });
        //设置标签的点击事件
        mainSearchTagflowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                HotKeywordsResponse.KeywordBean keywordBean = keywordList.get(position);
//                Intent intent = new Intent(getContext(), HomeSearchResultActivity.class);
//                intent.putExtra("keywords", keywordBean.getKeywords());
//                startActivity(intent);
                ((HomeSearchActivity)getActivity()).setSearchEditText(keywordBean.getKeywords());
                ((HomeSearchActivity)getActivity()).loadFragment(HomeSearchActivity.SearchResultFragmentIndex,keywordBean.getKeywords());
                return false;
            }
        });
    }

    //清空搜索记录
    @OnClick(R.id.main_search_history_clear_ll)
    public void clearRecord(View view) {
        if (searchHistories != null && !searchHistories.isEmpty() && historyAdapter != null) {
            searchHistories.clear();
            historyAdapter.removeItems();
        }
        searchHistoryDao.deleteAll();
        //设置是否显示清空历史按钮
        setClearRecoidVisible();
    }

    /**
     * 获取热门标签
     */
    private void handleHotSearchHttp() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.HOME_HOT_KEYWORD)
                .params(httpParams)
                .execute(new ResCallBack<HotKeywordsResponse>(getContext()) {
                    @Override
                    public void onCall(HotKeywordsResponse hotKeywordsResponse, Call call, Response response) {
                        keywordList = hotKeywordsResponse.getData();
                        if (keywordList != null && !keywordList.isEmpty()) {
                            initLables();
                        }
                    }
                });
    }

    private void setClearRecoidVisible() {
        if (searchHistories != null && !searchHistories.isEmpty()) {
            mainSearchHistoryClearLl.setVisibility(View.VISIBLE);
        } else {
            mainSearchHistoryClearLl.setVisibility(View.INVISIBLE);
        }
    }

}
