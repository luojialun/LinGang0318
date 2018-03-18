package com.lingang.activity.business;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.ClaimAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.RefreshListion;
import com.lingang.dialog.CustomerPop;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClaimAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener,
        RadioGroup.OnCheckedChangeListener,
        RefreshListion, PopupWindow.OnDismissListener, DialogConfirmListion {

    @BindView(R.id.left_btn)
    ImageView leftBtn;
    @BindView(R.id.title_rbleft)
    RadioButton titleRbleft;
    @BindView(R.id.title_rbright)
    RadioButton titleRbright;
    @BindView(R.id.title_rg)
    RadioGroup titleRg;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_news)
    TextView tvNews;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    private int tabTag = 0;//默认选择商机池  1 指定我的
    private CustomerPop customerPop;
    private boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim);
        ButterKnife.bind(this);
        titleRbleft.setText("商机池");
        titleRbright.setText("指定我的");
        Spannable span = new SpannableString("共有0条查询结果");
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvNews.setText(span);

        titleRg.check(R.id.title_rbleft);
        titleRg.setOnCheckedChangeListener(this);
        initView();

    }

    private void initView() {
        setRefreshHead(refresh);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRecycleAspect(recyclerview);

        setRefreshLison(refresh, this);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("");
        }
        ClaimAdapter claimAdapter = new ClaimAdapter(this, strings);
        recyclerview.setAdapter(claimAdapter);
        claimAdapter.setOnItemClickListener(this);
    }

    @OnClick({R.id.left_btn, R.id.ll_tag})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.ll_tag:

                Drawable nav_up = getResources().getDrawable(R.mipmap.up);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvAll.setCompoundDrawables(null, null, nav_up, null);
                if (customerPop == null) {
                    customerPop = new CustomerPop(this,this);
                    customerPop.setOnDismissListener(this);
                }
                customerPop.showPopupWindow(tvNews);
                break;
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        Intent intent = new Intent(this, ClaimDetailesAc.class);
        intent.putExtra("tag", tabTag);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.title_rbleft:
                tabTag = 0;
                break;
            case R.id.title_rbright:
                tabTag = 1;
                break;
        }
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void onDismiss() {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvAll.setCompoundDrawables(null, null, nav_up, null);
    }

    //pop点击事件
    @Override
    public void confirmClick(String sign) {
        switch (sign) {
            case "pop_all":
                break;
            case "pop_rl":
                break;
            case "pop_zx":
                break;
            case "pop_ld":
                break;
            case "pop_ch":
                break;
        }

    }
}
