package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.lingang.fragment.user.FavoritesParkFragment;
import com.lingang.fragment.user.FavoritesPartnerFragment;
import com.lingang.fragment.user.FavoritesPublicFragment;
import com.lingang.fragment.user.FavoritesServicesFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
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
 * 我的记录
 */
public class UserRecordAc extends BaseAc implements OnTabSelectListener {

    @BindView(R.id.favorites_stl)
    SlidingTabLayout favoritesStl;
    @BindView(R.id.favorites_viewpager)
    ViewPager favoritesViewpager;
    @BindView(R.id.error_ll)
    LinearLayout errorLl;

    private ArrayList<Fragment> fragmentList;
    private FavoritePagerAdapter pagerAdapter;
    private PagerHelper pagerHelper;
    private List<YuanQuBean.DataBean.ListBean.DataMapBean> mapLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_user_record);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * initView
     */
    private void initView() {
        setTitle(getString(R.string.mine_record));
        pagerHelper = new PagerHelper(this, 1, 50);
        handleRecordHttp();
    }

    //设置viewpager数据
    private void initViewpager() {
        pagerAdapter = new FavoritePagerAdapter(getSupportFragmentManager());
        favoritesViewpager.setAdapter(pagerAdapter);
        favoritesViewpager.setOffscreenPageLimit(10);
        favoritesViewpager.setCurrentItem(0);

        favoritesStl.setViewPager(favoritesViewpager);
        favoritesStl.setOnTabSelectListener(UserRecordAc.this);
    }

    //绑定记录
    private void bindRecord() {
        //下面代码重构-》反射
        fragmentList = new ArrayList<>();
        Bundle bundle;
        for (int i = 0; i < mapLists.size(); i++) {
            switch (mapLists.get(i).getId()) {
                case Constants.RecordType.PARK:
                    FavoritesParkFragment parkFragment = new FavoritesParkFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", false);
                    parkFragment.setArguments(bundle);
                    fragmentList.add(parkFragment);
                    break;
                case Constants.RecordType.Partner:
                    FavoritesPartnerFragment partnerFragment = new FavoritesPartnerFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", false);
                    partnerFragment.setArguments(bundle);
                    fragmentList.add(partnerFragment);
                    break;
                case Constants.RecordType.Service:
                    FavoritesServicesFragment servicesFragment = new FavoritesServicesFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", false);
                    servicesFragment.setArguments(bundle);
                    fragmentList.add(servicesFragment);
                    break;
                case Constants.RecordType.Entry:
                    FavoritesCompanyFragment companyFragment = new FavoritesCompanyFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", false);
                    companyFragment.setArguments(bundle);
                    fragmentList.add(companyFragment);
                    break;
                case Constants.RecordType.Public:
                    FavoritesPublicFragment publicFragment = new FavoritesPublicFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", false);
                    publicFragment.setArguments(bundle);
                    fragmentList.add(publicFragment);
                    break;
                case Constants.RecordType.Business:
                    FavoritesBusinessFragment favoritesFragment = new FavoritesBusinessFragment();
                    bundle = new Bundle();
                    bundle.putInt("collectType", mapLists.get(i).getId());
                    bundle.putBoolean("isFavorites", false);
                    favoritesFragment.setArguments(bundle);
                    fragmentList.add(favoritesFragment);
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
    }

    @Override
    public void onTabReselect(int position) {
    }

    /**
     * 记录
     */
    public void handleRecordHttp() {
        if (favoritesViewpager != null) {
            favoritesViewpager.setCurrentItem(0);
        }
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        httpParams.put("type", Constants.RecordType.PARK);
        OkGo.post(HttpApi.searchMyRecord)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<YuanQuBean.DataBean, YuanQuBean.DataBean.ListBean.DataMapList>>(UserRecordAc.this, false) {
                    @Override
                    public void onCall(BaseEntity<YuanQuBean.DataBean, YuanQuBean.DataBean.ListBean.DataMapList> entity, Call call, Response response) throws JSONException {
                        List<YuanQuBean.DataBean.ListBean> list = entity.getData().getList();
                        if (entity != null && entity.getDataMap() != null) {
                            mapLists = entity.getDataMap().getList();
                            if (mapLists != null && mapLists.size() > 0) {
                                errorLl.setVisibility(View.GONE);
                                bindRecord();
                                initViewpager();
                            } else {
                                errorLl.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                });
    }

    /**
     * 跳转页面
     */
    public static void goToUserRecordAc(Context context) {
        Intent intent = new Intent(context, UserRecordAc.class);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case Constants.refreshCode:
                initView();
                break;
        }
    }
}
