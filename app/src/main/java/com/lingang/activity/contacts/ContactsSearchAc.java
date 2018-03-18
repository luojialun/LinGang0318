package com.lingang.activity.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.adapter.ContactsSearchAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.ContactsSeachBean;
import com.lingang.common.LoginManager;
import com.lingang.dialog.ContactsSelectTypeDialog;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.SystemBarHelper;
import com.lingang.view.EmptyRecyclerView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 通讯录-公司页面
 */
public class ContactsSearchAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener {

    @BindView(R.id.ib_left)
    ImageView ibLeft;
    @BindView(R.id.contact_select_name)
    TextView contactSelectName;
    @BindView(R.id.search_input_ed)
    EditText searchInputEd;
    @BindView(R.id.search_toolbar)
    LinearLayout searchToolbar;
    @BindView(R.id.contact_search_iv)
    ImageView contactSearchIv;
    @BindView(R.id.tv_newsnum)
    TextView tvNewsnum;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ContactsSearchAdapter adapter;
    private ContactsSelectTypeDialog dialog;
    private List<ContactsSeachBean.DataBean> mList;
    private String selectValue = "1";//1姓名 2账号 3直线 4内线 5手机号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_search);
        ButterKnife.bind(this);
        initView();
        bindView();
    }

    private void initView() {
        SystemBarHelper.setHeightAndPadding(this, searchToolbar);
        dialog = new ContactsSelectTypeDialog(this);
        dialog.setSelectCallback(new ContactsSelectTypeDialog.OnSelectCallback() {
            @Override
            public void onSelectItem(String selectName) {
                contactSelectName.setText(selectName);
                switch (selectName) {
                    case "员工姓名":
                        selectValue = "1";
                        break;
                    case "员工账号":
                        selectValue = "2";
                        break;
                    case "手机号码":
                        selectValue = "5";
                        break;
                    case "内线电话":
                        selectValue = "4";
                        break;
                    case "直线电话":
                        selectValue = "3";
                        break;
                }
            }
        });
        /*****************搜索事件**************/
        searchInputEd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String s = v.getText().toString();
                    if (!TextUtils.isEmpty(s)) {
                        getContactListShow(s);
                    }

                    return true;
                }
                return false;
            }
        });
    }

    //获取组织信息
    private void getContactListShow(String keyvalue) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("selectvalue", selectValue);
        httpParams.put("keyvalue", keyvalue);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getContactListShow)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        String result = adressBean.getData();
                        Gson gson = new Gson();
                        List<ContactsSeachBean.DataBean> data = gson.fromJson(result.replaceAll("\\\\", ""), ContactsSeachBean.class).getData();
                        mList.clear();
                        mList.addAll(data);
                        Spannable span = new SpannableString("共有" + data.size() + "条查询结果");
                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, String.valueOf(data.size()).length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNewsnum.setText(span);
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    /**
     * 绑定数据
     */
    private void bindView() {
        Spannable span = new SpannableString("共有0条查询结果");
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvNewsnum.setText(span);

        mList = new ArrayList<>();
        adapter = new ContactsSearchAdapter(this, mList);

        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        refresh.setEnableRefresh(false);
        refresh.setOverScrollTopShow(false);
        refresh.setEnableLoadmore(false);
        refresh.setOverScrollBottomShow(false);//刷新控件bug 设置之后就没事了

        adapter.setOnItemClickListener(this);
        recyclerview.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, Object item, int position) {
        ContactsSeachBean.DataBean dataBean = mList.get(position);
        Intent intent = new Intent();
        intent.setClass(this, PersonInfoActivity.class);
        intent.putExtra("userid", dataBean.getJobid());
        intent.putExtra("email",dataBean.getUserEmail());
        intent.putExtra("mb",dataBean.getUserMb());
        intent.putExtra("name",dataBean.getUserCHName());
        intent.putExtra("photo",dataBean.getUserPhoto());
        intent.putExtra("tag","oa");
        startActivity(intent);
    }

    @OnClick({R.id.ib_left, R.id.contact_select_name, R.id.contact_search_iv})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.contact_select_name:
                dialog.show(contactSelectName);
                break;
            case R.id.ib_left:
                finish();
                break;
            case R.id.contact_search_iv:
                String s = searchInputEd.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                    getContactListShow(s);
                }

                break;
        }
    }
}
