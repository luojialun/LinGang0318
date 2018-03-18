package com.lingang.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;


/**
 * SettingItem
 */
public class SettingItem extends LinearLayout {

    private TextView textTv;
    private ImageView leftIconIv;
    private ImageView arrowIv;
    private TextView rightTextTv;
    private View divider;

    public SettingItem(Context context) {
        this(context, null);
    }

    public SettingItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.item_setting, this);
        initView();
        initAttrs(context, attrs);
    }

    private void initView() {
        textTv = (TextView) findViewById(R.id.item_setting_text_tv);
        leftIconIv = (ImageView) findViewById(R.id.item_setting_icon_iv);
        arrowIv = (ImageView) findViewById(R.id.item_setting_arrow_iv);
        rightTextTv = (TextView) findViewById(R.id.item_setting_right_text_tv);
        divider = findViewById(R.id.item_setting_divider);

    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItem);
        final int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            initAttr(typedArray.getIndex(i), typedArray);
        }
        typedArray.recycle();
    }

    protected void initAttr(int attr, TypedArray typedArray) {
        switch (attr) {
            case R.styleable.SettingItem_leftdrawable:
                setLeftDrawable(typedArray.getDrawable(attr));
                break;
            case R.styleable.SettingItem_leftdrawablevisivle:
                showLeftDrawable(typedArray.getBoolean(attr, true));
                break;
            case R.styleable.SettingItem_itemText:
                setItemText(typedArray.getText(attr));
                break;
            case R.styleable.SettingItem_itemTextColor:
                setItemTextColor(typedArray.getColorStateList(attr));
                break;
            case R.styleable.SettingItem_itemTextSize:
                setItemTextSize(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 16)));
                break;
            case R.styleable.SettingItem_showdivider:
                showDivider(typedArray.getBoolean(attr, true));
                break;
            case R.styleable.SettingItem_showLeftDrawable:
                showLeftDrawable(typedArray.getInteger(attr, 0));
                break;
            case R.styleable.SettingItem_rightText:
                setRightText(typedArray.getText(attr));
                break;
            case R.styleable.SettingItem_rightTextSize:
                setRightTextSize(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 16)));
                break;
            case R.styleable.SettingItem_rightTextColor:
                setRightTextColor(typedArray.getColorStateList(attr));
                break;
            case R.styleable.SettingItem_showArrow:
                showArrow(typedArray.getInteger(attr, 0));
                break;
        }

    }

    private void showArrow(int value) {
        switch (value) {
            case 0:
                arrowIv.setVisibility(INVISIBLE);
                break;
            case 1:
                arrowIv.setVisibility(VISIBLE);
                break;
            case 2:
                arrowIv.setVisibility(GONE);
                break;
        }
    }


    private void showLeftDrawable(int value) {
        switch (value) {
            case 0:
                leftIconIv.setVisibility(INVISIBLE);
                break;
            case 1:
                leftIconIv.setVisibility(VISIBLE);
                break;
            case 2:
                leftIconIv.setVisibility(GONE);
                break;
        }
    }

    private void showDivider(boolean flag) {
        if (flag) {
            divider.setVisibility(View.VISIBLE);
        } else {
            divider.setVisibility(View.INVISIBLE);
        }
    }

    private void showLeftDrawable(boolean flag) {
        if (flag) {
            leftIconIv.setVisibility(View.VISIBLE);
        } else {
            leftIconIv.setVisibility(View.GONE);
        }
    }
    public void setLeftDrawable(Drawable drawable) {
        leftIconIv.setImageDrawable(drawable);
    }

    public void setItemText(CharSequence itemText) {
        textTv.setText(itemText);
    }

    public void setItemTextColor(ColorStateList itemTextColor) {
        textTv.setTextColor(itemTextColor);
    }


    public void setItemTextSize(int itemTextSize) {
        textTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, itemTextSize);
    }


    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }

    public void setRightText(CharSequence rightText) {
        if (rightTextTv.getVisibility() == View.INVISIBLE | rightTextTv.getVisibility() == View.GONE) {
            rightTextTv.setVisibility(View.VISIBLE);
        }
        rightTextTv.setText(rightText);
    }
    public void setRightTextSize(float itemTextSize) {
        rightTextTv.setTextSize(TypedValue.COMPLEX_UNIT_PX ,itemTextSize);
    }

    public void setRightTextColor(ColorStateList itemTextColor) {
        if (rightTextTv.getVisibility() == View.INVISIBLE | rightTextTv.getVisibility() == View.GONE) {
            rightTextTv.setVisibility(View.VISIBLE);
        }
        rightTextTv.setTextColor(itemTextColor);
    }

    public String getRightText() {
        return rightTextTv.getText().toString().trim();
    }
}
