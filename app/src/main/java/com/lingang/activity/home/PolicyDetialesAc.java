package com.lingang.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.LvGroupAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.CollectResultBean;
import com.lingang.bean.FileBean;
import com.lingang.bean.PolicyDetailesBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AlignTextView;
import com.lingang.view.ExtraListView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.next.tagview.TagCloudView;
import okhttp3.Call;
import okhttp3.Response;

public class PolicyDetialesAc extends BaseAc implements AdapterView.OnItemClickListener{

    @BindView(R.id.tv_poli_title)
    TextView tvPoliTitle;
    @BindView(R.id.tv_poli_data)
    TextView tvPoliData;
    @BindView(R.id.tv_poli_content)
    TextView tvPoliContent;
    @BindView(R.id.lv_cail)
    ExtraListView lvCail;
    @BindView(R.id.sc_poli)
    ScrollView scPoli;
    @BindView(R.id.img_release)
    ImageView imgRelease;
    @BindView(R.id.tv_poli_gs)
    TextView tvPoliGs;
    @BindView(R.id.iv_watch)
    ImageView ivWatch;
    @BindView(R.id.pc_lable)
    TagCloudView pcLable;
    @BindView(R.id.ll_file)
    LinearLayout llFile;
    private String collectId;
    private String collectState;
    private String policyId;
    private List<FileBean> files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_policy_detiales);
        setTitle("政策详情");
        lvCail.setOnItemClickListener(this);
        getPolicyDetails();
    }

    private void getPolicyDetails() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("policyId", getIntent().getStringExtra("id"));
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.PolicyDetails)
                .params(httpParams)
                .execute(new ResCallBack<PolicyDetailesBean>(this, false) {
                    @Override
                    public void onCall(PolicyDetailesBean adressBean, Call call, Response response) {
                        collectId = adressBean.getData().getCollectId();
                        collectState = adressBean.getData().getCollectState();
                        policyId = adressBean.getData().getPolicyId();

                        tvPoliTitle.setText(adressBean.getData().getPolicyTitle());
                        tvPoliContent.setText(Html.fromHtml(adressBean.getData().getPolicyContent()));
                        tvPoliData.setText(DateUtils.getTimes(adressBean.getData().getCreateTime(), "yyyy-MM-dd"));
                        files = adressBean.getData().getFiles();
                        if (files.size() > 0) {
                            llFile.setVisibility(View.VISIBLE);
                            lvCail.setAdapter(new LvGroupAdapter(PolicyDetialesAc.this, files));
                        }

                        tvPoliGs.setText(adressBean.getData().getAuthorName());
                        GlideImgManager.glideLoaderFabu(PolicyDetialesAc.this, HttpApi.IMAGE_BASE_SERVER + adressBean.getData().getImgPath(), imgRelease);

                        if (adressBean.getData().getCollectState().equals("1")) {
                            ivWatch.setSelected(true);
                        } else {
                            ivWatch.setSelected(false);
                        }

                        //关键字
                        ArrayList<String> classList = new ArrayList<>();
                        for (PolicyDetailesBean.DataBean.LabelsBean labelsBean :
                                adressBean.getData().getLabels()) {
                            classList.add(labelsBean.getLabelName());
                        }
                        pcLable.setTags(classList);

                        scPoli.smoothScrollTo(0, 0);
                    }
                });
    }

    @OnClick(R.id.iv_watch)
    public void onViewClicked() {
        if (collectState.equals("1")) {//1:收藏0:未收藏
            delUserCollect();
        } else {
            addUserCollect();
        }
    }

    //收藏
    private void addUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectType", Constants.FavoritesType.POLICY);
        httpParams.put("objId", policyId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<CollectResultBean, Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<CollectResultBean, Object> collectBean, Call call, Response response) {
                        if(collectBean !=null)
                        {
                            ToastUtils.showToast(PolicyDetialesAc.this, "收藏成功");
                            ivWatch.setSelected(true);
                            collectState = Constants.CollectState.collected;
                            collectId=String.valueOf(collectBean.getData().getCollectId());
                        }
                    }
                });
    }

    //取消收藏
    private void delUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectId", collectId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.delUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ivWatch.setSelected(false);
                        collectState= Constants.CollectState.collect;
                        ToastUtils.showToast(PolicyDetialesAc.this, "取消收藏");
                    }
                });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, PdfViewerActivity.class);
        intent.putExtra(Constants.PDF_TITLE, files.get(i).getFileTitle());
        intent.putExtra(Constants.PDF_ADDRESS, HttpApi.IMAGE_BASE_SERVER + files.get(i).getFileAddress());
        intent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_PREVIEW);
        startActivity(intent);
    }
}
