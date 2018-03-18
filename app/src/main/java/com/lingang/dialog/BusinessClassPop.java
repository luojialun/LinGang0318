package com.lingang.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.lingang.R;
import com.lingang.adapter.BusinessPopAdapter;
import com.lingang.adapter.PopLevelAdapter;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AllClassBean;
import com.lingang.bean.TypeListBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.adapterUtils.AnimationUtil;

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
public class BusinessClassPop extends PopupWindow implements RecycleBaseAdapter.OnItemClickListener {

    RecyclerView rv_level;
    private Context context;
    private List<AllClassBean.DataBean> list;
    private BusinessPopAdapter popLevelAdapter;
    private DialogConfirmListion listion;

    public BusinessClassPop(Context context, DialogConfirmListion listion) {
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
        conentView.findViewById(R.id.vv_pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 设置的View
        this.setContentView(conentView);
        // 设置弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体的高  ScreenSizeUtils.getInstance(context).getScreenHeight() - 600
        this.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
//        this.update();
//        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(new BitmapDrawable());

        // 设置弹出窗体动画效果
//        this.setAnimationStyle(R.style.AnimationPreview);

    }

    public void setData(List<AllClassBean.DataBean> data) {

        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                data.get(i).setIsselect(true);
            } else {
                data.get(i).setIsselect(false);
            }
        }
        list = data;
        popLevelAdapter = new BusinessPopAdapter(context, data);
        popLevelAdapter.setOnItemClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(context.getResources().getDrawable(R.drawable.main_item_divider));//R.drawable.main_item_divider
        rv_level.addItemDecoration(dividerItemDecoration1);

        rv_level.setLayoutManager(linearLayoutManager);
        rv_level.setAdapter(popLevelAdapter);
    }

    public int getIndex() {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isselect()) {
                index = i;
            }
        }
        return index;
    }

    public void selectIndex(int index) {
        for (AllClassBean.DataBean dataBean :
                list) {
            dataBean.setIsselect(false);
        }
        list.get(index).setIsselect(true);
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void showAsDropDown(View anchor) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }
        super.showAsDropDown(anchor);

    }

    public static void showAsDropDown(PopupWindow pw, View anchor, int xoff, int yoff) {
        if (Build.VERSION.SDK_INT >= 24) {
            int[] location = new int[2];
            anchor.getLocationOnScreen(location);
            // 7.1 版本处理
            if (Build.VERSION.SDK_INT == 25) {
                //【note!】Gets the screen height without the virtual key
                WindowManager wm = (WindowManager) pw.getContentView().getContext().getSystemService(Context.WINDOW_SERVICE);
                int screenHeight = wm.getDefaultDisplay().getHeight();
                /*
                /*
                 * PopupWindow height for match_parent,
                 * will occupy the entire screen, it needs to do special treatment in Android 7.1
                */
                pw.setHeight(screenHeight - location[1] - anchor.getHeight() - yoff);
            }
            pw.showAtLocation(anchor, Gravity.NO_GRAVITY, xoff, location[1] + anchor.getHeight() + yoff);
        } else {
            pw.showAsDropDown(anchor, xoff, yoff);
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        for (AllClassBean.DataBean listBean : list
                ) {
            listBean.setIsselect(false);
        }
        list.get(position).setIsselect(!list.get(position).isselect());
        listion.confirmClick("class|" + list.get(position).getBasicsId() + "|" + list.get(position).getBasicsName());
        popLevelAdapter.notifyDataSetChanged();
        dismiss();
    }
}
