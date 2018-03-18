package com.lingang.view;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Toast;

import com.lingang.activity.user.UserRecordAc;

/**
 * Created by jason on 17/8/15.
 */

public class TextViewTemp {
    //注意TextView的布局文件里面加属性   android:autoLink="all"
    /*
        String html="<font color='red'>样式一</font> ";
        html+="<font color='#0000FF'> <big> <i> 样式二 </i> </big> <font>";
        html+="<font color='@"+android.R.color.white+"'> <tt> <b> <big> <u> 样式三 </u> </big> </b> </tt> </font> ";
        html+="<big> <a href='http://blog.csdn.net/a_mean'>我的博客:http://blog.csdn.net/a_mean </a> </big>";
        //富文本A事件处理使用示例
        contentTxt.setText(getClickableHtml(html));
        contentTxt.setMovementMethod(LinkMovementMethod.getInstance());


    //TextView富文本A事件
    private void setLinkClickable(final SpannableStringBuilder clickableHtmlBuilder, final URLSpan urlSpan) {
        int start = clickableHtmlBuilder.getSpanStart(urlSpan);
        int end = clickableHtmlBuilder.getSpanEnd(urlSpan);
        int flags = clickableHtmlBuilder.getSpanFlags(urlSpan);
        ClickableSpan clickableSpan = new ClickableSpan() {
            public void onClick(View view) {
                String url = urlSpan.getURL();
                Toast.makeText(UserRecordAc.this,url,Toast.LENGTH_SHORT).show();
                System.out.println(url);
            }
        };
        clickableHtmlBuilder.setSpan(clickableSpan, start, end, flags);
    }

    //解析富文本 A标记
    private CharSequence getClickableHtml(String html) {
        Spanned spannedHtml = Html.fromHtml(html);
        SpannableStringBuilder clickableHtmlBuilder = new SpannableStringBuilder(spannedHtml);
        URLSpan[] urls = clickableHtmlBuilder.getSpans(0, spannedHtml.length(), URLSpan.class);
        for (final URLSpan span : urls) {
            setLinkClickable(clickableHtmlBuilder, span);
        }
        return clickableHtmlBuilder;
    }
    */
}
