package com.lingang.activity.tunity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.NexusAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ClusterBean;
import com.lingang.bean.NexusBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class NexusAc extends BaseRecycleViewAc implements RecycleBaseAdapter.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ArrayList<NexusBean.DataMapBean.ListBean> data;
    private NexusAdapter nexusAdapter;
    private String basicsType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_nexus);
        basicsType = getIntent().getStringExtra("basicsType");

        setTitle(getIntent().getStringExtra("tag"));
        initView();
        basicsListByType();
    }

    private void initView() {
        refresh.setEnableRefresh(false);
        refresh.setEnableLoadmore(false);
        setRecycleAspect(recyclerview);
        data = new ArrayList<>();
        nexusAdapter = new NexusAdapter(this, data);
        recyclerview.setAdapter(nexusAdapter);
        nexusAdapter.setOnItemClickListener(this);
    }


    //获取数据   basicsType 1.服务信息 2.合作层级 3.开放层级4.招商信息 5.图集列表 6.新闻类型
    //          7.政策类型 8.商机撤回原因分类 9.公告类型10.租售物业销售模式)11(厂房)落地形式、12(厂房)区位要求、13(研发办公)落地形式、
    //         14(研发办公)区位要求、15(土地)区位要求、16(土地)土地性质、17(注册型企业)企业类型 18（推荐商机）客户关系、19（推荐商）称呼
    private void basicsListByType() {
        String type = "";
        //接口参数调整 区位要求 都是12
        if (basicsType.equals("12") || basicsType.equals("14") || basicsType.equals("15")){
            type = "12";
        }else {
            type = basicsType;
        }
        HttpParams httpParams = new HttpParams();
        httpParams.put("basicsType", type);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.basicsListByType)
                .params(httpParams)
                .execute(new ResCallBack<NexusBean>(this) {
                    @Override
                    public void onCall(NexusBean cluster, Call call, Response response) {
                        data.addAll(cluster.getDataMap().getList());
                        if (data.size() > 0) {
                            nexusAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        Intent intent = new Intent();
        intent.putExtra("value", data.get(position).getBasicsName());
        intent.putExtra("valueId", data.get(position).getBasicsId());
        switch (basicsType) {
            case "18":
                setResult(Constants.NexusKeh, intent);
                break;
            case "19":
                setResult(Constants.NexusChengh, intent);
                break;
            case "11":
                setResult(Constants.Plan_Ld, intent);
                break;
            case "12":
                setResult(Constants.Plan_Qw, intent);
                break;
            case "17":
                setResult(Constants.Zhuc_Class, intent);
                break;
            case "15":
                setResult(Constants.Lad_Qw, intent);
                break;
            case "16":
                setResult(Constants.Lad_Xz, intent);
                break;
            case "13":
                setResult(Constants.Work_Ld, intent);
                break;
            case "14":
                setResult(Constants.Work_Qw, intent);
                break;
            case "20":
                setResult(Constants.LandGetBack, intent);
                break;
        }
        finish();
    }
}
