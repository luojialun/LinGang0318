package com.lingang.activity.business;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseAc;

import butterknife.BindView;

public class SuppiyAc extends BaseAc implements TextWatcher {

    @BindView(R.id.et_suppiy)
    EditText etSuppiy;
    @BindView(R.id.tv_num)
    TextView tvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_suppiy_ac);

        String tag = getIntent().getStringExtra("tag");
        if (tag.equals("shangji")) {
            setTitle("商机补充说明");
        } else if (tag.equals("zhix")) {
            setTitle("添加执行记录");
        } else {
            setTitle("需求补充说明");
        }

        etSuppiy.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        tvNum.setText(charSequence.length() + "/300");
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
