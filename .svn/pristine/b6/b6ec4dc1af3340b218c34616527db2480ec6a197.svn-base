package com.lingang.dialog;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.lingang.R;
import com.lingang.adapter.PopClassAdapter;
import com.lingang.adapter.PopLevelAdapter;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BasicsBean;
import com.lingang.bean.TypeListBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.utils.ScreenSizeUtils;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.dialog
 * @class describe
 * @anthor Administrator
 * @time 2017/5/22 0022 14:37
 * @change
 * @chang time
 * @class describe
 */
public class OneClassPop extends PopupWindow implements RecycleBaseAdapter.OnItemClickListener {

    RecyclerView rv_level;
    private Context context;
    private List<BasicsBean.DataBean> list;
    private PopClassAdapter popLevelAdapter;
    private DialogConfirmListion listion;

    public OneClassPop(Context context, DialogConfirmListion listion) {
        super(context);
        this.context = context;
        this.listion = listion;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.one_level_pop, null);

        rv_level = (RecyclerView) conentView.findViewById(R.id.rv_level);

        // 设置的View
        this.setContentView(conentView);
        // 设置弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体的高
        this.setHeight(ScreenSizeUtils.getInstance(context).getScreenHeight() - 600);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
//        this.update();
//        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(new BitmapDrawable());
        // 设置弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);


    }

    public void setData(List<BasicsBean.DataBean> data) {

        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                data.get(i).setIsselect(true);
            } else {
                data.get(i).setIsselect(false);
            }
        }

        list = data;
        popLevelAdapter = new PopClassAdapter(context, data);
        popLevelAdapter.setOnItemClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(context.getResources().getDrawable(R.drawable.main_item_divider));//R.drawable.main_item_divider
        rv_level.addItemDecoration(dividerItemDecoration1);

        rv_level.setLayoutManager(linearLayoutManager);
        rv_level.setAdapter(popLevelAdapter);
    }


    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        for (BasicsBean.DataBean listBean : list
                ) {
            listBean.setIsselect(false);
        }
        list.get(position).setIsselect(!list.get(position).isselect());
        listion.confirmClick("class|"+list.get(position).getBasicsId() + "|" + list.get(position).getBasicsName());
        popLevelAdapter.notifyDataSetChanged();
        dismiss();
    }
}
