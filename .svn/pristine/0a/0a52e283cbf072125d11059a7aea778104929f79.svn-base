package com.lingang.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lingang.R;
import com.lingang.adapter.PopChanYeAdapter;
import com.lingang.adapter.PopZoneAdapter;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AdressBean;
import com.lingang.bean.AllAdressBean;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class TwoLevelPop extends PopupWindow implements RecycleBaseAdapter.OnItemClickListener {

    RecyclerView lvRepeat;
    RecyclerView lvConf;
    private PopZoneAdapter popZoneAdapter;
    private PopChanYeAdapter popChanYeAdapter;
    private Context context;
    private ArrayList<AllAdressBean> allAdress;
    private int leftPosition = 0;//记录左边list选中的下标
    private ArrayList<AdressBean> adressBeen;
    private PopConfirmClinck confirmClinck;
    private String[] all;
    private String[] index;


    public TwoLevelPop(Context context, PopConfirmClinck confirmClinck) {
        super(context);
        this.context = context;
        this.confirmClinck = confirmClinck;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.two_level_pop, null);

        lvConf = (RecyclerView) conentView.findViewById(R.id.lv_conf);
        lvRepeat = (RecyclerView) conentView.findViewById(R.id.lv_repeat);
        conentView.findViewById(R.id.vv_pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
//        conentView.findViewById(R.id.btn_repeat).setOnClickListener(this);
//        conentView.findViewById(R.id.btn_conf).setOnClickListener(this);

        // 设置的View
        this.setContentView(conentView);
        // 设置弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体的高   ScreenSizeUtils.getInstance(context).getScreenHeight() - 600
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

    public void setData(String data) throws JSONException {
        all = new String[]{"-1", "-2", "-3"};
        allAdress = paseData(data);
        //第一级  第一个状态设置为选中状态
        allAdress.get(0).setIsselect(true);

        adressBeen = new ArrayList<>();
        adressBeen.addAll(allAdress.get(0).getList());

        popZoneAdapter = new PopZoneAdapter(context, allAdress);
        popChanYeAdapter = new PopChanYeAdapter(context, adressBeen);

        popChanYeAdapter.setOnItemClickListener(this);
        popZoneAdapter.setOnItemClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        lvConf.setLayoutManager(linearLayoutManager);
        lvRepeat.setLayoutManager(linearLayoutManager1);

        lvConf.setAdapter(popChanYeAdapter);
        lvRepeat.setAdapter(popZoneAdapter);
    }

    private ArrayList<AllAdressBean> paseData(String data) throws JSONException {
        Gson gson = new Gson();
        ArrayList<AllAdressBean> allAdressData = new ArrayList<>();
        String dataMap = new JSONObject(data).getString("dataMap");
        JsonObject jsonObject = new JsonParser().parse(dataMap).getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();

        int index = 0;
        //遍历属性
        for (Map.Entry<String, JsonElement> type : entrySet) {

            JsonArray objArray = jsonObject.getAsJsonArray(type.getKey());

            List<AdressBean> areaRegion = new ArrayList<>();
            //手动添加全部数据
            AdressBean adressBean = new AdressBean();
            adressBean.setRegionName("全部");
            adressBean.setRegionId(all[index]);
            index++;
            adressBean.setIsselect(true);
            areaRegion.add(adressBean);


            for (int i = 0; i < objArray.size(); i++) {
                //获取第i个数组元素
                JsonElement el = objArray.get(i);
                //映射为类实例
                AdressBean entity = gson.fromJson(el, AdressBean.class);
                entity.setIsselect(false);
                areaRegion.add(entity);
            }

            //创建对象
            AllAdressBean father = new AllAdressBean();
            father.setName(type.getKey());
            father.setIsselect(false);//默认全是未选中状态
            father.setList(areaRegion);
            allAdressData.add(father);
        }

        return allAdressData;
    }

    public int[] getIndex() {
        int[] index = new int[]{0, 0};

        if (allAdress != null) {

            for (int i = 0; i < allAdress.size(); i++) {

                if (allAdress.get(i).isselect()) index[0] = i;

                List<AdressBean> list = allAdress.get(i).getList();

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).isselect()) index[1] = j;
                }


            }
        }
        return index;
    }

    public void selectIndex(int[] index) {
        for (int i = 0; i < allAdress.size(); i++) {

            AllAdressBean allAdressBean = allAdress.get(i);
            List<AdressBean> list = allAdressBean.getList();

            if (i == index[0]) {
                allAdressBean.setIsselect(true);
                for (int j = 0; j < list.size(); j++) {
                    AdressBean adressBean = list.get(j);
                    if (j == index[1]){
                        adressBean.setIsselect(true);
                    }else {
                        adressBean.setIsselect(false);
                    }
                }
                adressBeen.clear();
                adressBeen.addAll(list);
            } else {
                allAdressBean.setIsselect(false);
                for (int j = 0; j < list.size(); j++) {
                    AdressBean adressBean = list.get(j);
                    adressBean.setIsselect(false);

                }
            }

        }

        popChanYeAdapter.notifyDataSetChanged();
        popZoneAdapter.notifyDataSetChanged();
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
        if (id == R.id.pop_zone) {//left
            leftPosition = position;

            for (AllAdressBean allAdressBean : allAdress) {
                allAdressBean.setIsselect(false);
            }
            allAdress.get(position).setIsselect(true);

            adressBeen.clear();
            adressBeen.addAll(allAdress.get(position).getList());

            popChanYeAdapter.notifyDataSetChanged();
            popZoneAdapter.notifyDataSetChanged();

        } else if (id == R.id.pop_chanye) {//right
            //重置初始状态
            for (int i = 0; i < allAdress.size(); i++) {
                List<AdressBean> list = allAdress.get(i).getList();
                for (int j = 0; j < list.size(); j++) {
                    list.get(j).setIsselect(false);
                }
            }
            //改变选中状态
            allAdress.get(leftPosition).getList().get(position).setIsselect(true);
            confirmClinck.popConfirmClinck("text", allAdress.get(leftPosition).getList().get(position).getRegionName());
            confirmClinck.popConfirmClinck("id", allAdress.get(leftPosition).getList().get(position).getRegionId());
            popChanYeAdapter.notifyDataSetChanged();
            dismiss();
        }
    }
}
