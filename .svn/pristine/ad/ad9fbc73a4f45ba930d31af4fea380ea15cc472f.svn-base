package com.lingang.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.lingang.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @name MyApplication
 * @class name：lingang.com.myapplication
 * @class describe
 * @anthor Administrator
 * @time 2017/8/7 0007 15:52
 * @change
 * @chang time
 * @class describe
 */
public class AlignTextView extends View {
    private TextPaint paint;
    private int width;
    private int height;
    private int linesNum;
    private int lineWordsNum;
    private int singWordsWith;
    private char[] chars;
    private int maxLines;
    private boolean isColon;
    private float lineSpacingExtra;
    private float aFloat;
    private String content;

    public AlignTextView(Context context) {
        this(context, null);
    }

    public AlignTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AlignTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new TextPaint();
        //获取自定义属性的值
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.alignText);
        int color = array.getColor(R.styleable.alignText_tvColor, Color.BLACK);
        lineSpacingExtra = array.getDimension(R.styleable.alignText_lineSpacingExtra, 0f);
        maxLines = array.getInteger(R.styleable.alignText_maxLines, 0);
        float tvSize = array.getDimension(R.styleable.alignText_tvSize, 18f);
        isColon = array.getBoolean(R.styleable.alignText_isColon, false);
        content = array.getString(R.styleable.alignText_content);
        array.recycle();

        paint.setColor(color);
        paint.setTextSize(tvSize);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY)//明确的值或者是MATCH_PARENT
        {
            width = widthSize;
        } else {
            width = widthSize;
        }

        if (!TextUtils.isEmpty(content)) {
            drawPlan(content);
        }

        if (maxLines != 0) {
            countHeight(maxLines);
        } else {
            countHeight(linesNum);
        }

        if (TextUtils.isEmpty(content)) {
            height = 0;
        }
        setMeasuredDimension(width, height);

    }

    /**
     * 计算高度
     */
    private void countHeight(int num) {
        if (num % 2 == 0) {
            height = (int) (num * singWordsWith + (num + 1) / 2 * lineSpacingExtra + lineSpacingExtra / 2)+10;
        } else {
            height = (int) (num * singWordsWith + (num + 1) / 2 * lineSpacingExtra)+10;
        }

    }

    private void drawPlan(CharSequence cs) {
        //单个文字的宽度
        singWordsWith = (int) paint.measureText("一");
        //一行显示多少个文字
        lineWordsNum = width / singWordsWith;
        //获取字符数组
        chars = StringFilter(cs.toString()).toCharArray();
        //获取字符显示的行数
        if (chars.length < lineWordsNum) {
            linesNum = 1;
        } else {
            float num = chars.length / lineWordsNum;
            if (chars.length % lineWordsNum == 0){
                linesNum = (int) num;
            }else {
                linesNum = (int) num + 1;
            }

        }
        if (linesNum < maxLines){
            maxLines = linesNum;
            isColon = false;
        }
        //计算一行文字是否可以填充满view的宽度
        float withOffset = width - paint.measureText("一") * lineWordsNum;
        if (withOffset >= 0) {
            aFloat = withOffset / (lineWordsNum + 1);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int wordIndex = 0;
        for (int i = 1; i < linesNum + 1; i++) {//哪一行
            for (int j = 0; j < lineWordsNum; j++) {//每行的第几个字节
                if (wordIndex < chars.length) {
                    if (isColon) {//末尾是否以。。。结束
                        if (maxLines == 1) { //最大行数是1
                            if (drawTextMode(canvas, wordIndex, maxLines, j)) return;
                        } else {//最大行数不是1
                            if (drawTextMode(canvas, wordIndex, i, j)) return;
                        }
                    } else {
                        canvas.drawText(String.valueOf(chars[wordIndex]),
                                j * (singWordsWith + aFloat),
                                i * (singWordsWith + lineSpacingExtra / 2),
                                paint);

                    }
                }
                wordIndex++;
            }
        }
    }

    /**
     * 绘画方式
     */
    private boolean drawTextMode(Canvas canvas, int wordIndex, int i, int j) {
        if (i == maxLines && j == lineWordsNum - 1) {//最后一行  最后一个字符
            canvas.drawText("...",
                    j * (singWordsWith + aFloat),
                    i * (singWordsWith + lineSpacingExtra / 2), paint);
            return true;
        } else {
            canvas.drawText(String.valueOf(chars[wordIndex]),
                    j * (singWordsWith + aFloat),
                    i * (singWordsWith + lineSpacingExtra / 2), paint);
        }
        return false;
    }

    /**
     * 判断是否为中文
     *
     * @return
     */
    private static boolean containChinese(String string) {
        boolean flag = false;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ((c >= 0x4e00) && (c <= 0x9FA5)) {
                flag = true;
            }
        }
        return flag;
    }

    // 替换、过滤特殊字符
    private String StringFilter(String str) throws PatternSyntaxException {
        str = str.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!").replace("\n","");//替换中文标号
        String regEx = "[『』]"; // 清除掉特殊字符
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public int getLinesNum() {
        return linesNum;
    }

    public void setMaxLines(int maxLines) {
        if (maxLines == linesNum || linesNum < maxLines){//要是设置的最大行数为内容的最大行数  则取消。。。
            isColon = false;
        }else {
            isColon = true;
        }

        if (linesNum < maxLines){
            this.maxLines = linesNum;
        }else {
            this.maxLines = maxLines;
        }

        requestLayout();
        invalidate();
    }

    public int getMaxLines() {
        return maxLines;
    }

    /**
     * 设置内容
     */
    public void setContent(CharSequence cs) {
        if (!TextUtils.isEmpty(cs)) {
            content = cs.toString();
            requestLayout();
            invalidate();
        }
    }
}
