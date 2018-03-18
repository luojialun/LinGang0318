package com.lingang.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.OppHistory;
import com.lingang.utils.DateUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by jason on 17/8/21.
 *商机详情-时间轴
 */
public class OppDetailsAdapter extends RecycleBaseAdapter<OppHistory> {
    //标题html
    private String titleHtml="%1$s<font color='#00ffff'><a href='%2$s' style='color:#00ffff;display:block;'>%3$s</a></font>%4$s";
    private Context context;
    public OppDetailsAdapter(Context context, List<OppHistory> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, OppHistory item, int position) {

        List<OppHistory.TitleEntity> titleList=item.getTitle();
        //标题
        if(titleList !=null && titleList.size()>0)
        {
            StringBuilder appStr=new StringBuilder();
            for (int i = 0; i < titleList.size(); i++) {
                appStr.append(String.format(titleHtml,
                        titleList.get(i).getPreUserName(),
                        titleList.get(i).getUserAccount(),
                        titleList.get(i).getUserName(),
                        titleList.get(i).getPostUserName()));
            }
            TextView timedName=holder.getView(R.id.opportunity_timed_name);
            timedName.setText(getClickableHtml(appStr.toString()));
            Spannable span = new SpannableString("共有0条查询结果");
//            span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            timedName.setMovementMethod(LinkMovementMethod.getInstance());
        }
        //时间
        holder.setText(R.id.opportunity_time, DateUtils.getTimestamp(item.getTime(), "yyyy.MM.dd HH:mm"));
        if(item.getContent() !=null) {
            holder.setText(R.id.opportunity_result, item.getContent());
        }
        if(position == 0)
        {
            holder.getView(R.id.need_flow_line_start).setVisibility(View.INVISIBLE);
        }
        //最后一行隐藏时间线
        if(position==mData.size()-1) {
            holder.getView(R.id.need_flow_line).setVisibility(View.GONE);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, OppHistory item) {
        return R.layout.item_opportunity_timed;
    }

    //TextView富文本A事件
    private void setLinkClickable(final SpannableStringBuilder clickableHtmlBuilder, final URLSpan urlSpan) {
        int start = clickableHtmlBuilder.getSpanStart(urlSpan);
        int end = clickableHtmlBuilder.getSpanEnd(urlSpan);
        int flags = clickableHtmlBuilder.getSpanFlags(urlSpan);
        ClickableSpan clickableSpan = new ClickableSpan() {
            public void onClick(View view) {
                String url = urlSpan.getURL();
                //Toast.makeText(mContext,url,Toast.LENGTH_SHORT).show();
                mContext.startActivity(new Intent(mContext, PersonInfoActivity.class).putExtra("userid", url).putExtra("tag","bendi"));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(context.getResources().getColor(R.color.red));
                ds.setUnderlineText(false);
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

}
