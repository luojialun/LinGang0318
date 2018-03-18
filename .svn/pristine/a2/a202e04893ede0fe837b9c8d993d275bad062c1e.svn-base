package com.lingang.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lingang.R;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jason on 17/8/8.
 * 扩展WebView,文字两端对齐，图片支持https加载，自动等比缩小
 */
public class JustifiedWebView extends WebView {
    //html代码
    private String htmlCode = "<html><head><style type=\"text/css\">img{display: inline;height: auto;max-width: 100%;}</style></head><body style='text-align:justify'> @content@ </body></html>";
    //内容
    private String text;
    private Context mContent;
    //链接支持属性
    private int autoLink;
    public JustifiedWebView(final Context context) {
        this(context, null, 0);
    }

    public JustifiedWebView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 构造
     * @param context
     * @param attrs
     * @param defStyle
     */
    public JustifiedWebView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        mContent = context;
        if (attrs != null) {
            final TypedValue typedValue = new TypedValue();
            final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.JustifiedWebView, defStyle, 0);
            if (typedArray != null) {
                //链接支持属性
                autoLink = typedArray.getInt(R.styleable.JustifiedWebView_autoLink,-1);
                //获取内容
                typedArray.getValue(R.styleable.JustifiedWebView_text, typedValue);
                if (typedValue.resourceId > 0 && TextUtils.isEmpty(text)) {
                    text = context.getString(typedValue.resourceId);
                    text.replace("\n", "<br />");
                    loadDataHtmlContent();
                }
            }
        }

        getSettings().setJavaScriptEnabled(true);//启用js
        getSettings().setBlockNetworkImage(false);//解决图片不显示
        //android 6.0 以上权限问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        //接受证书WebViewClient覆盖默认，解决图片加载https问题
        setWebViewClient(webViewClient);
    }

    /**
     * 返回内容
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * 加载内容
     * @param currentText
     */
    public void setText(String currentText) {
        this.text = currentText;
        loadDataHtmlContent();
    }

    /**
     * 加载html内容
     */
    private void loadDataHtmlContent() {
        text.replace("\n", "<br />");
        //是否支持电话
        if(autoLink==1) {
            processPhoneLink();
        }
        loadDataWithBaseURL("file:///android_asset/", htmlCode.replaceAll("@content@", text), "text/html", "UTF8", null);
    }

    /**
     * 处理电话连接
     */
    private void processPhoneLink()
    {
        //支持电话
        ArrayList<String> findList = new ArrayList<String>();
        String regex = "((((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})|((0[0-9]{2,3}\\\\-)?([1-9][0-9]{6,7})))";

        Pattern pat = Pattern.compile(regex);
        Matcher matcher = pat.matcher(text);
        while (matcher.find()) {
            findList.add(text.substring(matcher.start(), matcher.end()));
        }
        for (int i = 0; i < findList.size(); i++) {
            text = text.replaceAll(findList.get(i), String.format("<a href=\"tel:%1$s\">%1$s</a>", findList.get(i)));
        }
    }
    /**
     *接受证书WebViewClient覆盖默认，解决图片加载https问题
     */
    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            //一定要注释这个 super.onReceivedSslError(view, handler, error);
            handler.proceed();//接受网站证书
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //JS处理图片宽度适配屏幕大小
                 /*String javascript = "javascript:function ResizeImages() {" +
                 "var myimg,oldwidth;" +
                 "var maxwidth = document.body.clientWidth;" +
                 "for(i=0;i <document.images.length;i++){" +
                 "myimg = document.images[i];" +
                 "if(myimg.width > maxwidth){" +
                 "oldwidth = myimg.width;" +
                 "myimg.width = maxwidth;" +
                 "}" +
                 "}" +
                 "}";
                 //String width = String.valueOf(ScreenSizeUtils.getInstance(NewsDetailsAc.this).getScreenWidth());
                 view.loadUrl(javascript);
                 view.loadUrl("javascript:ResizeImages();");*/
        }

        /**
         * 处理A标记链接
         * @param view
         * @param url
         * @return
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //判断用户单击的是那个超连接
            String tag = "tel:";
            if (url.contains(tag)) {//处理拨打电话
                String mobile = url.substring(url.lastIndexOf("/") + 1);
                Uri uri = Uri.parse(mobile);
                ActivityCompat.checkSelfPermission(mContent, Manifest.permission.CALL_PHONE);
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                mContent.startActivity(intent);
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }
    };

}
