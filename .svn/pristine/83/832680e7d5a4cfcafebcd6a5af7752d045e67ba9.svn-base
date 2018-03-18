package com.lingang.activity.business;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseAc;

import butterknife.BindView;

public class ReasonsAc extends BaseAc implements RadioGroup.OnCheckedChangeListener,TextWatcher {

    @BindView(R.id.rg_reasons)
    RadioGroup rgReasons;
    @BindView(R.id.et_suppiy)
    EditText etSuppiy;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.ll_et)
    LinearLayout llEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_reasons);
        setTitle("撤回原因");
        rgReasons.check(R.id.rb1);
        rgReasons.setOnCheckedChangeListener(this);
        etSuppiy.addTextChangedListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rb4) {
            llEt.setVisibility(View.VISIBLE);
        } else {
            llEt.setVisibility(View.GONE);
        }

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        tvNum.setText(charSequence.length()+"/300");
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
