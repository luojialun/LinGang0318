package com.lingang.activity.tunity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.adapter.MyExamineAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.MyExamineBean;
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
 * 我的审核
 */
public class MyExamineAc extends BaseRecycleViewAc implements RecycleBaseAdapter.OnItemClickListener, RefreshListion {

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
    @BindView(R.id.tv_type)
    TextView tvType;

    private MyExamineAdapter examineAdapter;
    private CustomerPop2 customerPop2;
    private List<String> stateList = new ArrayList<>();
    private List<String> typeList = new ArrayList<>();
    private int tag = Constants.STATE; // state 状态  type 类型
    private String state = "1"; // 状态
    private String type = "";  // 类型
    private List<MyExamineBean.Examine> mList = new ArrayList<>();
    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_my_examine);
        setTitle("我的审核");
        initPopData();
        initView();
        getMyExamine(pageIndex, "1", "");
    }

    /**
     * 初始化弹窗数据
     */
    private void initPopData() {
        for (int i = 1; i <= Constants.exaShowState.size(); i++) {
            stateList.add(Constants.exaShowState.get(i).getState());
        }
        typeList.add(Constants.ALL_TYPE);
        typeList.add(Constants.RECOMMAND_EXAMINE);
        typeList.add(Constants.LAND_EXAMINE);

        if (null == customerPop2) {
            customerPop2 = new CustomerPop2(this, stateList);
            customerPop2.setOnItemClickListener(new CustomerPop2.OnItemClickListener() {
                @Override
                public void onItemClick(View view, String item, int position) {
                    if (tag == Constants.STATE) {
                        state = (position + 1) + "";
                        tvAll.setText(item);
                    } else if (tag == Constants.TYPE) {
                        type = position + "";
                        tvType.setText(item);
                    }

                    if (position == 0) {
                        if (tag == Constants.STATE) {
                            state = "1";
                        } else {
                            type = "";
                        }
                    }
                    examineAdapter.setState(state);
                    getMyExamine(pageIndex, state, type);

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

    private void initView() {
        setRefreshHead(refresh);
        setRefreshViewLine(recyclerview, R.drawable.review_item_divider);
        setRecycleAspect(recyclerview);
        setRefreshLison(refresh, this);

        examineAdapter = new MyExamineAdapter(this, mList);
        examineAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(examineAdapter);

        drawable = getResources().getDrawable(R.mipmap.up);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }


    @OnClick({R.id.ll_all, R.id.ll_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_all:
                tag = Constants.STATE;
                customerPop2.setData(stateList);
                customerPop2.setSelected(tvAll.getText().toString());
                customerPop2.showPopupWindow(popLl);

                tvAll.setCompoundDrawables(null, null, drawable, null);
                break;
            case R.id.ll_type:
                tag = Constants.TYPE;
                customerPop2.setData(typeList);
                customerPop2.setSelected(tvType.getText().toString());
                customerPop2.showPopupWindow(popLl);

                tvType.setCompoundDrawables(null, null, drawable, null);
                break;
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        if (mList != null && mList.size() > position) {
            Intent intent = new Intent(this, OppExamineDetailsAc.class);
//            intent.putExtra(Constants.DETAILS_TYPE, Constants.EXAMINE_DETAILS);
            intent.putExtra(Constants.OPP_DETAILS_ID, mList.get(position).getKeyId());//商机详情ID
            intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, state);//1 待审核    2 已审核
            intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExamine);
            if ("1".equals(mList.get(position).getShowState())) {
                intent.putExtra(Constants.ALL_TYPE, "1");    //1 推荐审核
            } else {
                intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
            }
            intent.putExtra(Constants.OPP_LAND_TYPE, new Constants.ParamLandType(mList.get(position).getHaveWorkshop(),
                    mList.get(position).getHaveOffice(),
                    mList.get(position).getHaveLand(),
                    mList.get(position).getHaveEnterpriseType()));//需求类型(厂房,研发办公,土地,注册型企业)
            startActivityForResult(intent, Constants.OppDetailRefreshType.RequestCode);
        }
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getMyExamine(pageIndex, state, type);
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getMyExamine(pageIndex, state, type);
    }

    /**
     * 获取我的审核数据
     *
     * @param pageIndex
     * @param audited
     * @param queryState
     */
    private void getMyExamine(final int pageIndex, String audited, String queryState) {
        HttpParams params = new HttpParams();
        params.put("pageIndex", pageIndex);
        params.put("pageSize", pageSize);
        params.put("audited", audited);
        params.put("queryState", queryState);
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.MY_EXAMINE).params(params).tag(this).execute(new ResCallBack<MyExamineBean>(this) {
            @Override
            public void onCall(MyExamineBean responseBean, Call call, Response response) throws JSONException {
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

                            examineAdapter.notifyDataSetChanged();
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
                pageIndex = 1;
                getMyExamine(pageIndex, state, type);
                break;
        }
    }
}
