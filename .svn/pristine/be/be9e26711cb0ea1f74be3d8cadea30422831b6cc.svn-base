package com.lingang.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.lingang.R;
import com.lingang.adapter.RvCenterTvAdapter;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ParkUserListBean;
import com.lingang.callback.PopConfirmClinck;
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
public class RvCenterTvPop extends PopupWindow implements RecycleBaseAdapter.OnItemClickListener {

    private final int screenHeight;
    RecyclerView rv_level;
    private Context context;
    private List<ParkUserListBean> list;
    private RvCenterTvAdapter popLevelAdapter;
    private PopConfirmClinck listion;
    private String sign;
    private View greenView;

    public RvCenterTvPop(Context context, PopConfirmClinck listion ,String sign) {
        super(context);
        this.context = context;
        this.listion = listion;
        this.sign = sign;
        screenHeight = ScreenSizeUtils.getInstance(context).getScreenHeight();
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.rv_center_pop, null);

        rv_level = (RecyclerView) conentView.findViewById(R.id.rv_level);
        greenView = conentView.findViewById(R.id.vv_pop);
        greenView.setOnClickListener(new View.OnClickListener() {
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

    public void setData(List<ParkUserListBean> data) {

        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                data.get(i).setCheack(true);
            } else {
                data.get(i).setCheack(false);
            }
        }
        list = data;
        popLevelAdapter = new RvCenterTvAdapter(context, data);
        popLevelAdapter.setOnItemClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_level.setLayoutManager(linearLayoutManager);
        rv_level.setAdapter(popLevelAdapter);
    }


    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            if (list != null && list.size() > 10){
                rv_level.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,3f));
            }else {
                rv_level.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            }
            greenView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,1f));
            getContentView().requestLayout();

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
        for (ParkUserListBean listBean : list
                ) {
            listBean.setCheack(false);
        }
        list.get(position).setCheack(!list.get(position).isCheack());
        listion.popConfirmClinck(sign,list.get(position).getParkId() + "|" + list.get(position).getParkName());
        popLevelAdapter.notifyDataSetChanged();
        dismiss();
    }
}
