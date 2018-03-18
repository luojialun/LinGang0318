package com.lingang.activity.business;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.TunityDetailesBean;
import com.lingang.common.Constants;
import com.lingang.fragment.update.UpdateTunityOneFr;
import com.lingang.utils.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class UpdateTunityAc extends BaseAc {

    public String keyId;
    public String opportunityId;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tunity);
        PermissionUtils.checkPermission(this, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE});
        keyId = getIntent().getStringExtra(Constants.KEY_ID);
        opportunityId = getIntent().getStringExtra(Constants.OPPORTUNITY_ID);

        addFragment(new UpdateTunityOneFr());
        showFragment(0);
    }

    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.update_fl, fragment);
        transaction.commit();
    }

    public void showFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        transaction.show(fragmentList.get(position));
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (fragmentList.size() > 0) {
            for (Fragment fragment : fragmentList) {
                transaction.hide(fragment);
            }
        }
    }

    /**
     * 商机详情数据类  用以更新保存数据
     */
    public TunityDetailesBean tunityDetailesBean;

    public TunityDetailesBean getTunityDetailesBean() {
        return tunityDetailesBean;
    }

    public void setTunityDetailesBean(TunityDetailesBean tunityDetailesBean) {
        this.tunityDetailesBean = tunityDetailesBean;
    }
}
