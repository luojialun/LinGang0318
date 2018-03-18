package com.lingang.activity.business;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.dialog.CancelDialog;
import com.lingang.dialog.DialogTwo;
import com.lingang.utils.ToastUtils;
import com.lingang.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import me.next.tagview.TagCloudView;

public class ClaimDetailesAc extends BaseAc implements DialogConfirmListion {

    @BindView(R.id.tf_detailes)
    TagCloudView tfDetailes;
    @BindView(R.id.btn_refuse)
    Button btnRefuse;
    @BindView(R.id.btn_claim)
    Button btnClaim;
    private DialogTwo dialogTwo;
    private CancelDialog cancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_claim_detailes);
        setTitle("商机详情");
        int tagV = getIntent().getIntExtra("tag", 0);
        if (tagV == 0) {
            btnRefuse.setVisibility(View.GONE);
        } else {
            btnRefuse.setVisibility(View.VISIBLE);
        }

        dialogTwo = new DialogTwo(this, this);
        cancelDialog = new CancelDialog(this, this);

        ArrayList<String> classList = new ArrayList<>();
        classList.add("注册企业");
        classList.add("租住场地");
        classList.add("购买土地");
        tfDetailes.setTags(classList);
    }

    @Override
    public void confirmClick(String sign) {
        if (sign.equals("cancel_dialog")) {

        } else if (sign.equals("two_dialog")) {

        }
        ToastUtils.showToast(this, sign);
    }

    @OnClick({R.id.btn_refuse, R.id.btn_claim})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_refuse:
                cancelDialog.show();
                break;
            case R.id.btn_claim:
                dialogTwo.show("认领商机", "认领此商机后，商机计入招商系统，请确认认领");
                break;
        }
    }
}
