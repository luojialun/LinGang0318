package com.lingang.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.base.BaseAc;
import com.lingang.bean.PartnerDeBean;
import com.lingang.bean.Users;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogError;
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

public class PartnerDetailsAc extends BaseAc implements PopConfirmClinck, AdapterView.OnItemClickListener {

    @BindView(R.id.img_entry)
    ImageView imgEntry;
    @BindView(R.id.tv_entry)
    TextView tvEntry;
    @BindView(R.id.tv_entry_lable)
    TextView tvEntryLable;
    @BindView(R.id.ll_intro)
    TextView llIntro;
    @BindView(R.id.content_group)
    AlignTextView contentGroup;
    @BindView(R.id.tv_jt)
    TextView tvJt;
    @BindView(R.id.tv_jtclass)
    TextView tvJtclass;
    @BindView(R.id.tv_dw)
    TextView tvDw;
    @BindView(R.id.tv_xytime)
    TextView tvXytime;
    @BindView(R.id.lv_per)
    ExtraListView lvPer;
    @BindView(R.id.tv_gs)
    TextView tvGs;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.tf_tj)
    TagCloudView tfTj;
    @BindView(R.id.ll_gs)
    LinearLayout llGs;
    @BindView(R.id.tv_pj)
    AlignTextView tvPj;
    @BindView(R.id.tv_xmpj)
    TextView tvXmpj;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.per_sta)
    TextView perSta;
    private boolean isExpend = false;
    private boolean isPj = false;
    private String collectState;
    private String collectId;
    private String partnerId;
    private DialogError dialogError;
    private AdapterView.OnItemClickListener itmeListion;
    private List<Users> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_partner_details);
        setTitle("合作伙伴详情");
        itmeListion = this;
        getRightView2().setImageResource(R.mipmap.error);
        llGs.setVisibility(View.GONE);
        getPartnerDetails();
    }

    private void getPartnerDetails() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("partnerId", getIntent().getStringExtra("id"));
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.PartnerDetails)
                .params(httpParams)
                .execute(new ResCallBack<PartnerDeBean>(this, false) {
                    @Override
                    public void onCall(PartnerDeBean cluster, Call call, Response response) {

                        GlideImgManager.glideLoaderNormal(PartnerDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + cluster.getData().getImgPath(), imgEntry);

                        collectState = cluster.getData().getCollectState();
                        collectId = cluster.getData().getCollectId();
                        partnerId = cluster.getData().getPartnerId();
                        //简介
                        contentGroup.setContent(cluster.getData().getPartnerContent());
                        tvEntry.setText(cluster.getData().getPartnerName());
                        tvEntryLable.setText(cluster.getData().getPartnerSimple());
                        tvPj.setContent(cluster.getData().getPartnerProject());
                        //收藏状态
                        if (collectState.equals("1")) {//1:收藏0:未收藏
                            getRightView().setImageResource(R.mipmap.collect_success);
                        } else {
                            getRightView().setImageResource(R.mipmap.collect);
                        }

                        //关键字
                        List<PartnerDeBean.DataBean.LabelsBean> labels = cluster.getData().getLabels();
                        if (labels.size() > 0) {
                            ArrayList<String> classList = new ArrayList<>();
                            for (PartnerDeBean.DataBean.LabelsBean labelsBean :
                                    labels) {
                                classList.add(labelsBean.getLabelName());
                            }
                            tfTj.setTags(classList);
                        } else {
                            llTag.setVisibility(View.GONE);
                        }


                        tvJt.setText(cluster.getData().getBasicsName());
                        tvJtclass.setText(cluster.getData().getTypeName());

                        List<PartnerDeBean.DataBean.SignCompanysBean> signCompanys = cluster.getData().getSignCompanys();
                        if (signCompanys.size() > 0) {
                            tvDw.setText(signCompanys.get(0).getCompanyName());
                        }
                        String createTime = cluster.getData().getCreateTime();
                        tvData.setText(TextUtils.isEmpty(createTime) ? "无" : DateUtils.getTimes(createTime, "yyyy-MM-dd"));

                        String signTime = cluster.getData().getSignTime();
                        tvXytime.setText(TextUtils.isEmpty(signTime) ? "无" : DateUtils.getTimes(signTime, "yyyy-MM-dd"));
                        tvGs.setText(cluster.getData().getPartnerCompany());

                        //联系人
                        users = cluster.getData().getUsers();
                        if (users.size() == 0){
                            perSta.setText("无");
                        }else {
                            lvPer.setAdapter(new LvPublicPerAdapter(PartnerDetailsAc.this, users));
                            lvPer.setOnItemClickListener(itmeListion);
                        }
                    }
                });
    }

    @Override
    public void ibClickRight2() {
        super.ibClickRight2();
        if (dialogError == null) {
            dialogError = new DialogError(this, this);
        }
        dialogError.show();
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (collectState.equals("1")) {//1:收藏0:未收藏
            delUserCollect();
        } else {
            addUserCollect();
        }
    }

    //收藏
    private void addUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectType", "2");
        httpParams.put("objId", partnerId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        getPartnerDetails();
                        ToastUtils.showToast(PartnerDetailsAc.this, "收藏成功");
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
                        getPartnerDetails();
                        ToastUtils.showToast(PartnerDetailsAc.this, "取消收藏");
                    }
                });
    }

    @OnClick({R.id.ll_intro, R.id.tv_xmpj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_intro:
                openMore(llIntro, 0);
                break;
            case R.id.tv_xmpj:
                openMore(tvXmpj, 1);
                break;
        }

    }

    private void openMore(TextView attention, int tag) {
        boolean isSelect;
        int lineCount;
        if (tag == 0) {
            isSelect = isExpend;
            lineCount = contentGroup.getLinesNum();
        } else {
            isSelect = isPj;
            lineCount = tvPj.getLinesNum();
        }

        if (!isSelect) {
            if (lineCount > 6) {
                if (tag == 0) {
                    contentGroup.setMaxLines(lineCount);
                } else {
                    tvPj.setMaxLines(lineCount);
                }
            }
            isSelect = true;
            setDrawableLeft(attention, R.mipmap.up);
        } else {
            // 复原
            if (lineCount > 6) {
                if (tag == 0) {
                    contentGroup.setMaxLines(6);
                } else {
                    tvPj.setMaxLines(6);
                }
            }
            isSelect = false;
            setDrawableLeft(attention, R.mipmap.pull);
        }
        if (tag == 0) {
            isExpend = isSelect;
        } else {
            isPj = isSelect;
        }

    }


    private void setDrawableLeft(TextView attention, int drawableId) {
        Drawable drawable = getResources().getDrawable(drawableId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        attention.setCompoundDrawables(null, null, drawable, null);
    }

    @Override
    public void popConfirmClinck(String sign, String value) {
        UserOpinion(value);
    }

    //信息纠错
    private void UserOpinion(String value) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("messageType", "1");
        httpParams.put("messageContent", value);
        httpParams.put("linkType", Constants.CorrectType.Partner);
        httpParams.put("linkId", partnerId);
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(PartnerDetailsAc.this, "提交成功");
                    }
                });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", users.get(i).getUserAccount()).putExtra("tag", "bendi"));
    }
}
