package com.lingang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.lingang.R;

/**
 * Created by jason on 17/5/24.
 * 排行榜弹出框
 */

public class RankingRulesDialog extends Dialog {
    public RankingRulesDialog(@NonNull Context context) {
        super(context, R.style.dialog_style);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_ranking_rules_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }
}
