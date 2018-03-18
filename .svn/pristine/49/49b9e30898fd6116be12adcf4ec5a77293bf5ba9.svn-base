package com.lingang.activity.user;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.common.Constants;

import butterknife.BindView;

public class VersionDetailsAc extends BaseAc {

    @BindView(R.id.content_tv)
    TextView contentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_version_details);
        setTitle("版本记录内容");

        String content = getIntent().getStringExtra(Constants.VERSION_CONTENT);
        if (!TextUtils.isEmpty(content)) {
            contentTv.setText(Html.fromHtml(content));
        }

    }
}
