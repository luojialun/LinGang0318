// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RlTunityDetailesAc_ViewBinding implements Unbinder {
  private RlTunityDetailesAc target;

  private View view2131689954;

  private View view2131689860;

  private View view2131689951;

  @UiThread
  public RlTunityDetailesAc_ViewBinding(RlTunityDetailesAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RlTunityDetailesAc_ViewBinding(final RlTunityDetailesAc target, View source) {
    this.target = target;

    View view;
    target.outdateTv = Utils.findRequiredViewAsType(source, R.id.outdate_tv, "field 'outdateTv'", TextView.class);
    target.tvPerclass = Utils.findRequiredViewAsType(source, R.id.tv_perclass, "field 'tvPerclass'", TextView.class);
    target.tvPer = Utils.findRequiredViewAsType(source, R.id.tv_per, "field 'tvPer'", TextView.class);
    target.tvData = Utils.findRequiredViewAsType(source, R.id.tv_data, "field 'tvData'", TextView.class);
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
    target.tvWorkLd = Utils.findRequiredViewAsType(source, R.id.tv_work_ld, "field 'tvWorkLd'", TextView.class);
    target.tvWorkMj = Utils.findRequiredViewAsType(source, R.id.tv_work_mj, "field 'tvWorkMj'", TextView.class);
    target.tvWorkQw = Utils.findRequiredViewAsType(source, R.id.tv_work_qw, "field 'tvWorkQw'", TextView.class);
    target.llCompany = Utils.findRequiredViewAsType(source, R.id.ll_company, "field 'llCompany'", LinearLayout.class);
    target.llWork = Utils.findRequiredViewAsType(source, R.id.ll_work, "field 'llWork'", LinearLayout.class);
    target.llPlan = Utils.findRequiredViewAsType(source, R.id.ll_plan, "field 'llPlan'", LinearLayout.class);
    target.llLand = Utils.findRequiredViewAsType(source, R.id.ll_land, "field 'llLand'", LinearLayout.class);
    target.llZhuc = Utils.findRequiredViewAsType(source, R.id.ll_zhuc, "field 'llZhuc'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_rl, "field 'btnRl' and method 'onViewClicked'");
    target.btnRl = Utils.castView(view, R.id.btn_rl, "field 'btnRl'", Button.class);
    view2131689954 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.opp_state_tab, "field 'oppStateTab' and method 'onViewClicked'");
    target.oppStateTab = Utils.castView(view, R.id.opp_state_tab, "field 'oppStateTab'", TextView.class);
    view2131689860 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.stateBtn = Utils.findRequiredViewAsType(source, R.id.state_btn, "field 'stateBtn'", TextView.class);
    target.flowDetailsRv = Utils.findRequiredViewAsType(source, R.id.flow_details_rv, "field 'flowDetailsRv'", RecyclerView.class);
    target.guijiRl = Utils.findRequiredViewAsType(source, R.id.guiji_rl, "field 'guijiRl'", RelativeLayout.class);
    target.llLc = Utils.findRequiredViewAsType(source, R.id.ll_lc, "field 'llLc'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ll_per, "field 'llPer' and method 'onViewClicked'");
    target.llPer = Utils.castView(view, R.id.ll_per, "field 'llPer'", LinearLayout.class);
    view2131689951 = view;
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
    RlTunityDetailesAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.outdateTv = null;
    target.tvPerclass = null;
    target.tvPer = null;
    target.tvData = null;
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
    target.tvWorkLd = null;
    target.tvWorkMj = null;
    target.tvWorkQw = null;
    target.llCompany = null;
    target.llWork = null;
    target.llPlan = null;
    target.llLand = null;
    target.llZhuc = null;
    target.btnRl = null;
    target.oppStateTab = null;
    target.stateBtn = null;
    target.flowDetailsRv = null;
    target.guijiRl = null;
    target.llLc = null;
    target.llPer = null;

    view2131689954.setOnClickListener(null);
    view2131689954 = null;
    view2131689860.setOnClickListener(null);
    view2131689860 = null;
    view2131689951.setOnClickListener(null);
    view2131689951 = null;
  }
}
