package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.adapter.SendSuccesAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.common.LoginManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class SendSuccessParkAc extends BaseAc {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.tv_susend)
    TextView tvSusend;
    @BindView(R.id.tv_ts)
    TextView tvTs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_send_success_park);
        setTitle("推荐结果");

        String userType = LoginManager.getInstance().getUserInfo().getUserType();
        if (userType.equals("1") || userType.equals("3") || userType.equals("4")) {
            tvSusend.setText("已成功提交审核");
            tvTs.setText("该商机拟推荐至以下园区:");
        }
        ArrayList<TjTunityThreeBean.DataMapBean.ParkListBean> list = (ArrayList<TjTunityThreeBean.DataMapBean.ParkListBean>) getIntent().getSerializableExtra("list");
        setRecycleAspect(recyclerview);
        recyclerview.setAdapter(new SendSuccesAdapter(this, list));
    }

    @OnClick(R.id.btn_succ_park)
    public void onViewClicked() {
        startActivity(new Intent(this, MainActivity.class),true);
    }

    @Override
    public void clickLeft() {
        startActivity(new Intent(this, MainActivity.class),true);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class),true);
    }
}
