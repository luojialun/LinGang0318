package com.lingang.activity.home;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.view.ProgressWebView;

import butterknife.BindView;

public class WebAc extends BaseAc {

    @BindView(R.id.wv_more)
    ProgressWebView webView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_web);
        String title = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");
        setTitle(title);
        //支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        webView.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setTextZoom(100);
        if (url != null) {
            webView.loadUrl(url);
        }
    }
}
