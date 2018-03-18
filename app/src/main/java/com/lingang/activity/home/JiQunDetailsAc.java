package com.lingang.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.JiQunDetailAdapter;
import com.lingang.adapter.JiqunTeamAdapter;
import com.lingang.adapter.JiqunZoneAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.IndustryDetailsBean;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogError;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
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

public class JiQunDetailsAc extends BaseAc implements RecycleLabAdapter.OnItemClickListener
        , AdapterView.OnItemClickListener, PopConfirmClinck
        , View.OnClickListener {

    @BindView(R.id.img_group)
    ImageView imgGroup;
    @BindView(R.id.img_more)
    ImageView imgMore;
    @BindView(R.id.ll_intro)
    TextView llIntro;
    @BindView(R.id.img_expand)
    ImageView imgExpand;
    @BindView(R.id.content_group)
    AlignTextView contentGroup;
    @BindView(R.id.tf_tj)
    TagCloudView tfTj;
    @BindView(R.id.lv_zone)
    ExtraListView lvZone;
    @BindView(R.id.rv_zone)
    RecyclerView rvZone;
    @BindView(R.id.lv_zone_team)
    ExtraListView lvZoneTeam;
    @BindView(R.id.yuanq_num)
    TextView yuanqNum;
    @BindView(R.id.tv_teamnum)
    TextView tvTeamnum;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.jiqun_num)
    TextView jiqunNum;
    private boolean isExpend = false;
    private List<IndustryDetailsBean.DataBean.ParksBean> parks;
    private RecycleLabAdapter.OnItemClickListener listener;
    private AdapterView.OnItemClickListener itmeListener;
    private View.OnClickListener clincListener;
    private String industryTitle;
    private String industryLink;
    private String industryId;
    private DialogError dialogError;
    private List<IndustryDetailsBean.DataBean.StationsBean> stations;
    private List<IndustryDetailsBean.DataBean.IndustryLevelsBean> industryLevels;
    private JiQunDetailAdapter jiQunDetailAdapter;
    private IndustryDetailsBean.DataBean data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_ji_qun_details);
        listener = this;
        itmeListener = this;
        clincListener = this;
        getIndustryDetails();
        getRightView().setImageResource(R.mipmap.error);
    }

    private void getIndustryDetails() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("industryId", getIntent().getStringExtra("id"));
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.IndustryDetails)
                .params(httpParams)
                .execute(new ResCallBack<IndustryDetailsBean>(this) {
                    @Override
                    public void onCall(IndustryDetailsBean cluster, Call call, Response response) {
                        data = cluster.getData();
                        industryTitle = data.getIndustryTitle();
                        industryLink = data.getIndustryLink();
                        if(TextUtils.isEmpty(industryLink)){
                            imgMore.setVisibility(View.GONE);
                        }
                        industryId = data.getIndustryId();
                        setTitle(industryTitle);
                        GlideImgManager.glideLoader(JiQunDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + data.getImgPath(), imgGroup);

                        contentGroup.setContent(data.getIndustryContent());

                        //关键字

                        List<IndustryDetailsBean.DataBean.LabelsBeanX> labels = data.getLabels();
                        if (labels.size() > 0) {
                            ArrayList<String> classList = new ArrayList<>();
                            for (IndustryDetailsBean.DataBean.LabelsBeanX LabelsBeanX :
                                    labels) {
                                classList.add(LabelsBeanX.getLabelName());
                            }
                            tfTj.setTags(classList);
                        } else {
                            llTag.setVisibility(View.GONE);
                        }


                        //二级集群
                        industryLevels = data.getIndustryLevels();
                        for (IndustryDetailsBean.DataBean.IndustryLevelsBean industryLevelsBean : industryLevels) {
                            industryLevelsBean.setSelect(false);
                        }
                        jiqunNum.setText(industryLevels.size() + "个二级产业");
                        jiQunDetailAdapter = new JiQunDetailAdapter(JiQunDetailsAc.this, industryLevels, clincListener);
                        lvZone.setAdapter(jiQunDetailAdapter);

                        //产业园区
                        parks = data.getParks();
                        yuanqNum.setText(parks.size() + "个园区");
                        setRecycleHorizontal(rvZone);
                        setRefreshViewLine(rvZone, R.drawable.item_divider_tran_magin5);
                        JiqunZoneAdapter jiqunZoneAdapter = new JiqunZoneAdapter(JiQunDetailsAc.this, parks);
                        jiqunZoneAdapter.setOnItemClickListener(listener);
                        rvZone.setAdapter(jiqunZoneAdapter);

                        //企业列表
                        stations = data.getStations();
                        String stationCount = data.getStationCount();
                        if (!TextUtils.isEmpty(stationCount))
                            tvTeamnum.setText(stationCount + "家企业");
                        JiqunTeamAdapter chanyeTeamAdapter = new JiqunTeamAdapter(JiQunDetailsAc.this, stations);
                        lvZoneTeam.setOnItemClickListener(itmeListener);
                        lvZoneTeam.setAdapter(chanyeTeamAdapter);
                    }
                });

    }


    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (dialogError == null) {
            dialogError = new DialogError(this, this);
        }
        dialogError.show();
    }

    @OnClick(R.id.img_expand)
    public void onViewClicked() {
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
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, ChanYeDetailsAc.class).putExtra("id", parks.get(position).getParkId()));
    }

    @OnClick({R.id.img_more, R.id.ll_moregs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_more:
                startActivity(new Intent(this, WebAc.class).putExtra("title", industryTitle).putExtra("url", industryLink));
                break;
            case R.id.ll_moregs:
                String id = "";
                List<IndustryDetailsBean.DataBean.IndustryLevelsBean> industryLevels = data.getIndustryLevels();
                if (industryLevels.size() > 0) {
                    for (IndustryDetailsBean.DataBean.IndustryLevelsBean industryLevel : industryLevels) {
                        if (id.equals("")) {
                            id = industryLevel.getLevelId();
                        } else {
                            id = industryLevel.getLevelId() + "," + id;
                        }
                    }
                }
                startActivity(new Intent(this, EntryAc.class).putExtra("name", data.getIndustryTitle()).putExtra("id", id).putExtra("tag", "jiqun"));
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this, EntryDetailsAc.class).putExtra("id", stations.get(i).getStationId()));
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
        httpParams.put("linkType", Constants.CorrectType.Industry);
        httpParams.put("linkId", industryId);
        httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UserOpinion)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) {
                        ToastUtils.showToast(JiQunDetailsAc.this, "提交成功");
                    }
                });
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        industryLevels.get(position).setSelect(!industryLevels.get(position).isSelect());
        jiQunDetailAdapter.notifyDataSetChanged();
    }
}
