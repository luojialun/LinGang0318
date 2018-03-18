package com.lingang.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.LvGroupAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.FileBean;
import com.lingang.bean.NoticeDetaiBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.view.ExtraListView;
import com.lingang.view.JustifiedWebView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class NoticeDetailsAc extends BaseAc implements AdapterView.OnItemClickListener {

    @BindView(R.id.tv_no_title)
    TextView tvNoTitle;
    @BindView(R.id.tv_no_team)
    TextView tvNoTeam;
    @BindView(R.id.tv_no_time)
    TextView tvNoTime;
    @BindView(R.id.tv_no_num)
    TextView tvNoNum;
    @BindView(R.id.content_tv)
    JustifiedWebView contentTv;
    @BindView(R.id.lv_cail)
    ExtraListView lvRes;
    @BindView(R.id.sc_notice)
    ScrollView scNotice;
    @BindView(R.id.ll_file)
    LinearLayout llFile;
    private ArrayList<FileBean> filesBeen;
    private LvGroupAdapter lvResAdapter;
    private List<FileBean> files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_notice_details);
        setTitle("公告详情");

//        contentTv.setAutoLinkMask(Linkify.PHONE_NUMBERS);
//        contentTv.setMovementMethod(LinkMovementMethod.getInstance());

        filesBeen = new ArrayList<>();
        lvResAdapter = new LvGroupAdapter(this, filesBeen);
        lvRes.setOnItemClickListener(this);
        lvRes.setAdapter(lvResAdapter);

        String id = getIntent().getStringExtra("id");
        getNotice(id);

    }

    private void getNotice(String id) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("enterpriseId", id);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.NoticeDetails)
                .params(httpParams)
                .execute(new ResCallBack<NoticeDetaiBean>(this) {
                    @Override
                    public void onCall(NoticeDetaiBean noticeDetai, Call call, Response response) {
                        NoticeDetaiBean.DataBean data = noticeDetai.getData();
                        files = data.getFiles();
                        if (files.size() > 0) {
                            llFile.setVisibility(View.VISIBLE);
                            filesBeen.addAll(files);
                            lvResAdapter.notifyDataSetChanged();
                        }

                        tvNoTitle.setText(data.getEnterpriseTitle());
                        contentTv.setText(data.getEnterpriseContent());
                        tvNoTeam.setText(data.getBasicsName());
                        tvNoNum.setText(data.getLookNumber());
                        tvNoTime.setText(DateUtils.getTimes(data.getCreateTime(), "yyyy-MM-dd   HH:mm"));

                        scNotice.smoothScrollTo(0, 0);
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

//    //处理下载逻辑
//    @Override
//    public void onDownClinck(ImageView btnDown, CustomCircleProgress progress) {
//        int position = (int) btnDown.getTag();
//        String url = HttpApi.IMAGE_BASE_SERVER + filesBeen.get(position).getFileAddress();
//        btnDown.setVisibility(View.GONE);
//        btnDown.setEnabled(false);
//        progress.setVisibility(View.VISIBLE);
//        GetRequest getRequest = OkGo.get(url);
////        DownLoadServices.getInstance().downRes(url, getRequest, btnDown, progress);
//    }
}
