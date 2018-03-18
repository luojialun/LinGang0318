package com.lingang.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.GroomDgAdapter;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ParkUserListBean;
import com.lingang.callback.DialogOnclinck;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class GroomDialog extends Dialog implements RecycleBaseAdapter.OnItemClickListener {
    private Activity activity;
    private DialogOnclinck dialogOnclic;
    private String sign = "GroomDialog";
    private RecyclerView recycleView;
    private List<ParkUserListBean> list;
    private TextView title;
    private String titleValue = "";

    public GroomDialog(Activity activity, DialogOnclinck dialogOnclic) {
        super(activity, R.style.ActionSheetDialogStyle);
        this.activity = activity;
        this.dialogOnclic = dialogOnclic;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_groom);
        setViewLocation();
        setCanceledOnTouchOutside(true);//外部点击取消
        init();
    }

    /**
     * 设置dialog位于屏幕底部
     */
    private void setViewLocation() {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = height;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }


    private void init() {

        recycleView = (RecyclerView) findViewById(R.id.recyclerview);
        title = (TextView) findViewById(R.id.tv_groom_title);
        if (!TextUtils.isEmpty(titleValue))
            title.setText(titleValue);

        findViewById(R.id.groom_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recycleView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(linearLayoutManager);
        GroomDgAdapter groomDgAdapter = new GroomDgAdapter(activity, list);
        groomDgAdapter.setOnItemClickListener(this);
        recycleView.setAdapter(groomDgAdapter);
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setTitle(String titleValue) {
        this.titleValue = titleValue;
    }

    public void setData(List<ParkUserListBean> list) {
        this.list = list;
    }


    @Override
    public void onItemClick(View view, Object item, int position) {
        dialogOnclic.dialogOnclicCall(list.get(position).getParkId(), list.get(position).getParkName());
        dismiss();
    }
}
