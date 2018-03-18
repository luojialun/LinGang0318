package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.base.BaseAc;
import com.lingang.common.Constants;

import butterknife.OnClick;

public class TunityResultAc extends BaseAc {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_tunity_result);
        setTitle("认领结果");
    }

    @Override
    public void clickLeft() {
        startActivity(new Intent(this, RlTunityAc.class).putExtra("tag", "result"), true);
    }


    @OnClick({R.id.tv_look, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_look:
                Intent intent = new Intent(this,OpportunityDetailsAc.class);
                intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "1");//状态类型
                intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExecute);//页面类型(推荐商机，我的审核，我的执行)
                intent.putExtra("tag", "TunityResultAc");
                intent.putExtra(Constants.OPP_DETAILS_ID, getIntent().getStringExtra(Constants.KEY_ID));//商机详情ID
                intent.putExtra(Constants.OPP_LAND_TYPE,
                        new Constants.ParamLandType(getIntent().getStringExtra("plan"),
                                getIntent().getStringExtra("work"),
                                getIntent().getStringExtra("land"),
                                getIntent().getStringExtra("zhuc")));//需求类型(厂房,研发办公,土地,注册型企业)  有  1  没有 0
                startActivity(intent);
                break;
            case R.id.btn_next:
                startActivity(new Intent(this, RlTunityAc.class).putExtra("tag", "result"), true);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, RlTunityAc.class).putExtra("tag", "result"), true);
    }
}
