package com.lingang.dialog;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.GvChanYAdapter;
import com.lingang.bean.YuanQuBean;
import com.lingang.bean.ZoneBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.utils.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
public class GrideViewPop extends PopupWindow implements AdapterView.OnItemClickListener, View.OnClickListener {
    private DialogConfirmListion listion;
    private GridView gv;
    private GvChanYAdapter gvChanYAdapter;
    private Context context;
    private List<ZoneBean.DataBean.ListBean> data;
    private Button gv_repeat;

    public GrideViewPop(Context context, DialogConfirmListion listion) {
        super(context);
        this.listion = listion;
        this.context = context;
        init();

    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.gv_pop, null);
        gv = (GridView) conentView.findViewById(R.id.gv_pop);
        gv_repeat = (Button) conentView.findViewById(R.id.gv_repeat);
        gv_repeat.setOnClickListener(this);
        conentView.findViewById(R.id.gv_conf).setOnClickListener(this);
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ScreenSizeUtils.getInstance(context).getScreenHeight() - 600);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
//        this.update();
//        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(new BitmapDrawable());
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);
    }

    public void setData(List<ZoneBean.DataBean.ListBean> list) {
        //初始化数据
        for (ZoneBean.DataBean.ListBean ListBean : list
                ) {
            ListBean.setSelect(false);
        }
        data = list;
        gvChanYAdapter = new GvChanYAdapter(context, list);
        gv.setOnItemClickListener(this);
        gv.setAdapter(gvChanYAdapter);
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        data.get(i).setSelect(!data.get(i).isSelect());
        gvChanYAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gv_repeat:
                if (gv_repeat.getText().equals("全选")) {
                    gv_repeat.setText("重置");
                    repairData(true);
                } else {
                    gv_repeat.setText("全选");
                    repairData(false);
                }

                break;
            case R.id.gv_conf:
                resolveData();
                break;
        }
    }

    private void resolveData() {
        String id = "";
        String name = "";
        for (int i = 0; i < data.size(); i++) {
            ZoneBean.DataBean.ListBean listBean = data.get(i);
            if (listBean.isSelect()) {
                if (id.equals("")){
                    id = listBean.getIndustryId() ;
                }else {
                    id = id  + "," +listBean.getIndustryId() ;
                }

                if (name.equals("")){
                    name = listBean.getIndustrySimple() ;
                }else {
                    name = name  + "," +listBean.getIndustrySimple() ;
                }
            }
        }
        listion.confirmClick(id + "|" + name);
        dismiss();
        repairData(false);
    }

    private void repairData(boolean bl) {
        for (ZoneBean.DataBean.ListBean ListBean : data
                ) {
            ListBean.setSelect(bl);
        }
        gvChanYAdapter.notifyDataSetChanged();
    }
}
