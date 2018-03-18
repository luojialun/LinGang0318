package com.lingang.activity.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.OnDismissListener;
import com.google.gson.Gson;
import com.lingang.R;
import com.lingang.adapter.WeekVpAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.GetUserInfoBean;
import com.lingang.bean.GroupbyUserBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.other.WeekFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class WeekAc extends BaseAc implements RadioGroup.OnCheckedChangeListener, OnDismissListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.left_btn)
    ImageView leftBtn;
    @BindView(R.id.title_rbleft)
    RadioButton titleRbleft;
    @BindView(R.id.title_rbright)
    RadioButton titleRbright;
    @BindView(R.id.title_rg)
    RadioGroup titleRg;
    @BindView(R.id.tb_week)
    TabLayout tbWeek;
    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.tv_tag_week)
    TextView tvTagWeek;
    private OptionsPickerView pickerView;
    private ArrayList<String> weekList;
    private SimpleDateFormat sdf; //设置时间格式
    private ArrayList<String> tabData;
    private ArrayList<Fragment> fragments;
    private GetUserInfoBean userInfo;
    private String groupCD = "";
    private WeekVpAdapter weekVpAdapter;
    private ArrayList<Integer> integers, integers2;
    private WeekFragment fragment;
    private Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        ButterKnife.bind(this);
        scollCloseAc();
        init();
        getUserInfo();
    }

    private void init() {
        titleRbleft.setText("组织日程");
        titleRbright.setText("个人日程");
        titleRg.check(R.id.title_rbleft);
        titleRg.setOnCheckedChangeListener(this);
    }

    //获取日期数据
    private void getData() {
        weekList = new ArrayList<>();
        if (integers == null) {
            integers = new ArrayList<>();
        }

        integers.add(-2);
        integers.add(-1);
        integers.add(0);
        integers.add(1);
        integers.add(2);

        sdf = new SimpleDateFormat("yyyy年MM月dd日"); //设置时间格式
        for (int i = 0; i < 5; i++) {//1);//上周 2);//上上周 0);//当前周 -1);//下周 -2);//下下周
            weekList.add(getLastTimeInterval(integers.get(i)));
        }
        Collections.reverse(weekList);//倒序
        initLvView();
    }


    //获取用户信息
    private void getUserInfo() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("Userid", LoginManager.getInstance().getUserInfo().getUserAccount());//
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GetUserInfo)
                .params(httpParams)
                .tag(WeekAc.this)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<String, Object> addressBean, Call call, Response response) throws JSONException {
                        String result = addressBean.getData();
                        Gson gson = new Gson();
                        userInfo = gson.fromJson(result.replaceAll("\\\\", ""), GetUserInfoBean.class);
                        if (userInfo != null && userInfo.getData().size() != 0) {
                            tvTagWeek.setText(userInfo.getData().get(0).getLabourRelationName());
                            groupCD = userInfo.getData().get(0).getLabourRelationCD();
                            groupbyUser();
                        }

                    }
                });

    }

    //获取常用组织
    private void groupbyUser() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("useraccount", LoginManager.getInstance().getUserInfo().getUserAccount());//huangshuai
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GroupbyUser)
                .params(httpParams)
                .tag(WeekAc.this)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<String, Object> addressBean, Call call, Response response) throws JSONException {
                        String result = addressBean.getData();
                        Gson gson = new Gson();
                        GroupbyUserBean Group = gson.fromJson(result.replaceAll("\\\\", ""), GroupbyUserBean.class);
                        List<GroupbyUserBean.DataBean> data = Group.getData();
                        GroupbyUserBean.DataBean dataBean = new GroupbyUserBean.DataBean();
                        dataBean.setGroupName(userInfo.getData().get(0).getLabourRelationName());
                        dataBean.setGroupCD(userInfo.getData().get(0).getLabourRelationCD());
                        data.add(0, dataBean);
                        getData();
                        initPv(data);
                    }
                });

    }

    private void initPv(final List<GroupbyUserBean.DataBean> data) {
        final ArrayList<String> strings = new ArrayList<>();
        for (GroupbyUserBean.DataBean dataBean :
                data) {
            strings.add(dataBean.getGroupName());
        }
        pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = strings.get(options1);
                groupCD = data.get(options1).getGroupCD();
                tvTagWeek.setText(tx);
                initLvView();
            }
        }).setTextColorCenter(getResources().getColor(R.color.black))
                .setTextColorOut(getResources().getColor(R.color.grenn))
                .setContentTextSize(16)//滚轮文字大小
                .setSubCalSize(16)
                .setSubmitColor(getResources().getColor(R.color.black))//确定按钮文字颜色
                .setCancelColor(getResources().getColor(R.color.black))//取消按钮文字颜色
                .setSubmitText("确定")//确定按钮文字
                .setCancelText("取消")//取消按钮文字
                .build();
        pickerView.setPicker(strings);
        pickerView.setOnDismissListener(this);
    }

    private void initLvView() {

        addData();
        weekVpAdapter = new WeekVpAdapter(getSupportFragmentManager(), tabData, fragments);
        vpPager.setAdapter(weekVpAdapter);
        //将tabLayout与viewpager连起来
        tbWeek.setupWithViewPager(vpPager);
        vpPager.setCurrentItem(weekList.size() % 3);
        vpPager.setOnPageChangeListener(this);
    }

    private void addData() {
        if (tabData == null)
            tabData = new ArrayList<>();
        if (fragments == null)
            fragments = new ArrayList<>();


        tabData.clear();
        fragments.clear();
        c = Calendar.getInstance();


        for (int i = 0; i < weekList.size(); i++) {
            String string = weekList.get(i);
            Log.e("data", string);
            tabData.add(string.replace(c.get(Calendar.YEAR) + "年", ""));//拆分日期的年份
            WeekFragment weekFragment = new WeekFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("num", i);
            bundle.putString("time", string);
            bundle.putString("GroupCD", groupCD);
            weekFragment.setArguments(bundle);
            fragments.add(weekFragment);
        }
        Log.e("data", "=======================");
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
                tvTagWeek.setCompoundDrawables(null, null, nav_up, null);
                if (pickerView != null)
                    pickerView.show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.title_rbleft:
                changeSign(View.VISIBLE, "left");
                break;
            case R.id.title_rbright:
                changeSign(View.GONE, "right");
                break;
        }
    }

    //改变sign状态
    private void changeSign(int gone, String right) {
        llTag.setVisibility(gone);
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments
                    ) {
                ((WeekFragment) fragment).tabOnclick(right, groupCD);
            }
        }
    }

    @Override
    public void onDismiss(Object o) {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvTagWeek.setCompoundDrawables(null, null, nav_up, null);
    }

    /**
     * 根据当前日期获得上周的日期区间（上周周一和周日日期）
     *
     * @return
     * @author zhaoxuepu
     */
    public String getLastTimeInterval(int offset) {
        int i = 7 * offset;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - i);
        calendar2.add(Calendar.DATE, offset2 - i);
//        System.out.println("last Monday" + sdf.format(calendar1.getTime()));// last Monday
        String lastBeginDate = sdf.format(calendar1.getTime());
//        System.out.println("last Sunday" + sdf.format(calendar2.getTime()));// last Sunday
        String lastEndDate = sdf.format(calendar2.getTime());
        return lastBeginDate + "-" + lastEndDate;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (integers2 == null) {
            integers2 = new ArrayList<>();
        }

        int newTime = Math.abs(integers.get(position) - integers.get(2));//获取选择完后 周期最大的数


        integers2.clear();
        weekList.clear();

        for (int i = 0; i < 5; i++) {
            integers2.add(integers.get(i) - newTime);
            weekList.add(getLastTimeInterval(integers2.get(i)));
            Log.e("data", weekList.get(i));
            Log.e("data", integers.get(i)+"");
            Log.e("data", integers2.get(i)+"");
        }

        integers.clear();
        for (int i = 0; i <integers2.size() ; i++) {
            integers.add(integers2.get(i));
        }
        Log.e("data", "=======================");
        weekVpAdapter.notifyDataSetChanged();
//        vpPager.setCurrentItem(2);

//        fragment = (WeekFragment) weekVpAdapter.getItem(2);
//        fragment.refresh();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
