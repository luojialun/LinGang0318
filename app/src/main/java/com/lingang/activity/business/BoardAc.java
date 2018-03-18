package com.lingang.activity.business;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.tunity.KanBanOppoListAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.KanbanBean;
import com.lingang.bean.ParkBean;
import com.lingang.bean.ParkUserListBean;
import com.lingang.bean.PersonalKanBanBean;
import com.lingang.bean.RlTunityPopBean;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.bean.TjTunityThreeBean.DataMapBean.ParkListBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.BottomDialog2;
import com.lingang.dialog.CustomerPop2;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.ProgressWebView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.vector.update_app.utils.DrawableUtil;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class BoardAc extends BaseAc implements BottomDialog2.OnItemClickListener {

    @BindView(R.id.unit_tv)
    TextView unitTv;
    @BindView(R.id.chart_wv)
    ProgressWebView webView;
    @BindView(R.id.total_tv)
    TextView totalTv;
    @BindView(R.id.add_tv)
    TextView addTv;
    @BindView(R.id.claim_tv)
    TextView claimTv;
    @BindView(R.id.executing_tv)
    TextView executingTv;
    @BindView(R.id.success_tv)
    TextView successTv;
    @BindView(R.id.avg_time_tv)
    TextView avgTimeTv;
    @BindView(R.id.type_tv)
    TextView typeTv;
    @BindView(R.id.type_ll)
    LinearLayout typeLl;
    @BindView(R.id.arrow_iv)
    ImageView arrowIv;
    @BindView(R.id.total_content_tv)
    TextView totalContentTv;
    @BindView(R.id.add_content_tv)
    TextView addContentTv;
    @BindView(R.id.claim_content_tv)
    TextView claimContentTv;
    @BindView(R.id.executing_content_tv)
    TextView executingContentTv;
    @BindView(R.id.success_content_tv)
    TextView successContentTv;
    @BindView(R.id.avg_time_content_tv)
    TextView avgTimeContentTv;
    @BindView(R.id.error_ll)
    LinearLayout errorLl;
    @BindView(R.id.secend_iv)
    ImageView secendIv;
    @BindView(R.id.sixth_iv)
    ImageView sixthIv;

    private List<ParkUserListBean> parkUserListBeanList = new ArrayList<>(); //usertype 1 2 7的园区信息集合
    private List<ParkListBean> parkListBeanList = new ArrayList<>();  //usertype 0 3 4 5 6  的园区信息集合
    private List<String> parkNameList = new ArrayList<>();          //园区名称集合
    private String userType;

    private static final String JITUAN_KANBAN = "集团看板";
    private static final String YUANQU_KANBAN = "园区看板";
    private static final String PERSONAL_KANBAN = "个人看板";
    private String tag = "";        //标记看板类别

    private BottomDialog2 bottomDialog2;
    private CustomerPop2 customerPop2;

    private String parkId = "";
    private String parkName = "";

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ("1".equals(userType) || "2".equals(userType) || "7".equals(userType)) {
                if (parkUserListBeanList.size() > 0) {
                    parkId = parkUserListBeanList.get(0).getParkId();
                    initWebView(parkId, "");
                    getJiTuanYuanKanBanData(YUANQU_KANBAN, parkId);
                    parkName = parkUserListBeanList.get(0).getParkName();
                    typeTv.setText(parkName + "商机统计数据");
                    arrowIv.setVisibility(View.VISIBLE);
                    tag = YUANQU_KANBAN;
                } else {
                    initWebView("", LoginManager.getInstance().getUserInfo().getUserId());
                    getPersonalKanBanData();
                    typeTv.setText("个人商机统计数据");
                    arrowIv.setVisibility(View.GONE);
                    tag = PERSONAL_KANBAN;
                }
            } else if ("4".equals(userType) || "5".equals(userType) || "6".equals(userType)) {
//                parkId = parkListBeanList.get(0).getParkId();
                initWebView("", "");
                getJiTuanYuanKanBanData(JITUAN_KANBAN, "");
                typeTv.setText("集团商机统计数据");
                arrowIv.setVisibility(View.GONE);
                tag = JITUAN_KANBAN;
            } else {
                initWebView("", LoginManager.getInstance().getUserInfo().getUserId());
                getPersonalKanBanData();
                typeTv.setText("个人商机统计数据");
                arrowIv.setVisibility(View.GONE);
                tag = PERSONAL_KANBAN;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_board);
        setTitle("商机看板");
        DrawableUtil.setTextSolidTheme(unitTv, 6, 30, getResources().getColor(R.color.d8d8d8));
        userType = LoginManager.getInstance().getUserInfo().getUserType();
        initView();
        getParks();
    }

    private void initView() {
        initBottomDialog2();
        ib_right.setVisibility(View.VISIBLE);
        ib_right.setImageResource(R.mipmap.home_more);
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        bottomDialog2.show();
    }

    private void initBottomDialog2() {
        List<String> bottomList = new ArrayList<>();
        if ("0".equals(userType)||"3".equals(userType)) {
            bottomList.add(JITUAN_KANBAN);
            bottomList.add(PERSONAL_KANBAN);
        } else {
            bottomList.add(JITUAN_KANBAN);
            bottomList.add(YUANQU_KANBAN);
            bottomList.add(PERSONAL_KANBAN);
        }
        bottomDialog2 = new BottomDialog2(this, bottomList);
        bottomDialog2.setOnItemClickListener(this);
    }

    /**
     * 获取园区
     */
    public void getParks() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        if ("1".equals(userType) || "2".equals(userType) || "7".equals(userType)) {
            OkGo.post(HttpApi.getOpportunityUserParkList).params(params).tag(this).execute(new ResCallBack<RlTunityPopBean>(this) {
                @Override
                public void onCall(RlTunityPopBean responseBean, Call call, Response response) throws JSONException {
                    if (null != responseBean && null != responseBean.getDataMap()) {
                        parkUserListBeanList = responseBean.getDataMap().getParkUserList();
                        parkNameList.clear();
                        for (ParkUserListBean bean : parkUserListBeanList) {
                            parkNameList.add(bean.getParkName());
                        }
                        initPopData();
                        handler.sendEmptyMessage(0);
                    }
                }
            });
        } else {
            OkGo.post(HttpApi.getOpportunityParkList).params(params).tag(this).execute(new ResCallBack<TjTunityThreeBean>(this) {
                @Override
                public void onCall(TjTunityThreeBean responseBean, Call call, Response response) throws JSONException {
                    if (null != responseBean) {
                        parkListBeanList = responseBean.getDataMap().getParkList();
                        parkNameList.clear();
                        for (ParkListBean bean : parkListBeanList) {
                            parkNameList.add(bean.getParkName());
                        }
                        initPopData();
                        handler.sendEmptyMessage(0);
                    }
                }
            });
        }

    }

    /**
     * 初始化弹窗
     */
    public void initPopData() {
        if (null == customerPop2) {
            customerPop2 = new CustomerPop2(this, parkNameList);
        }
        customerPop2.setOnItemClickListener(new CustomerPop2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String item, int position) {
                if ("1".equals(userType) || "2".equals(userType) || "7".equals(userType)) {
                    parkId = parkUserListBeanList.get(position).getParkId();
                    parkName = parkUserListBeanList.get(position).getParkName();
                } else {
                    parkId = parkListBeanList.get(position).getParkId();
                    parkName = parkListBeanList.get(position).getParkName();
                }
                typeTv.setText(parkName + "商机统计数据");
                initWebView(parkId, "");
                getJiTuanYuanKanBanData(YUANQU_KANBAN, parkId);
                customerPop2.dismiss();
            }
        });
        customerPop2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                arrowIv.setImageResource(R.mipmap.up);
            }
        });
    }

    /**
     * 集团园区 商机看板数据
     */
    private void getJiTuanYuanKanBanData(String type, String parkId) {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        if (YUANQU_KANBAN.equals(type)) {
            params.put("parkId", parkId);
        }
        OkGo.post(HttpApi.KANBAN).params(params).execute(new ResCallBack<KanbanBean>(this) {
            @Override
            public void onCall(KanbanBean responseBean, Call call, Response response) throws JSONException {
                totalTv.setText(responseBean.getData().getTotalNum());
                addTv.setText(responseBean.getData().getRecentlyAdded());
                claimTv.setText(responseBean.getData().getClaimed());
                executingTv.setText(responseBean.getData().getExecuting());
                successTv.setText(responseBean.getData().getSuccess());
                avgTimeTv.setText(responseBean.getData().getAvgSuccessTime());

                totalContentTv.setText("全部商机(条)");
                addContentTv.setText("近期新增(条)");
                claimContentTv.setText("待认领商机(条)");
                executingContentTv.setText("执行中商机(条)");
                successContentTv.setText("已落地商机(条)");
                avgTimeContentTv.setText("平均落地时间(天)");
                secendIv.setImageResource(R.mipmap.benyuexinzeng);
                sixthIv.setImageResource(R.mipmap.zhixingshijian);
            }
        });
    }

    /**
     * 个人  商机看板数据
     */
    private void getPersonalKanBanData() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        params.put("userId", LoginManager.getInstance().getUserInfo().getUserId());
        OkGo.post(HttpApi.PERSONAL_KANBAN).params(params).tag(this).execute(new ResCallBack<PersonalKanBanBean>(this) {
            @Override
            public void onCall(PersonalKanBanBean responseBean, Call call, Response response) throws JSONException {
                totalTv.setText(responseBean.getData().getTotalNum());
                addTv.setText(responseBean.getData().getUnreview());
                claimTv.setText(responseBean.getData().getClaimed());
                executingTv.setText(responseBean.getData().getExecuting());
                successTv.setText(responseBean.getData().getSuccess());
                avgTimeTv.setText(responseBean.getData().getHaveDelete());

                totalContentTv.setText("全部商机(条)");
                addContentTv.setText("待审核商机(条)");
                claimContentTv.setText("待认领商机(条)");
                executingContentTv.setText("执行中商机(条)");
                successContentTv.setText("已落地商机(条)");
                avgTimeContentTv.setText("已撤销商机(条)");
                secendIv.setImageResource(R.mipmap.kanban_second);
                sixthIv.setImageResource(R.mipmap.kanban_sixth);
            }
        });
    }

    /**
     * 图标webview
     */
    private void initWebView(String parkId, String userId) {
        if (AppUtils.isNetworkAvailable(this)) {
            errorLl.setVisibility(View.GONE);
            final String url = HttpApi.CHART + LoginManager.getInstance().getToken() + "&parkId=" + parkId + "&userId=" + userId;

            if (url != null) {
                webView.loadUrl(url);
            }
        }
    }

    @OnClick({R.id.type_ll, R.id.all_oppo_rl, R.id.add_rl, R.id.unclaimed_rl, R.id.exec_oppo_rl, R.id.landed_oppo_rl, R.id.avg_land_oppo_rl})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.type_ll) {   //选择园区
            if (YUANQU_KANBAN.equals(tag)) {
                if (parkNameList.size() > 0) {
                    customerPop2.showPopupWindow(typeLl);
                    arrowIv.setImageResource(R.mipmap.pull);
                } else {
                    ToastUtils.showToast(this, "数据加载中，请稍候再试");
                }
            }
        }
        if (JITUAN_KANBAN.equals(tag)) {  //集团
            if ("4".equals(userType) || "5".equals(userType) || "6".equals(userType)) {
                switch (id) {
                    case R.id.all_oppo_rl:          //全部商机
                        jumToKanbanOppoList("", null, "全部商机");
                        break;
                    case R.id.add_rl:               //近期新增商机
                        jumToKanbanOppoList("1", null, "近期新增商机");
                        break;
                    case R.id.unclaimed_rl:         //待认领商机
                        jumToKanbanOppoList("2", null, "待认领商机");
                        break;
                    case R.id.exec_oppo_rl:         //执行中商机
                        jumToKanbanOppoList("3", null, "执行中商机");
                        break;
                    case R.id.landed_oppo_rl:       //已落地商机
                        jumToKanbanOppoList("4", null, "已落地商机");
                        break;

                }
            }
        }

        if (YUANQU_KANBAN.equals(tag)) { //园区
            if (!"1".equals(userType)) {
                ParkBean parkBean = new ParkBean(parkName, parkId);
                switch (id) {
                    case R.id.all_oppo_rl:          //全部商机
                        jumToKanbanOppoList("", parkBean, "全部商机");
                        break;
                    case R.id.add_rl:               //近期新增商机
                        jumToKanbanOppoList("1", parkBean, "近期新增商机");
                        break;
                    case R.id.unclaimed_rl:         //待认领商机
                        jumToKanbanOppoList("2", parkBean, "待认领商机");
                        break;
                    case R.id.exec_oppo_rl:         //执行中商机
                        jumToKanbanOppoList("3", parkBean, "执行中商机");
                        break;
                    case R.id.landed_oppo_rl:       //已落地商机
                        jumToKanbanOppoList("4", parkBean, "已落地商机");
                        break;
                }
            }
        }

        if (PERSONAL_KANBAN.equals(tag)) {  //个人
            switch (id) {
                case R.id.all_oppo_rl:          //全部商机
                    jumpToMyClaimAc("");
                    break;
                case R.id.add_rl:               //待审核商机
                    jumpToMyClaimAc("1");
                    break;
                case R.id.unclaimed_rl:         //待认领商机
                    jumpToMyClaimAc("2");
                    break;
                case R.id.exec_oppo_rl:         //执行中商机
                    jumpToMyClaimAc("3");
                    break;
                case R.id.landed_oppo_rl:       //已落地商机
                    jumpToMyClaimAc("4");
                    break;
                case R.id.avg_land_oppo_rl:    //已撤销商机
                    jumpToMyClaimAc("5");
                    break;
            }
        }

    }

    /**
     * 集团  园区  跳转到详情
     *
     * @param state
     * @param park
     */
    public void jumToKanbanOppoList(String state, ParkBean park, String title) {
        Intent intent = new Intent(this, KanBanOppoListAc.class);
        intent.putExtra(Constants.TITLE, title);
        intent.putExtra(Constants.QUERY_STATE, state);
        intent.putExtra(Constants.QUERY_PARK, park);
        startActivity(intent);
    }

    /**
     * 个人跳转 我的推荐
     *
     * @param state
     */
    public void jumpToMyClaimAc(String state) {
        Intent intent = new Intent(this, MyClaimAc.class);
        intent.putExtra(Constants.QUERY_STATE, state);
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, String item, int position) {
        switch (item) {
            case JITUAN_KANBAN:
                tag = JITUAN_KANBAN;
                typeTv.setText("集团商机统计数据");
                initWebView("", "");
                getJiTuanYuanKanBanData(JITUAN_KANBAN, "");
                arrowIv.setVisibility(View.GONE);
                break;
            case YUANQU_KANBAN:
                tag = YUANQU_KANBAN;
                if ("1".equals(userType) || "2".equals(userType) || "7".equals(userType)) {
                    if (parkUserListBeanList.size() > 0) {
                        parkId = parkUserListBeanList.get(0).getParkId();
                        parkName = parkUserListBeanList.get(0).getParkName();
                        typeTv.setText(parkName + "商机统计数据");
                    }
                } else {
                    if (parkListBeanList.size() > 0) {
                        parkId = parkListBeanList.get(0).getParkId();
                        parkName = parkListBeanList.get(0).getParkName();
                        typeTv.setText(parkName + "商机统计数据");
                    }
                }
                initWebView(parkId, "");
                getJiTuanYuanKanBanData(YUANQU_KANBAN, parkId);
                arrowIv.setVisibility(View.VISIBLE);
                break;
            case PERSONAL_KANBAN:
                tag = PERSONAL_KANBAN;
                typeTv.setText("个人商机统计数据");
                initWebView("", LoginManager.getInstance().getUserInfo().getUserId());
                getPersonalKanBanData();
                arrowIv.setVisibility(View.GONE);
                break;
        }
        if (bottomDialog2.isShowing()) {
            bottomDialog2.dismiss();
        }
    }
}
