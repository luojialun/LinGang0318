package com.lingang.activity.tunity.execute;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.adapter.UpdateExecuteAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.MyTextWatcher;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.LengthFilterUtil;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.vector.update_app.utils.DrawableUtil;

import org.json.JSONException;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jason on 17/8/25.
 * 更新执行状态
 */
public class UpdateExecute extends BaseAc implements RecycleBaseAdapter.OnItemClickListener {
    @BindView(R.id.execute_update_rv)
    RecyclerView executeUpdateRv;
    @BindView(R.id.update_execute_content)
    EditText updateExecuteContent;
    @BindView(R.id.update_execute_submit)
    TextView updateExecuteSubmit;
    @BindView(R.id.update_content_num)
    TextView updateContentNum;

    //数据列表
    private String[] executeTypes;

    private UpdateExecuteAdapter updateAdapter;

    private String opportunityId = App.Empty;
    private String keyId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_update_execute);
        init();
    }

    private void init() {
        setTitle("更新执行状态");
        opportunityId = getIntent().getStringExtra("opportunityId");
        keyId = getIntent().getStringExtra(Constants.KEY_ID);
        executeTypes = getResources().getStringArray(R.array.opp_update_execute_type);
        List list = Arrays.asList(executeTypes);
        updateAdapter = new UpdateExecuteAdapter(UpdateExecute.this, list);
        updateAdapter.setOnItemClickListener(this);
//        setRecycleSimpleStyle(executeUpdateRv);
        executeUpdateRv.setLayoutManager(new LinearLayoutManager(this));
        executeUpdateRv.setAdapter(updateAdapter);

        DrawableUtil.setTextSolidTheme(updateExecuteSubmit, 6, 10, getResources().getColor(R.color.f57725));
        updateExecuteContent.setFilters(new InputFilter[]{new LengthFilterUtil(300)});
        updateExecuteContent.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateContentNum.setText(s.length() + "/300");
            }
        });
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        updateAdapter.setSelectIndex(position);
        updateAdapter.notifyDataSetChanged();
    }

    /**
     * 跳转到
     *
     * @param context
     */
    public static void gotoUpdateExecute(Context context, String opportunityId, String keyId) {
        Intent intent = new Intent(context, UpdateExecute.class);
        intent.putExtra("opportunityId", opportunityId);
        intent.putExtra(Constants.KEY_ID, keyId);
        ((Activity) context).startActivityForResult(intent, Constants.OppDetailRefreshType.RequestCode);
    }

    @OnClick(R.id.update_execute_submit)
    public void onViewClicked() {
        if (updateAdapter.getSelectIndex() < 0) {
            ToastUtils.showToast(UpdateExecute.this, "请选择当前执行节点!");
            return;
        }
        String content = updateExecuteContent.getText().toString();
        String subContent = "";
        if (content.length() > 300) {
            subContent = content.substring(0, 300);
        } else {
            subContent = content;
        }
        if (!TextUtils.isEmpty(subContent)) {
            submit(subContent, updateAdapter.getSelectIndex() + 1);
        } else {
            ToastUtils.showToast(this, "补充说明不能为空");
        }
    }

    public void submit(String content, int nodeType) {
        HttpParams params = new HttpParams();
        params.put("opportunityId", opportunityId);
        params.put("keyId", keyId);
        params.put("explainDetail", content);
        params.put("nodeType", nodeType);//(1、联系客户2、实地带看3、签订意向合同4、签订正式合同5、其他)
        params.put("type", "2");//（1、补充说明2、执行记录）
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ADD_MESSAGE).params(params).tag(this).execute(new ResCallBack<BaseEntity<Object, Object>>(this) {
            @Override
            public void onCall(BaseEntity<Object, Object> responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    ToastUtils.showToast(UpdateExecute.this, "更新成功");
                    setResult(Constants.OppDetailRefreshType.UpdateExecute);
                    finish();
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                ToastUtils.showToast(UpdateExecute.this, "提交失败，请重试");
            }
        });
    }
}
