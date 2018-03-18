package com.lingang.activity.tunity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.adapter.KanbanOppoAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.KanbanOppoBean;
import com.lingang.bean.ParkBean;
import com.lingang.bean.ParkUserListBean;
import com.lingang.bean.RlTunityPopBean;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.bean.TjTunityThreeBean.DataMapBean.ParkListBean;
import com.lingang.callback.RefreshListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.CustomerPop2;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 看板商机
 */
public class KanBanOppoListAc extends BaseRecycleViewAc implements RefreshListion, RecycleBaseAdapter.OnItemClickListener {

    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.pop_ll)
    LinearLayout popLl;
    @BindView(R.id.source_tv)
    TextView sourceTv;
    @BindView(R.id.type_tv)
    TextView typeTv;
    @BindView(R.id.num_tv)
    TextView numTv;
    @BindView(R.id.park_tv)
    TextView parkTv;

    @BindView(R.id.park_ll)
    LinearLayout parkLl;

    private Drawable drawable;
    private CustomerPop2 customerPop2;
    private int tag = Constants.PARK; // park 园区  source 来源  type 类型
    private String park = "";
    private String source = "";
    private String type = "";
    private List<String> parkList = new ArrayList<>();
    private List<String> sourceList = new ArrayList<>();
    private List<String> typeList = new ArrayList<>();

    private List<ParkBean> parkBeanList = new ArrayList<>();        //园区列表
    private List<KanbanOppoBean.KanBan> mList = new ArrayList<>(); //列表数据

    private String queryState = "";
    private ParkBean parkBean = null;
    private KanbanOppoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_kan_ban_oppo_list);
        String title = getIntent().getStringExtra(Constants.TITLE);
        if (TextUtils.isEmpty(title)) {
            setTitle("商机");
        } else {
            setTitle(title);
        }
        queryState = getIntent().getStringExtra(Constants.QUERY_STATE);
        initView();
        initPopData();
        parkBean = (ParkBean) getIntent().getSerializableExtra(Constants.QUERY_PARK);
        if (null != parkBean) {
            park = parkBean.getParkId();
            parkTv.setText(parkBean.getParkName());
            parkTv.setCompoundDrawables(null, null, null, null);
            getOppoList(1, park, "", "");
        } else {
            getOppoList(1, "", "", "");
        }
    }

    /**
     * 初始化页面
     */
    private void initView() {
        setRefreshHead(refresh);
//        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRecycleAspect(recyclerview);
        setRefreshLison(refresh, this);

        adapter = new KanbanOppoAdapter(this, mList);
        adapter.setOnItemClickListener(this);
        recyclerview.setAdapter(adapter);

        drawable = getResources().getDrawable(R.mipmap.up);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    /**
     * 初始化弹窗数据
     */
    private void initPopData() {
        if (null == parkBean) {
            getParkList();
            parkList.add("全部园区");
        }
        sourceList.add(Constants.ALL_SOURCE);
        sourceList.add(Constants.A);
        sourceList.add(Constants.B);
        sourceList.add(Constants.C);

        typeList.add(Constants.ALL_TYPE);
        typeList.add(Constants.FACTORY);
        typeList.add(Constants.OFFICE);
        typeList.add(Constants.LAND);
        typeList.add(Constants.REGISTERED_ENTERPRISE);

        if (null == customerPop2) {
            customerPop2 = new CustomerPop2(this, sourceList);
            customerPop2.setOnItemClickListener(new CustomerPop2.OnItemClickListener() {
                @Override
                public void onItemClick(View view, String item, int position) {

                    if (position == 0) {
                        if (tag == Constants.PARK) {
                            park = "";
                            parkTv.setText("全部园区");
                        } else if (tag == Constants.SOURCE) {
                            source = "";
                            sourceTv.setText("全部来源");
                        } else {
                            type = "";
                            typeTv.setText("全部类型");
                        }

                    } else {
                        if (tag == Constants.PARK) {
                            park = parkBeanList.get(position - 1).getParkId();
                            parkTv.setText(parkBeanList.get(position - 1).getParkName());
                        } else if (tag == Constants.SOURCE) {
                            switch (position) {
                                case 0:
                                    source = "";
                                    break;
                                case 1:
                                    source = "A";
                                    break;
                                case 2:
                                    source = "B";
                                    break;
                                case 3:
                                    source = "C";
                                    break;
                            }
                            sourceTv.setText(item);
                        } else {
                            type = position + "";
                            typeTv.setText(item);
                        }
                    }

                    getOppoList(1, park, source, type);
                    customerPop2.dismiss();
                }
            });

            customerPop2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    Drawable drawable = getResources().getDrawable(R.mipmap.pull);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    if (null == parkBean) {
                        parkTv.setCompoundDrawables(null, null, drawable, null);
                    }
                    sourceTv.setCompoundDrawables(null, null, drawable, null);
                    typeTv.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    /**
     * 获取弹窗数据
     */
    private void getParkList() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        String userType = LoginManager.getInstance().getUserInfo().getUserType();
        if ("1".equals(userType) || "2".equals(userType) || "7".equals(userType)) {
            OkGo.post(HttpApi.getOpportunityUserParkList).params(params).tag(this).execute(new ResCallBack<RlTunityPopBean>(this) {
                @Override
                public void onCall(RlTunityPopBean responseBean, Call call, Response response) throws JSONException {
                    if (null != responseBean && null != responseBean.getDataMap()) {
                        for (ParkUserListBean bean : responseBean.getDataMap().getParkUserList()) {
                            parkList.add(bean.getParkName());
                            parkBeanList.add(new ParkBean(bean.getParkName(), bean.getParkId()));
                        }
                        customerPop2.setData(parkList);
                    }
                }
            });
        } else {
            OkGo.post(HttpApi.getOpportunityParkList).params(params).tag(this).execute(new ResCallBack<TjTunityThreeBean>(this) {
                @Override
                public void onCall(TjTunityThreeBean responseBean, Call call, Response response) throws JSONException {
                    if (null != responseBean
                            && null != responseBean.getDataMap()
                            && null != responseBean.getDataMap().getParkList()) {
                        for (ParkListBean bean : responseBean.getDataMap().getParkList()) {
                            parkList.add(bean.getParkName());
                            parkBeanList.add(new ParkBean(bean.getParkName(), bean.getParkId()));
                        }
                        customerPop2.setData(parkList);
                    }
                }
            });
        }
    }

    @OnClick({R.id.park_ll, R.id.source_ll, R.id.type_ll})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.park_ll:
                if (null == parkBean) {
                    tag = Constants.PARK;
                    customerPop2.setData(parkList);
                    customerPop2.setSelected(parkTv.getText().toString());
                    customerPop2.showPopupWindow(popLl);
                    parkTv.setCompoundDrawables(null, null, drawable, null);
                }
                break;
            case R.id.source_ll:
                tag = Constants.SOURCE;
                customerPop2.setData(sourceList);
                customerPop2.setSelected(sourceTv.getText().toString());
                customerPop2.showPopupWindow(popLl);
                sourceTv.setCompoundDrawables(null, null, drawable, null);
                break;
            case R.id.type_ll:
                tag = Constants.TYPE;
                customerPop2.setData(typeList);
                customerPop2.setSelected(typeTv.getText().toString());
                customerPop2.showPopupWindow(popLl);
                typeTv.setCompoundDrawables(null, null, drawable, null);
                break;
        }
    }


    @Override
    public void refresh() {
        pageIndex = 1;
        getOppoList(pageIndex, park, source, type);
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getOppoList(pageIndex, park, source, type);
    }

    /**
     * 获取列表数据
     *
     * @param pageIndex        页面索引
     * @param parkId           园区ID
     * @param opportunityLevel 来源   A  B  C
     * @param opportunityType  类型
     */
    public void getOppoList(final int pageIndex, String parkId, String opportunityLevel, String opportunityType) {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        params.put("queryState", queryState);
        params.put("pageIndex", pageIndex);
        params.put("pageSize", pageSize);
        params.put("parkId", parkId);
        params.put("opportunityLevel", opportunityLevel);
        params.put("opportunityType", opportunityType);
        OkGo.post(HttpApi.KANBAN_LIST).params(params).tag(this).execute(new ResCallBack<KanbanOppoBean>(this) {
            @Override
            public void onCall(KanbanOppoBean responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    if (null != responseBean.getData()) {
                        if (pageIndex == 1) {
                            mList.clear();
                        }
                        String countRecord = responseBean.getData().getCountRecord() + "";
                        Spannable span = new SpannableString("共有" + countRecord + "条查询结果");
                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, countRecord.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        numTv.setText(span);
                        if (null != responseBean.getData().getList()) {
                            mList.addAll(responseBean.getData().getList());
                            adapter.notifyDataSetChanged();
                            if (mList.size() > 0) {
                                numTv.setVisibility(View.VISIBLE);
                            } else {
                                numTv.setVisibility(View.GONE);

                            }
                        }
                        isRefresh(countRecord, pageIndex + "", pageSize + "");
                    }
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                ToastUtils.showToast(KanBanOppoListAc.this, "无权查看列表信息");
            }
        });
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        if (mList != null && mList.size() > position) {
            if ("4".equals(queryState) || (TextUtils.isEmpty(queryState) && "4".equals(mList.get(position).getShowState()))) {
                Intent intent = new Intent(this, OppExamineDetailsAc.class);
                intent.putExtra(Constants.DETAILS_TYPE, Constants.RECOMMEND_DETAILS);
                intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                intent.putExtra(Constants.OPP_SHOW_STATE, queryState);
                intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExamine);
                intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
                intent.putExtra(Constants.OPP_DETAILS_ID, mList.get(position).getKeyId());//商机详情ID
                intent.putExtra(Constants.OPP_LAND_TYPE, new Constants.ParamLandType(mList.get(position).getHaveWorkshop(),
                        mList.get(position).getHaveOffice(),
                        mList.get(position).getHaveLand(),
                        mList.get(position).getHaveEnterpriseType()));//需求类型(厂房,研发办公,土地,注册型企业)
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, OpportunityDetailsAc.class);
                intent.putExtra(Constants.OPP_DETAILS_ID, mList.get(position).getKeyId());//商机详情ID
                intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, mList.get(position).getShowState());//状态类型
                intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.KanbanOppo);//页面类型(推荐商机，我的审核，我的执行)
                intent.putExtra(Constants.OPP_LAND_TYPE, new Constants.ParamLandType(mList.get(position).getHaveWorkshop(),
                        mList.get(position).getHaveOffice(),
                        mList.get(position).getHaveLand(),
                        mList.get(position).getHaveEnterpriseType()));//需求类型(厂房,研发办公,土地,注册型企业)
                startActivity(intent);
            }
        }
    }
}
