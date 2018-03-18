package com.lingang.activity.tunity.execute;

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
import com.lingang.activity.MainActivity;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.activity.tunity.OppExamineDetailsAc;
import com.lingang.activity.tunity.RlTunityAc;
import com.lingang.adapter.MyExecuteAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.MyExecuteBean;
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

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;


/**
 * Created by jason on 17/8/17.
 * 我的执行
 */
public class MyExecute extends BaseRecycleViewAc implements RecycleBaseAdapter.OnItemClickListener, RefreshListion {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.pop_ll)
    LinearLayout popLl;
    @BindView(R.id.state_tv)
    TextView stateTv;
    @BindView(R.id.type_tv)
    TextView typeTv;
    @BindView(R.id.source_tv)
    TextView sourceTv;
    @BindView(R.id.tv_news)
    TextView tvNews;

    private MyExecuteAdapter executeAdapter;
    private CustomerPop2 customerPop2;
    private List<String> stateList = new ArrayList<>();
    private List<String> typeList = new ArrayList<>();
    private List<String> sourceList = new ArrayList<>();
    private int tag = Constants.STATE; // state 状态  type 类型  source 来源
    private String state = "1"; // 状态
    private String type = "";  // 类型
    private String source = "";  // 来源
    private List<MyExecuteBean.Execute> mList = new ArrayList<>();
    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_my_execute);
        setTitle(getString(R.string.my_execute));
        initView();
        initPopData();
        getMyExecuteData(pageIndex, "1", "", "");
    }

    @Override
    public void clickLeft() {
        String tag = getIntent().getStringExtra("tag");
        if (!TextUtils.isEmpty(tag) && tag.equals("商机转移")) {
            startActivity(new Intent(this, MainActivity.class));
        }  else {
            super.clickLeft();
        }
    }


    private void initView() {
        setRefreshHead(refresh);
//        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRecycleAspect(recyclerview);
        setRefreshLison(refresh, this);

        executeAdapter = new MyExecuteAdapter(this, mList);
        executeAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(executeAdapter);

        drawable = getResources().getDrawable(R.mipmap.up);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    /**
     * 初始化弹窗数据
     */
    private void initPopData() {
        for (int i = 1; i <= Constants.executeShowState.size(); i++) {
            stateList.add(Constants.executeShowState.get(i).getState());
        }
        typeList.add(Constants.ALL_TYPE);
        typeList.add(Constants.FACTORY);
        typeList.add(Constants.OFFICE);
        typeList.add(Constants.LAND);
        typeList.add(Constants.REGISTERED_ENTERPRISE);

        sourceList.add(Constants.ALL_SOURCE);
        sourceList.add(Constants.A);
        sourceList.add(Constants.B);
        sourceList.add(Constants.C);

        if (null == customerPop2) {
            customerPop2 = new CustomerPop2(this, stateList);
            customerPop2.setOnItemClickListener(new CustomerPop2.OnItemClickListener() {
                @Override
                public void onItemClick(View view, String item, int position) {
                    if (tag == Constants.STATE) {
                        state = (position + 1) + "";
                        stateTv.setText(item);
                    } else if (tag == Constants.TYPE) {
                        type = position + "";
                        typeTv.setText(item);
                    } else {
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
                    }

                    if (position == 0) {
                        if (tag == Constants.STATE) {
                            state = "1";
                        } else if (tag == Constants.TYPE) {
                            type = "";
                        }
                    }
                    executeAdapter.setShowState(state);
                    getMyExecuteData(1, state, type, source);
                    customerPop2.dismiss();
                }
            });

            customerPop2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    Drawable drawable = getResources().getDrawable(R.mipmap.pull);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    stateTv.setCompoundDrawables(null, null, drawable, null);
                    typeTv.setCompoundDrawables(null, null, drawable, null);
                    sourceTv.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @OnClick({R.id.state_ll, R.id.type_ll, R.id.source_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.state_ll:
                tag = Constants.STATE;
                customerPop2.setData(stateList);
                customerPop2.setSelected(stateTv.getText().toString());
                customerPop2.showPopupWindow(popLl);

                stateTv.setCompoundDrawables(null, null, drawable, null);
                break;
            case R.id.type_ll:
                tag = Constants.TYPE;
                customerPop2.setData(typeList);
                customerPop2.setSelected(typeTv.getText().toString());
                customerPop2.showPopupWindow(popLl);

                typeTv.setCompoundDrawables(null, null, drawable, null);
                break;
            case R.id.source_ll:
                tag = Constants.SOURCE;
                customerPop2.setData(sourceList);
                customerPop2.setSelected(sourceTv.getText().toString());
                customerPop2.showPopupWindow(popLl);

                sourceTv.setCompoundDrawables(null, null, drawable, null);
                break;
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        if (mList != null && mList.size() > position) {
            Intent intent = null;
            if ("6".equals(state)) {  //已落地
                intent = new Intent(this, OppExamineDetailsAc.class);
                intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                intent.putExtra(Constants.OPP_SHOW_STATE, state);
                intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExecute);
                intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
            } else {                //其他
                intent = new Intent(this, OpportunityDetailsAc.class);
                intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, state);//状态类型
                intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExecute);//页面类型(推荐商机，我的审核，我的执行)
            }
            intent.putExtra(Constants.OPP_DETAILS_ID, mList.get(position).getKeyId());//商机详情ID
            intent.putExtra(Constants.OPP_LAND_TYPE, new Constants.ParamLandType(mList.get(position).getHaveWorkshop(),
                    mList.get(position).getHaveOffice(),
                    mList.get(position).getHaveLand(),
                    mList.get(position).getHaveEnterpriseType()));//需求类型(厂房,研发办公,土地,注册型企业)
            startActivityForResult(intent, Constants.refreshCode);
        }
    }


    @Override
    public void refresh() {
        pageIndex = 1;
        getMyExecuteData(pageIndex, state, type, source);
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getMyExecuteData(pageIndex, state, type, source);
    }

    /**
     * 获取执行数据
     *
     * @param pageIndex
     * @param queryState
     * @param opportunityType
     * @param opportunityLevel
     */
    public void getMyExecuteData(final int pageIndex, String queryState, String opportunityType, String opportunityLevel) {
        HttpParams params = new HttpParams();
        params.put("pageIndex", pageIndex);
        params.put("pageSize", pageSize);
        params.put("queryState", queryState);
        params.put("opportunityType", opportunityType);
        params.put("opportunityLevel", opportunityLevel);
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.MY_EXECUTE).params(params).tag(this).execute(new ResCallBack<MyExecuteBean>(this) {
            @Override
            public void onCall(MyExecuteBean responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    if (null != responseBean.getData()) {
                        if (pageIndex == 1) {
                            mList.clear();
                        }
                        String countRecord = responseBean.getData().getCountRecord() + "";
                        Spannable span = new SpannableString("共有" + countRecord + "条查询结果");
                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, countRecord.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNews.setText(span);
                        if (null != responseBean.getData().getList()) {
                            mList.addAll(responseBean.getData().getList());
                            if (mList.size() > 0) {
                                tvNews.setVisibility(View.VISIBLE);
                            } else {
                                tvNews.setVisibility(View.GONE);
                            }
                            executeAdapter.notifyDataSetChanged();
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
        if (resultCode == Constants.refreshCode) {
            refresh();
        }
    }

}
