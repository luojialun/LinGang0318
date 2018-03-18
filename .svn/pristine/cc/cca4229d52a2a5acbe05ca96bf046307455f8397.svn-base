package com.lingang.activity.business;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.lingang.activity.tunity.OppExamineDetailsAc;
import com.lingang.adapter.MyClaimAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.RecommandBean;
import com.lingang.bean.ShowStateEnum;
import com.lingang.callback.RefreshListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.CustomerPop2;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 我的推荐
 */
public class MyClaimAc extends BaseRecycleViewAc implements RecycleBaseAdapter.OnItemClickListener, RefreshListion {

    @BindView(R.id.pop_ll)
    LinearLayout popLl;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_news)
    TextView tvNews;
    @BindView(R.id.ll_all)
    LinearLayout llAll;
    @BindView(R.id.ll_type)
    LinearLayout llType;
    @BindView(R.id.tv_type)
    TextView tvType;

    private MyClaimAdapter claimAdapter;
    private CustomerPop2 customerPop2;
    private List<String> stateList = new ArrayList<>();
    private List<String> typeList = new ArrayList<>();
    private int tag = Constants.STATE; // state 状态  type 类型
    private String state = ""; // 状态
    private String type = "";  // 类型
    private List<RecommandBean.Recommand> mList = new ArrayList<>();
    private Drawable drawable;

    private String queryState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_my_claim);
        ButterKnife.bind(this);
        setTitle("我的推荐");
        initPopData();
        initView();
        queryState = getIntent().getStringExtra(Constants.QUERY_STATE);
        if (!TextUtils.isEmpty(queryState)) {
            state = queryState;
        }
        if (TextUtils.isEmpty(queryState)) {
            getRecommand(1, "", "");
        } else {
            setTitle("商机看板");
            getRecommand(1, queryState, "");
            tvAll.setText(Constants.recShowState.get(Integer.parseInt(queryState)).getState());
            tvAll.setCompoundDrawables(null, null, null, null);
        }
    }

    /**
     * 初始化弹窗数据
     */
    private void initPopData() {
        stateList.add(Constants.ALL_STATE);
        for (int i = 1; i <= 4; i++) {
            stateList.add(Constants.recShowState.get(i).getState());
        }
        stateList.add(Constants.OppState.Returned);
        stateList.add(Constants.OppState.Revoked);

        typeList.add(Constants.ALL_TYPE);
        typeList.add(Constants.FACTORY);
        typeList.add(Constants.OFFICE);
        typeList.add(Constants.LAND);
        typeList.add(Constants.REGISTERED_ENTERPRISE);

        if (null == customerPop2) {
            customerPop2 = new CustomerPop2(this, stateList);
            customerPop2.setOnItemClickListener(new CustomerPop2.OnItemClickListener() {
                @Override
                public void onItemClick(View view, String item, int position) {
                    if (tag == Constants.STATE) {
                        state = getMapKey(Constants.recShowState, item);
                        tvAll.setText(item);
                    } else {
                        type = position + "";
                        tvType.setText(item);
                    }

                    if (position == 0) {
                        if (tag == Constants.STATE) {
                            state = "";
                        } else {
                            type = "";
                        }
                    }

                    getRecommand(pageIndex, state, type);
                    customerPop2.dismiss();
                }
            });
            customerPop2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    Drawable drawable = getResources().getDrawable(R.mipmap.pull);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tvAll.setCompoundDrawables(null, null, drawable, null);
                    tvType.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    /**
     * 通过遍历map取key值
     *
     * @param recShowState
     * @param value
     * @return
     */
    public String getMapKey(Map<Integer, ShowStateEnum> recShowState, String value) {
        Set<Integer> kset = recShowState.keySet();
        for (Integer ks : kset) {
            if (value.equals(recShowState.get(ks).getState())) {
                return ks + "";
            }
        }
        return "";
    }

    private void initView() {
        setRefreshHead(refresh);
//        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRecycleAspect(recyclerview);
        setRefreshLison(refresh, this);

        claimAdapter = new MyClaimAdapter(this, mList);
        claimAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(claimAdapter);

        drawable = getResources().getDrawable(R.mipmap.up);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    @OnClick({R.id.ll_all, R.id.ll_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_all:
                if (TextUtils.isEmpty(queryState)) {
                    tag = Constants.STATE;
                    customerPop2.setData(stateList);
                    customerPop2.setSelected(tvAll.getText().toString());
                    customerPop2.showPopupWindow(popLl);

                    tvAll.setCompoundDrawables(null, null, drawable, null);
                }
                break;
            case R.id.ll_type:
                tag = Constants.TYPE;
                customerPop2.setData(typeList);
                customerPop2.setSelected(tvType.getText().toString());
                customerPop2.showPopupWindow(popLl);
                if (TextUtils.isEmpty(queryState)) {
                    tvType.setCompoundDrawables(null, null, drawable, null);
                }
                break;
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        if (mList != null && mList.size() > position) {
            if ("4".equals(mList.get(position).getShowState())) {
                Intent intent = new Intent(this, OppExamineDetailsAc.class);
                intent.putExtra(Constants.DETAILS_TYPE,Constants.RECOMMEND_DETAILS);
                intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                intent.putExtra(Constants.OPP_SHOW_STATE,mList.get(position).getShowState());
                intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyClaimAc);
                intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
                intent.putExtra(Constants.OPP_DETAILS_ID, mList.get(position).getKeyId());//商机详情ID
                intent.putExtra(Constants.OPP_LAND_TYPE, new Constants.ParamLandType(mList.get(position).getHaveWorkshop(),
                        mList.get(position).getHaveOffice(),
                        mList.get(position).getHaveLand(),
                        mList.get(position).getHaveEnterpriseType()));//需求类型(厂房,研发办公,土地,注册型企业)
                startActivity(intent);
            } else {
                OpportunityDetailsAc.gotoOpportunityDetailsAc(MyClaimAc.this,
                        mList.get(position).getKeyId(),
                        mList.get(position).getShowState(),
                        Constants.OppPageStateType.MyClaimAc,
                        new Constants.ParamLandType(mList.get(position).getHaveWorkshop(),
                                mList.get(position).getHaveOffice(),
                                mList.get(position).getHaveLand(),
                                mList.get(position).getHaveEnterpriseType()));
            }
        }
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getRecommand(pageIndex, state + "", type + "");
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getRecommand(pageIndex, state + "", type + "");
    }

    /**
     * 获取推荐
     *
     * @param page
     * @param queryState
     * @param opportunityType
     */
    public void getRecommand(int page, String queryState, String opportunityType) {
        HttpParams params = new HttpParams();
        params.put("pageIndex", page);
        params.put("pageSize", pageSize);
        params.put("queryState", queryState);
        params.put("opportunityType", opportunityType);
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.MY_RECOMMAND).params(params).tag(this).execute(new ResCallBack<RecommandBean>(this) {
            @Override
            public void onCall(RecommandBean responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    if (null != responseBean.getData()) {
                        if (1 == pageIndex) {
                            mList.clear();
                        }
                        String countRecord = responseBean.getData().getCountRecord() + "";
                        Spannable span = new SpannableString("共有" + countRecord + "条查询结果");
                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, countRecord.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNews.setText(span);
                        if (null != responseBean.getData().getList()) {
                            mList.addAll(responseBean.getData().getList());
                            if(mList.size()>0){
                                tvNews.setVisibility(View.VISIBLE);
                            }else{
                                tvNews.setVisibility(View.GONE);
                            }
                            claimAdapter.notifyDataSetChanged();
                        }
                        isRefresh(countRecord, pageIndex + "", pageSize + "");
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case Constants.refreshCode:
                getRecommand(1, state + "", type + "");
                break;

        }
    }
}
