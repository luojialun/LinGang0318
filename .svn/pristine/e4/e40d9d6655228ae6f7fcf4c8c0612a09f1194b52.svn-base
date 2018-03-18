package com.lingang.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.NeedBusinessReviewAc;
import com.lingang.activity.user.UserCorrectAc;
import com.lingang.base.BaseFragment;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.ExamineBean;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.MessagePageListBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.RefreshView;
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
 * Created by jason on 17/5/24.
 * 商机审核
 */
public class NeedBusinessFragment extends BaseFragment {

    @BindView(R.id.need_business_refresh)
    TwinklingRefreshLayout needBusinessRefresh;
    //分页
    private PagerHelper pagerHelper;
    private List<ExamineBean> examineList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_need_business, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        examineList=new ArrayList<>();
        RefreshView headerView = new RefreshView(getActivity());
        needBusinessRefresh.setHeaderView(headerView);
        needBusinessRefresh.setAutoLoadMore(true);
        needBusinessRefresh.startRefresh();
        needBusinessRefresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                examineList.clear();
                pagerHelper.refreshPage();
                needBusinessRefresh.finishRefreshing();
                //handleListHttp();
            }
            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {

                if(pagerHelper.loadMore()) {
                    //handleListHttp();
                }else
                {
                    needBusinessRefresh.finishLoadmore();
                }
            }
        });
        pagerHelper=new PagerHelper(getContext());
    }

    /*
     *创建实例
     */
    public static NeedBusinessFragment newInstance() {
        NeedBusinessFragment fragment = new NeedBusinessFragment();
        return fragment;
    }


//    @OnClick({R.id.testClick,R.id.testClick2})
//    public void onViewClicked() {
//        NeedBusinessReviewAc.goToNeedBusinessAc(getContext());
//    }
//

    private void handleListHttp() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        httpParams.put("userId", LoginManager.getInstance().getUserInfo().getUserId());
        OkGo.post(HttpApi.ChanceExamineList)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<List<ExamineBean>,Object>>(getContext(),false) {
                    @Override
                    public void onCall(BaseEntity<List<ExamineBean>,Object> baseEntity, Call call, Response response) {
                       /* List<ExamineBean> list = baseEntity.getData();
                        examineList.addAll(list);
                        //adapterList.notifyDataSetChanged();
                        if(pagerHelper.loadFinish(list.size()))
                        {
                            needBusinessRefresh.finishRefreshing();
                        }else
                        {
                            needBusinessRefresh.finishLoadmore();
                        }*/
                    }
                });
    }
}
