package com.lingang.activity.business;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.UpdateExecuteAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ParkUserListBean;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.bean.UserListBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 转移商机/指派商机
 */
public class TransferAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener {
    @BindView(R.id.user_rv)
    RecyclerView userRv;
    @BindView(R.id.type_tv)
    TextView typeTv;

    private String parkId;
    private List<String> mList = new ArrayList<>();//名字集合
    private List<String> idList = new ArrayList<>(); //id集合
    private UpdateExecuteAdapter adapter;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_transfer);
        type = getIntent().getStringExtra(Constants.JUMP_TYPE);
        setTitle(type);
        parkId = getIntent().getStringExtra(Constants.CHOOSE_PARK_ID);
        userRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UpdateExecuteAdapter(this, mList);
        adapter.setOnItemClickListener(this);
        userRv.setAdapter(adapter);
        if (Constants.TRANSFER_OPP.equals(type)) {
            typeTv.setText("请选择转移对象");
            getUserList();
        } else {
            getOpportunityParkList();
            typeTv.setText("请选择指派对象园区");
        }
    }

    /**
     * 获取转移对象列表
     */
    public void getUserList() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        params.put("parkId", parkId);
        OkGo.post(HttpApi.USER_LIST).params(params).tag(this).execute(new ResCallBack<UserListBean>(this) {
            @Override
            public void onCall(UserListBean responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    if (responseBean.getData().size() > 0) {
                        mList.clear();
                        for (UserListBean.Data data : responseBean.getData()) {
                            mList.add(data.getUserName());
                            idList.add(data.getUserId() + "");
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    /**
     * 获取园区对象列表
     */
    private void getOpportunityParkList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getOpportunityParkList)
                .params(httpParams)
                .execute(new ResCallBack<TjTunityThreeBean>(this, false) {
                    @Override
                    public void onCall(TjTunityThreeBean responseBean, Call call, Response response) {
                        if (null != responseBean) {
                            if (responseBean.getDataMap().getParkList().size() > 0) {
                                mList.clear();
                                for (TjTunityThreeBean.DataMapBean.ParkListBean bean : responseBean.getDataMap().getParkList()) {
                                    mList.add(bean.getParkName());
                                    idList.add(bean.getParkId());
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        adapter.setSelectIndex(position);
        Intent intent = new Intent(TransferAc.this, TransferIllustrationAc.class);
        if (Constants.TRANSFER_OPP.equals(type)) {
            intent.putExtra(Constants.JUMP_TYPE, Constants.TRANSFER_ILL);
            intent.putExtra(Constants.CHOOSE_USER_ID, idList.get(position));
        } else {
            intent.putExtra(Constants.JUMP_TYPE, Constants.ASSIGN_ILL);
            intent.putExtra(Constants.CHOOSE_PARK_ID, idList.get(position));
        }
        intent.putExtra(Constants.USER_NAME, mList.get(position));
        intent.putExtra(Constants.KEY_ID,getIntent().getStringExtra(Constants.KEY_ID));
        intent.putExtra(Constants.OPPORTUNITY_ID, getIntent().getStringExtra(Constants.OPPORTUNITY_ID));
        startActivityForResult(intent, Constants.OppDetailRefreshType.RequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==Constants.OppDetailRefreshType.RESPONSE_FINISH) {
            setResult(Constants.OppDetailRefreshType.RESPONSE_FINISH);
            finish();
        }
    }
}
