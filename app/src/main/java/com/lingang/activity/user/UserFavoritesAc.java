package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.YuanQuBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.fragment.user.FavoritesBusinessFragment;
import com.lingang.fragment.user.FavoritesCompanyFragment;
import com.lingang.fragment.user.FavoritesNewsFragment;
import com.lingang.fragment.user.FavoritesParkFragment;
import com.lingang.fragment.user.FavoritesPartnerFragment;
import com.lingang.fragment.user.FavoritesPolicyFragment;
import com.lingang.fragment.user.FavoritesPublicFragment;
import com.lingang.fragment.user.FavoritesServicesFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.NoScrollViewPager;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 我的收藏
 */
public class UserFavoritesAc extends BaseAc implements OnTabSelectListener {

    @BindView(R.id.favorites_stl)
    SlidingTabLayout favoritesStl;
    @BindView(R.id.favorites_viewpager)
    NoScrollViewPager favoritesViewpager;
    @BindView(R.id.error_fl)
    FrameLayout errorFl;

    private ArrayList<Fragment> fragmentList;
    private FavoritePagerAdapter pagerAdapter;
    private PagerHelper pagerHelper;
    private List<YuanQuBean.DataBean.ListBean.DataMapBean> mapLists;
    private int pageSelect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_user_favorites);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setTitle(getString(R.string.favorites));
        pagerHelper = new PagerHelper(this, 1, 50);
        handleFavoritesHttp();
    }

    /**
     * 设置viewpager数据
     */
    private void initViewpager() {
        pagerAdapter = new FavoritePagerAdapter(getSupportFragmentManager());
        favoritesViewpager.setAdapter(pagerAdapter);
        favoritesViewpager.setOffscreenPageLimit(10);
//        favoritesViewpager.setCurrentItem(pageSelect);

        favoritesStl.setViewPager(favoritesViewpager);
        favoritesStl.setCurrentTab(pageSelect,true);
        favoritesStl.setOnTabSelectListener(UserFavoritesAc.this);
    }

    /**
     * 绑定收藏
     */
    private void bindFavorites() {
        //下面代码重构-》反射
        fragmentList = new ArrayList<>();
        Bundle bundle;
        for (int i = 0; i < mapLists.size(); i++) {
            switch (mapLists.get(i).getId()) {
                case Constants.FavoritesType.Group://收藏
                    FavoritesParkFragment parkFragment = new FavoritesParkFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    parkFragment.setArguments(bundle);
                    fragmentList.add(parkFragment);
                    break;
                case Constants.FavoritesType.PARTNER://合作伙伴
                    FavoritesPartnerFragment partnerFragment = new FavoritesPartnerFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    partnerFragment.setArguments(bundle);
                    fragmentList.add(partnerFragment);
                    break;
                case Constants.FavoritesType.SERVICE://服务机构
                    FavoritesServicesFragment servicesFragment = new FavoritesServicesFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    servicesFragment.setArguments(bundle);
                    fragmentList.add(servicesFragment);
                    break;
                case Constants.FavoritesType.ENTRY://入驻企业
                    FavoritesCompanyFragment companyFragment = new FavoritesCompanyFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    companyFragment.setArguments(bundle);
                    fragmentList.add(companyFragment);
                    break;
                case Constants.FavoritesType.PUBLIC://公共平台
                    FavoritesPublicFragment publicFragment = new FavoritesPublicFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    publicFragment.setArguments(bundle);
                    fragmentList.add(publicFragment);
                    break;
                case Constants.FavoritesType.BUSINESS://租售物业
                    FavoritesBusinessFragment favoritesFragment = new FavoritesBusinessFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    favoritesFragment.setArguments(bundle);
                    fragmentList.add(favoritesFragment);
                    break;
                case Constants.FavoritesType.NEWS://新闻
                    FavoritesNewsFragment newsFragment = new FavoritesNewsFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    newsFragment.setArguments(bundle);
                    fragmentList.add(newsFragment);
                    break;
                case Constants.FavoritesType.POLICY://政策
                    FavoritesPolicyFragment policyFragment = new FavoritesPolicyFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", true);
                    policyFragment.setArguments(bundle);
                    fragmentList.add(policyFragment);
                    break;
            }
        }
    }

    /**
     * viewPager Adapter
     */
    public class FavoritePagerAdapter extends FragmentStatePagerAdapter {
        public FavoritePagerAdapter(FragmentManager fm) {
            super(fm);
        }

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
            return mapLists.get(position).getName();
        }
    }

    @Override
    public void onTabSelect(int position) {
        pageSelect = position;
    }

    @Override
    public void onTabReselect(int position) {
    }

    /**
     * 收藏
     */
    public void handleFavoritesHttp() {
        if (favoritesViewpager != null) {
            favoritesViewpager.setCurrentItem(0);
        }
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        httpParams.put("collectType", Constants.FavoritesType.Group);
        OkGo.post(HttpApi.UserCollect)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<YuanQuBean.DataBean, YuanQuBean.DataBean.ListBean.DataMapList>>(UserFavoritesAc.this, false) {
                    @Override
                    public void onCall(BaseEntity<YuanQuBean.DataBean, YuanQuBean.DataBean.ListBean.DataMapList> entity, Call call, Response response) throws JSONException {
                        if (entity != null && entity.getDataMap() != null) {
                            mapLists = entity.getDataMap().getList();
                            if (mapLists != null && mapLists.size() > 0) {
                                errorFl.setVisibility(View.GONE);
                                bindFavorites();
                                initViewpager();
                            } else {
                                errorFl.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                });
    }

    /**
     * 跳转页面
     */
    public static void goToUserFavoritesAc(Context context) {
        Intent intent = new Intent(context, UserFavoritesAc.class);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.refreshCode:
                handleFavoritesHttp();
                break;
        }
    }
}
