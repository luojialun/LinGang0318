package com.lingang.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.lingang.R;
import com.lingang.adapter.CustomerPop2Adapter;
import com.lingang.base.RecycleBaseAdapter;

import java.util.List;

/**
 * Created by luojialun on 2017/8/21.
 */

public class CustomerPop2 extends PopupWindow {
    private List<String> mList;
    private Activity mActivity;
    private CustomerPop2Adapter adapter;

    public CustomerPop2(Context context, List<String> mList) {
        super(context);
        this.mList = mList;
        this.mActivity = (Activity) context;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.pop_customer2, null);
        initView(contentView);
        // 设置SelectPicPopupWindow的View
        this.setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(false);
        // 刷新状态
//        this.update();
//        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(new BitmapDrawable());
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);
    }

    private void initView(View contentView) {
        RecyclerView popRv = (RecyclerView) contentView.findViewById(R.id.pop_rv);
        popRv.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new CustomerPop2Adapter(mActivity, mList);
        popRv.setAdapter(adapter);
        View view = contentView.findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        adapter.setOnItemClickListener(new RecycleBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                if (null != onItemClickListener) {
                    onItemClickListener.onItemClick(view, (String) item, position);
                    adapter.setItemSelected((String) item);
                }
            }
        });
    }

    public void setData(List<String> data) {
        adapter.setmList(data);
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
        if (Build.VERSION.SDK_INT == 24) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }
        super.showAsDropDown(anchor);
    }

    public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, String item, int position);
    }

    /**
     * 设置选中状态
     *
     * @param str
     */
    public void setSelected(String str) {
        adapter.setItemSelected(str);
    }

}
