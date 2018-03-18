package com.lingang.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.lingang.R;
import com.lingang.adapter.ChanyListAdapter1;
import com.lingang.adapter.ChanyListAdapter2;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ChanYePopBean;
import com.lingang.bean.SelectChanYeBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.utils.ScreenSizeUtils;

import java.util.ArrayList;
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
public class ChanYePop extends PopupWindow implements RecycleLabAdapter.OnItemClickListener, View.OnClickListener {

    RecyclerView lv_level2;
    RecyclerView lv_level1;
    private Context context;
    private DialogConfirmListion confirmClinck;
    private ChanyListAdapter2 chanyListAdapter2;
    private ChanyListAdapter1 chanyListAdapter1;
    private List<ChanYePopBean.DataBean.ListBean> listLeft;
    private ArrayList<ChanYePopBean.DataBean.ListBean.IndustryLevelsBean> listRight;
    private int leftPosition = 0;

    public ChanYePop(Context context, DialogConfirmListion confirmClinck) {
        super(context);
        this.context = context;
        this.confirmClinck = confirmClinck;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.chanye_pop, null);

        lv_level1 = (RecyclerView) conentView.findViewById(R.id.lv_level1);
        lv_level2 = (RecyclerView) conentView.findViewById(R.id.lv_level2);
        conentView.findViewById(R.id.btn_pop_rep).setOnClickListener(this);
        conentView.findViewById(R.id.btn_pop_comit).setOnClickListener(this);
        conentView.findViewById(R.id.vv_pop).setOnClickListener(this);

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

    public void setData(ChanYePopBean zoneBean) {
        listLeft = zoneBean.getData().getList();

        if (listLeft.size() > 0) {
            resetingData();
            listRight = new ArrayList<>();
            listRight.addAll(listLeft.get(0).getIndustryLevels());

            initView();
        }
    }

    private void resetingData() {
        //初始化一级数据全部是未选中状态  除了第一条 （默认选中）
        for (int i = 0; i < listLeft.size(); i++) {
            if (i == 0) {
                listLeft.get(i).setSelect(true);
            } else {
                listLeft.get(i).setSelect(false);
            }
            listLeft.get(i).setPoint(false);//默认全部不显示黄点

            List<ChanYePopBean.DataBean.ListBean.IndustryLevelsBean> industryLevels = listLeft.get(i).getIndustryLevels();

            //二级 数据全部是未选中状态
            for (ChanYePopBean.DataBean.ListBean.IndustryLevelsBean industryLevelsBean :
                    industryLevels) {
                industryLevelsBean.setSelect(false);
            }
        }


    }

    //初始化控件
    private void initView() {
        chanyListAdapter1 = new ChanyListAdapter1(context, listLeft);
        chanyListAdapter2 = new ChanyListAdapter2(context, listRight);

        chanyListAdapter1.setOnItemClickListener(this);
        chanyListAdapter2.setOnItemClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        lv_level1.setLayoutManager(linearLayoutManager);
        lv_level2.setLayoutManager(linearLayoutManager1);

        lv_level1.setAdapter(chanyListAdapter1);
        lv_level2.setAdapter(chanyListAdapter2);
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
        int id = view.getId();

        if (id == R.id.ll_chanye1) {//left
            leftPosition = position;
            for (ChanYePopBean.DataBean.ListBean listBean :
                    listLeft) {
                listBean.setSelect(false);
            }
            listLeft.get(position).setSelect(true);
            listRight.clear();
            listRight.addAll(listLeft.get(position).getIndustryLevels());

        } else if (id == R.id.ll_chanye2) {//right
            List<ChanYePopBean.DataBean.ListBean.IndustryLevelsBean> industryLevels = listLeft.get(leftPosition).getIndustryLevels();
            industryLevels.get(position).setSelect(!industryLevels.get(position).isSelect());

            //二级菜单选中的个数
            int num = 0;
            //二级菜单是否选中
            for (ChanYePopBean.DataBean.ListBean.IndustryLevelsBean industryLevelsBean :
                    industryLevels) {
                if (industryLevelsBean.isSelect()) {
                    num++;
                }
            }

            if (num != 0) {
                listLeft.get(leftPosition).setPoint(true);
            } else {
                listLeft.get(leftPosition).setPoint(false);
            }
        }
        chanyListAdapter1.notifyDataSetChanged();
        chanyListAdapter2.notifyDataSetChanged();
    }

    public ArrayList<SelectChanYeBean> getIndex() {
        ArrayList<SelectChanYeBean> selectChanYe = new ArrayList<>();

        for (int i = 0; i < listLeft.size(); i++) {


            if (listLeft.get(i).isPoint()) {

                SelectChanYeBean selectChanYeBean = new SelectChanYeBean();
                selectChanYeBean.setLeftIndex(i);


                String rightIndex = "";

                List<ChanYePopBean.DataBean.ListBean.IndustryLevelsBean> industryLevels = listLeft.get(i).getIndustryLevels();
                for (int j = 0; j < industryLevels.size(); j++) {
                    if (industryLevels.get(j).isSelect()) {
                        if (j == 0) {
                            rightIndex = j + "";
                        } else {
                            rightIndex = j + "," + rightIndex;
                        }
                    }
                    selectChanYeBean.setRightIndex(rightIndex);
                }
                selectChanYe.add(selectChanYeBean);
            }
        }


        return selectChanYe;
    }


    public void selectIndex(ArrayList<SelectChanYeBean> index) {

        for (ChanYePopBean.DataBean.ListBean listBean :
                listLeft) {
            listBean.setPoint(false);
            listBean.setSelect(false);
        }

        for (int i = 0; i < index.size(); i++) {

            SelectChanYeBean selectChanYeBean = index.get(i);

            ChanYePopBean.DataBean.ListBean listBean = listLeft.get(selectChanYeBean.getLeftIndex());
            listBean.setPoint(true);
            if (i == index.size() - 1){
                listBean.setSelect(true);
                listRight.clear();
                listRight.addAll(listBean.getIndustryLevels());
            }

            String[] rightIndex = selectChanYeBean.getRightIndex().split(",");
            for (int j = 0; j < rightIndex.length; j++) {
                listBean.getIndustryLevels().get(Integer.valueOf(rightIndex[j])).setSelect(true);
            }

        }

        chanyListAdapter1.notifyDataSetChanged();
        chanyListAdapter2.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pop_rep:
                resetingData();
                chanyListAdapter1.notifyDataSetChanged();
                chanyListAdapter2.notifyDataSetChanged();
                break;
            case R.id.btn_pop_comit:
                resolveData();
                break;
            case R.id.vv_pop:
                dismiss();
                break;
        }
    }

    //解析数据
    private void resolveData() {
        String value = "";
        String id = "";
        for (int i = 0; i < listLeft.size(); i++) {
            if (listLeft.get(i).isPoint()) {
                if (id.equals("")) {
                    value = listLeft.get(i).getIndustryTitle();
                } else {
                    value = listLeft.get(i).getIndustryTitle() + "," + value;
                }

                List<ChanYePopBean.DataBean.ListBean.IndustryLevelsBean> industryLevels = listLeft.get(i).getIndustryLevels();
                for (ChanYePopBean.DataBean.ListBean.IndustryLevelsBean industryLevelsBean :
                        industryLevels) {
                    if (industryLevelsBean.isSelect()) {
                        if (id.equals("")) {
                            id = industryLevelsBean.getLevelId();
                        } else {
                            id = industryLevelsBean.getLevelId() + "," + id;
                        }

                    }
                }
            }

        }
        if (id.equals("") || value.equals("")) {
            confirmClinck.confirmClick("");
        } else {
            confirmClinck.confirmClick(id + "|" + value);
        }

        dismiss();
    }
}
