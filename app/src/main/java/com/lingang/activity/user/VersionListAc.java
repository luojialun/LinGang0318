package com.lingang.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lingang.R;
import com.lingang.adapter.VersionListAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.VersionBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class VersionListAc extends BaseRecycleViewAc {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private VersionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_version_list);
        setTitle("版本记录");
        setRecycleAspect(recyclerview);
        getVersionList();

    }

    public void getVersionList() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        params.put("type", 1);
        OkGo.post(HttpApi.VERSION_LIST).tag(this).params(params).execute(new ResCallBack<VersionBean>(this) {
            @Override
            public void onCall(final VersionBean responseBean, Call call, Response response) throws JSONException {
                adapter = new VersionListAdapter(VersionListAc.this, responseBean.getData());
                recyclerview.setAdapter(adapter);
                adapter.setOnItemClickListener(new RecycleBaseAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, Object item, int position) {
                        Intent intent=new Intent(VersionListAc.this,VersionDetailsAc.class);
                        intent.putExtra(Constants.VERSION_CONTENT,responseBean.getData().get(position).getUpdateContent());
                        startActivity(intent);
                    }
                });
            }
        });

    }
}
