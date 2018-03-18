package com.lingang.activity.business;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.LvClaimAdapter;
import com.lingang.adapter.LvClaimJiluAdapter;
import com.lingang.adapter.LvImgAdapter;
import com.lingang.base.BaseAc;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.DialogOnclinck;
import com.lingang.dialog.BottomDialog;
import com.lingang.dialog.CancelDialog;
import com.lingang.view.ExtraListView;
import com.lingang.view.flowlayout.FlowLayout;
import com.lingang.view.flowlayout.TagAdapter;
import com.lingang.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class GroomDetailsZhiXAc extends BaseAc implements DialogOnclinck, DialogConfirmListion {

    @BindView(R.id.tf_detailes)
    TagFlowLayout tfDetailes;
    @BindView(R.id.lv_img)
    ExtraListView lvImg;
    @BindView(R.id.lv_explain)
    ExtraListView lvExplain;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.ll_tj_time)
    LinearLayout llTjTime;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.ll_rl_time)
    LinearLayout llRlTime;
    @BindView(R.id.ll_zx_time)
    LinearLayout llZxTime;
    @BindView(R.id.tf_tj)
    TagFlowLayout tfTj;
    @BindView(R.id.sj_rl_time)
    TextView sjRlTime;
    @BindView(R.id.ll_person)
    LinearLayout llPerson;
    @BindView(R.id.ll_sj_rl_time)
    LinearLayout llSjRlTime;
    @BindView(R.id.ll_zs_person)
    LinearLayout llZsPerson;
    @BindView(R.id.sj_jl)
    TextView sjJl;
    @BindView(R.id.lv_jil)
    ExtraListView lvJil;
    @BindView(R.id.tv_sjtj)
    TextView tvSjtj;
    @BindView(R.id.chsm)
    TextView chsm;
    @BindView(R.id.tv_chsm)
    TextView tvChsm;
    @BindView(R.id.ll_ld_time)
    LinearLayout llLdTime;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_time_data)
    TextView tvTimeData;
    private BottomDialog bottomDialog;
    private String tag;
    private CancelDialog cancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_groom_detailes_zx);
        setTitle("商机详情");
        getRightView().setImageResource(R.mipmap.home_more);
        initTabData();
        initView();
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (tag.equals("wait")) {//待认领
            if (cancelDialog == null) {
                cancelDialog = new CancelDialog(this, this);
            }
            cancelDialog.show();

        } else if (tag.equals("executing")) {//执行中
            initBottomDialog();
            bottomDialog.show("添加执行记录","提交审核","撤回商机");
            bottomDialog.setSign("executing");
        }else {//审核未通过
            initBottomDialog();
            bottomDialog.show("提交审核");
            bottomDialog.setSign("executing");
        }
    }

    private void initBottomDialog() {
        if (bottomDialog == null) {
            bottomDialog = new BottomDialog(this, this);
        }
    }

    private void initView() {
        tag = getIntent().getStringExtra("tag");
        if (tag.equals("wait")) { //审核中
            llLdTime.setVisibility(View.GONE);
            tvSjtj.setVisibility(View.GONE);
            tfTj.setVisibility(View.GONE);

            sjRlTime.setVisibility(View.GONE);
            llZsPerson.setVisibility(View.GONE);
            llSjRlTime.setVisibility(View.GONE);
            chsm.setVisibility(View.GONE);
            tvChsm.setVisibility(View.GONE);

            Drawable man = getResources().getDrawable(R.mipmap.shenhezhong);
            man.setBounds(0, 0, man.getMinimumWidth(), man.getMinimumHeight());
            tvState.setCompoundDrawables(null, null, man, null);

        } else if (tag.equals("born")) {//已落地
            tvSjtj.setVisibility(View.GONE);
            tfTj.setVisibility(View.GONE);

            chsm.setVisibility(View.GONE);
            tvChsm.setVisibility(View.GONE);

            Drawable man = getResources().getDrawable(R.mipmap.luodi);
            man.setBounds(0, 0, man.getMinimumWidth(), man.getMinimumHeight());
            tvState.setCompoundDrawables(null, null, man, null);


        } else if (tag.equals("retract")) {//已撤回
            tvTime.setText("撤回时间");
            tvSjtj.setVisibility(View.GONE);
            tfTj.setVisibility(View.GONE);

            Drawable man = getResources().getDrawable(R.mipmap.yichehui);
            man.setBounds(0, 0, man.getMinimumWidth(), man.getMinimumHeight());
            tvState.setCompoundDrawables(null, null, man, null);


        } else if (tag.equals("executing")) {//执行中
            llLdTime.setVisibility(View.GONE);
            sjRlTime.setVisibility(View.GONE);
            llSjRlTime.setVisibility(View.GONE);

            tfTj.setVisibility(View.GONE);
            tvSjtj.setVisibility(View.GONE);
            chsm.setVisibility(View.GONE);
            tvChsm.setVisibility(View.GONE);

            Drawable man = getResources().getDrawable(R.mipmap.zhixing);
            man.setBounds(0, 0, man.getMinimumWidth(), man.getMinimumHeight());
            tvState.setCompoundDrawables(null, null, man, null);

        }else {//审核未通过
            chsm.setText("未通过原因");
            Drawable man = getResources().getDrawable(R.mipmap.shenheweitongguo);
            man.setBounds(0, 0, man.getMinimumWidth(), man.getMinimumHeight());
            tvState.setCompoundDrawables(null, null, man, null);
        }


        LvImgAdapter lvImgAdapter = new LvImgAdapter(this, new ArrayList<String>());
        lvImg.setAdapter(lvImgAdapter);

        LvClaimAdapter lvClaimAdapter = new LvClaimAdapter(this, new ArrayList<String>());
        lvExplain.setAdapter(lvClaimAdapter);

        LvClaimJiluAdapter lvClaimjiluAdapter = new LvClaimJiluAdapter(this, new ArrayList<String>());
        lvJil.setAdapter(lvClaimjiluAdapter);
    }

    private void initTabData() {
        final ArrayList<String> classList = new ArrayList<>();
        classList.add("注册企业");
        classList.add("租住场地");
        classList.add("购买土地");

        tfDetailes.setAdapter(new TagAdapter(classList) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView lableTv = (TextView) LayoutInflater.from(GroomDetailsZhiXAc.this).inflate(R.layout.tv_tagflow, null);
                lableTv.setText(classList.get(position));
                return lableTv;
            }
        });

        tfTj.setAdapter(new TagAdapter(classList) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView lableTv = (TextView) LayoutInflater.from(GroomDetailsZhiXAc.this).inflate(R.layout.tv_tagflow, null);
                lableTv.setText(classList.get(position));
                return lableTv;
            }
        });
    }

    @OnClick({R.id.tv_sex, R.id.ll_zs_person})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_sex:
                initBottomDialog();
                bottomDialog.setSign("sex");
                bottomDialog.show("男", "女", "未知");
                break;
            case R.id.ll_zs_person:
                startActivity(new Intent(this,PersonInfoActivity.class));
                break;
        }
    }

    @Override
    public void dialogOnclicCall(String btnTag, String sign) {

        if (sign.equals("sex")) {
            switch (btnTag) {
                case "btn_one"://男
                    Drawable man = getResources().getDrawable(R.mipmap.man);
                    man.setBounds(0, 0, man.getMinimumWidth(), man.getMinimumHeight());
                    tvSex.setCompoundDrawables(null, null, man, null);
                    break;
                case "btn_two"://女
                    Drawable women = getResources().getDrawable(R.mipmap.women);
                    women.setBounds(0, 0, women.getMinimumWidth(), women.getMinimumHeight());
                    tvSex.setCompoundDrawables(null, null, women, null);
                    break;
                case "btn_there"://未知
                    break;
            }
        } else if (sign.equals("executing")) {//执行中
            switch (btnTag) {
                case "btn_one"://需求补充说明
                    startActivity(new Intent(this, SuppiyAc.class).putExtra("tag", "zhix"));
                    break;
                case "btn_two"://提交审核
                    startActivity(new Intent(this, ContracAc.class));
                    break;
                case "btn_there"://撤回商机
                    startActivity(new Intent(this, ReasonsAc.class));
                    break;
            }

        }

    }

    //待认领弹框 确定点击事件
    @Override
    public void confirmClick(String sign) {

    }
}
