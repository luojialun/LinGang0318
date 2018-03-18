// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PreviewAc_ViewBinding implements Unbinder {
  private PreviewAc target;

  private View view2131689744;

  private View view2131689936;

  @UiThread
  public PreviewAc_ViewBinding(PreviewAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PreviewAc_ViewBinding(final PreviewAc target, View source) {
    this.target = target;

    View view;
    target.tvKhname = Utils.findRequiredViewAsType(source, R.id.tv_khname, "field 'tvKhname'", TextView.class);
    target.tvKhcall = Utils.findRequiredViewAsType(source, R.id.tv_khcall, "field 'tvKhcall'", TextView.class);
    target.tvKhnexus = Utils.findRequiredViewAsType(source, R.id.tv_khnexus, "field 'tvKhnexus'", TextView.class);
    target.tvKhch = Utils.findRequiredViewAsType(source, R.id.tv_khch, "field 'tvKhch'", TextView.class);
    target.tvKhmails = Utils.findRequiredViewAsType(source, R.id.tv_khmails, "field 'tvKhmails'", TextView.class);
    target.tvQystate = Utils.findRequiredViewAsType(source, R.id.tv_qystate, "field 'tvQystate'", TextView.class);
    target.tvQyname = Utils.findRequiredViewAsType(source, R.id.tv_qyname, "field 'tvQyname'", TextView.class);
    target.tvQykey = Utils.findRequiredViewAsType(source, R.id.tv_qykey, "field 'tvQykey'", TextView.class);
    target.tvPlantld = Utils.findRequiredViewAsType(source, R.id.tv_plantld, "field 'tvPlantld'", TextView.class);
    target.tvPlantxq = Utils.findRequiredViewAsType(source, R.id.tv_plantxq, "field 'tvPlantxq'", TextView.class);
    target.tvPlantqw = Utils.findRequiredViewAsType(source, R.id.tv_plantqw, "field 'tvPlantqw'", TextView.class);
    target.tvLandmj = Utils.findRequiredViewAsType(source, R.id.tv_landmj, "field 'tvLandmj'", TextView.class);
    target.tvLandqw = Utils.findRequiredViewAsType(source, R.id.tv_landqw, "field 'tvLandqw'", TextView.class);
    target.tvLandxz = Utils.findRequiredViewAsType(source, R.id.tv_landxz, "field 'tvLandxz'", TextView.class);
    target.tvZhucqy = Utils.findRequiredViewAsType(source, R.id.tv_zhucqy, "field 'tvZhucqy'", TextView.class);
    target.tvZhuczj = Utils.findRequiredViewAsType(source, R.id.tv_zhuczj, "field 'tvZhuczj'", TextView.class);
    target.tvZhucsm = Utils.findRequiredViewAsType(source, R.id.tv_zhucsm, "field 'tvZhucsm'", TextView.class);
    target.tvTjyq = Utils.findRequiredViewAsType(source, R.id.tv_tjyq, "field 'tvTjyq'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_comit, "field 'btnComit' and method 'onViewClicked'");
    target.btnComit = Utils.castView(view, R.id.btn_comit, "field 'btnComit'", Button.class);
    view2131689744 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llCompany = Utils.findRequiredViewAsType(source, R.id.ll_company, "field 'llCompany'", LinearLayout.class);
    target.llPlan = Utils.findRequiredViewAsType(source, R.id.ll_plan, "field 'llPlan'", LinearLayout.class);
    target.tvWorkLd = Utils.findRequiredViewAsType(source, R.id.tv_work_ld, "field 'tvWorkLd'", TextView.class);
    target.tvWorkMj = Utils.findRequiredViewAsType(source, R.id.tv_work_mj, "field 'tvWorkMj'", TextView.class);
    target.tvWorkQw = Utils.findRequiredViewAsType(source, R.id.tv_work_qw, "field 'tvWorkQw'", TextView.class);
    target.llWork = Utils.findRequiredViewAsType(source, R.id.ll_work, "field 'llWork'", LinearLayout.class);
    target.llLand = Utils.findRequiredViewAsType(source, R.id.ll_land, "field 'llLand'", LinearLayout.class);
    target.llZhuc = Utils.findRequiredViewAsType(source, R.id.ll_zhuc, "field 'llZhuc'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_et, "method 'onViewClicked'");
    view2131689936 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PreviewAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvKhname = null;
    target.tvKhcall = null;
    target.tvKhnexus = null;
    target.tvKhch = null;
    target.tvKhmails = null;
    target.tvQystate = null;
    target.tvQyname = null;
    target.tvQykey = null;
    target.tvPlantld = null;
    target.tvPlantxq = null;
    target.tvPlantqw = null;
    target.tvLandmj = null;
    target.tvLandqw = null;
    target.tvLandxz = null;
    target.tvZhucqy = null;
    target.tvZhuczj = null;
    target.tvZhucsm = null;
    target.tvTjyq = null;
    target.btnComit = null;
    target.llCompany = null;
    target.llPlan = null;
    target.tvWorkLd = null;
    target.tvWorkMj = null;
    target.tvWorkQw = null;
    target.llWork = null;
    target.llLand = null;
    target.llZhuc = null;

    view2131689744.setOnClickListener(null);
    view2131689744 = null;
    view2131689936.setOnClickListener(null);
    view2131689936 = null;
  }
}
