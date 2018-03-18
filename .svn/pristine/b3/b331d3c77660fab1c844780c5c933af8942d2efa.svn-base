package com.lingang.activity.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.adapter.EntryZoneAdapter;
import com.lingang.adapter.LvEntryPerAdapter;
import com.lingang.adapter.LvEntryYuQuAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.EntryDetailesBean;
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

public class EntryDetailsAc extends BaseAc implements RecycleLabAdapter.OnItemClickListener
        , PopConfirmClinck, AdapterView.OnItemClickListener {

    @BindView(R.id.ll_intro)
    TextView llIntro;
    @BindView(R.id.img_expand)
    ImageView imgExpand;
    @BindView(R.id.content_group)
    AlignTextView contentGroup;
    @BindView(R.id.tf_tj)
    TagCloudView tfTj;
    @BindView(R.id.rv_zone)
    RecyclerView rvZone;
    @BindView(R.id.img_entry)
    ImageView imgEntry;
    @BindView(R.id.tv_entry)
    TextView tvEntry;
    @BindView(R.id.tv_entry_lable)
    TextView tvEntryLable;
    @BindView(R.id.tv_xiny)
    TextView tvXiny;
    @BindView(R.id.lv_jiqun)
    ExtraListView lvJiqun;
    @BindView(R.id.lv_per)
    ExtraListView lvPer;
    @BindView(R.id.tv_dw)
    TextView tvDw;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.tv_is)
    TextView tvIs;
    @BindView(R.id.tv_jiqun)
    TextView tvJiqun;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.jiqun_num)
    TextView jiqunNum;
    @BindView(R.id.per_num)
    TextView perNum;
    @BindView(R.id.homepage_tv)
    TextView homepageTv;

    private boolean isExpend = false;
    private boolean isDingw = false;
    private RecycleLabAdapter.OnItemClickListener listener;
    private AdapterView.OnItemClickListener mListener;
    private List<EntryDetailesBean.DataBean.ParksvoBean> parksvo;
    private String collectState;
    private String collectId;
    private String stationId;
    private DialogError dialogError;
    private List<EntryDetailesBean.DataBean.User> users;
    private ArrayList<EntryDetailesBean.DataBean.IndustrysBean.IndustryLevelsBean> industryList;
    private LvEntryYuQuAdapter lvEntryYuQuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_entry);
        setTitle("存量客户详情");
        listener = this;
        mListener = this;
        getRightView2().setImageResource(R.mipmap.error);
        getStationDetails(true);
    }

    private void getStationDetails(final boolean isRefresh) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("stationId", getIntent().getStringExtra("id"));
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.StationDetails)
                .params(httpParams)
                .execute(new ResCallBack<EntryDetailesBean>(this) {
                    @Override
                    public void onCall(final EntryDetailesBean cluster, Call call, Response response) {
                        collectState = cluster.getData().getCollectState();
                        collectId = cluster.getData().getCollectId();
                        stationId = cluster.getData().getStationId();

                        //收藏状态
                        if (collectState.equals("1")) {//1:收藏0:未收藏
                            getRightView().setImageResource(R.mipmap.collect_success);
                        } else {
                            getRightView().setImageResource(R.mipmap.collect);
                        }
                        if (isRefresh) {
                            GlideImgManager.glideLoaderNormal(EntryDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + cluster.getData().getImgPath(), imgEntry);
                            tvEntry.setText(cluster.getData().getStationTitle());
                            tvEntryLable.setText(cluster.getData().getStationSimple());
                            tvXiny.setText("统一社会信用代码: " + cluster.getData().getCreditCode());
                            contentGroup.setContent(cluster.getData().getStationContent());
                            //标签
                            List<EntryDetailesBean.DataBean.LabelsBean> labels = cluster.getData().getLabels();
                            if (labels.size() > 0) {
                                ArrayList<String> classList = new ArrayList<>();
                                for (EntryDetailesBean.DataBean.LabelsBean labelsBean :
                                        labels) {
                                    classList.add(labelsBean.getLabelName());
                                }
                                tfTj.setTags(classList);
                            } else {
                                llTag.setVisibility(View.GONE);
                            }
                            //企业主页
                            homepageTv.setText(TextUtils.isEmpty(cluster.getData().getHomePage()) ? "无" : cluster.getData().getHomePage());
                            if (!TextUtils.isEmpty(cluster.getData().getHomePage())) {
                                homepageTv.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        try {
                                            Uri uri = Uri.parse("http://" + cluster.getData().getHomePage());
                                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                            startActivity(intent);
                                        } catch (Exception e) {
                                            Log.i("TAG", "跳转链接问题");
                                        }
                                    }
                                });
                            }

                            //所在园区
                            parksvo = cluster.getData().getParksvo();

                            setRecycleHorizontal(rvZone);
                            setRefreshViewLine(rvZone, R.drawable.item_divider_tran_magin5);
                            EntryZoneAdapter entryZoneAdapter = new EntryZoneAdapter(EntryDetailsAc.this, parksvo);
                            entryZoneAdapter.setOnItemClickListener(listener);
                            rvZone.setAdapter(entryZoneAdapter);

                            //所属产业集群
                            List<EntryDetailesBean.DataBean.IndustrysBean> industrys = cluster.getData().getIndustrys();
                            industryList = new ArrayList<>();
                            for (int i = 0; i < industrys.size(); i++) {
                                List<EntryDetailesBean.DataBean.IndustrysBean.IndustryLevelsBean> industryLevels = industrys.get(i).getIndustryLevels();
                                for (EntryDetailesBean.DataBean.IndustrysBean.IndustryLevelsBean industryLevelsBean :
                                        industryLevels) {
                                    EntryDetailesBean.DataBean.IndustrysBean.IndustryLevelsBean industryLevelb = new EntryDetailesBean.DataBean.IndustrysBean.IndustryLevelsBean();
                                    industryLevelb.setLevelTitle(industrys.get(i).getIndustryTitle() + "--" + industryLevelsBean.getLevelTitle());
                                    industryLevelb.setIndustryId(industrys.get(i).getIndustryId());
                                    industryList.add(industryLevelb);
                                }
                            }

                            jiqunNum.setText(industryList.size() + "个二级产业");
                            lvJiqun.setOnItemClickListener(mListener);
                            lvEntryYuQuAdapter = new LvEntryYuQuAdapter(EntryDetailsAc.this, industryList);
                            lvJiqun.setAdapter(lvEntryYuQuAdapter);

                            users = cluster.getData().getUsers();
                            perNum.setText(users.size() > 0 ? "" : "无");
                            lvPer.setAdapter(new LvEntryPerAdapter(EntryDetailsAc.this, users));
                            lvPer.setOnItemClickListener(mListener);

                            String stationCompany = cluster.getData().getStationCompany();
                            tvDw.setText(TextUtils.isEmpty(stationCompany) ? "无" : stationCompany);
                            String createTime = cluster.getData().getCreateTime();
                            tvData.setText(TextUtils.isEmpty(createTime) ? "无" : DateUtils.getTimes(createTime, "yyyy-MM-dd"));
                            if (cluster.getData().getIsFictitious().equals("1")) {
                                tvIs.setText("是");
                            } else {
                                tvIs.setText("否");
                            }
                        }

                    }
                });

    }

    @OnClick({R.id.img_expand, R.id.jiqun_num})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_expand:
                int lineCount = contentGroup.getLinesNum();
                if (!isExpend) {
                    if (lineCount > 6) {
                        contentGroup.setMaxLines(lineCount);
                    }
                    isExpend = true;
                    imgExpand.setImageResource(R.mipmap.up);
                } else {
                    // 复原
                    if (lineCount > 6) {
                        contentGroup.setMaxLines(6);
                    }
                    isExpend = false;
                    imgExpand.setImageResource(R.mipmap.pull);
                }
                break;
            case R.id.jiqun_num:
                Drawable nav_up;
                if (!isDingw) {
                    if (industryList != null && industryList.size() >= 6)
                        lvEntryYuQuAdapter.setItmeNum(industryList.size());
                    isDingw = true;
                    nav_up = getResources().getDrawable(R.mipmap.up);
                } else {
                    if (industryList != null && industryList.size() >= 6)
                        lvEntryYuQuAdapter.setItmeNum(6);
                    isDingw = false;
                    nav_up = getResources().getDrawable(R.mipmap.pull);
                }
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                jiqunNum.setCompoundDrawables(null, null, nav_up, null);
                break;
        }

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
        httpParams.put("collectType", "4");
        httpParams.put("objId", stationId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        getStationDetails(false);
                        ToastUtils.showToast(EntryDetailsAc.this, "收藏成功");
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
                        getStationDetails(false);
                        ToastUtils.showToast(EntryDetailsAc.this, "取消收藏");
                    }
                });
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, ChanYeDetailsAc.class).putExtra("id", parksvo.get(position).getParkId()));
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
        httpParams.put("linkType", Constants.CorrectType.Entry);
        httpParams.put("linkId", stationId);
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(EntryDetailsAc.this, "提交成功");
                    }
                });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.lv_per:
                startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", users.get(i).getUserAccount()).putExtra("tag", "bendi"));
                break;
            case R.id.lv_jiqun:
                startActivity(new Intent(this, JiQunDetailsAc.class).putExtra("id", industryList.get(i).getIndustryId()));
                break;
        }

    }
}
