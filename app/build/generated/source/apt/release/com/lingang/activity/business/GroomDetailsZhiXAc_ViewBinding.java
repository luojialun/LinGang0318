// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ExtraListView;
import com.lingang.view.flowlayout.TagFlowLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GroomDetailsZhiXAc_ViewBinding implements Unbinder {
  private GroomDetailsZhiXAc target;

  private View view2131689755;

  private View view2131689757;

  @UiThread
  public GroomDetailsZhiXAc_ViewBinding(GroomDetailsZhiXAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GroomDetailsZhiXAc_ViewBinding(final GroomDetailsZhiXAc target, View source) {
    this.target = target;

    View view;
    target.tfDetailes = Utils.findRequiredViewAsType(source, R.id.tf_detailes, "field 'tfDetailes'", TagFlowLayout.class);
    target.lvImg = Utils.findRequiredViewAsType(source, R.id.lv_img, "field 'lvImg'", ExtraListView.class);
    target.lvExplain = Utils.findRequiredViewAsType(source, R.id.lv_explain, "field 'lvExplain'", ExtraListView.class);
    view = Utils.findRequiredView(source, R.id.tv_sex, "field 'tvSex' and method 'onViewClicked'");
    target.tvSex = Utils.castView(view, R.id.tv_sex, "field 'tvSex'", TextView.class);
    view2131689755 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llTjTime = Utils.findRequiredViewAsType(source, R.id.ll_tj_time, "field 'llTjTime'", LinearLayout.class);
    target.tvState = Utils.findRequiredViewAsType(source, R.id.tv_state, "field 'tvState'", TextView.class);
    target.llRlTime = Utils.findRequiredViewAsType(source, R.id.ll_rl_time, "field 'llRlTime'", LinearLayout.class);
    target.llZxTime = Utils.findRequiredViewAsType(source, R.id.ll_zx_time, "field 'llZxTime'", LinearLayout.class);
    target.tfTj = Utils.findRequiredViewAsType(source, R.id.tf_tj, "field 'tfTj'", TagFlowLayout.class);
    target.sjRlTime = Utils.findRequiredViewAsType(source, R.id.sj_rl_time, "field 'sjRlTime'", TextView.class);
    target.llPerson = Utils.findRequiredViewAsType(source, R.id.ll_person, "field 'llPerson'", LinearLayout.class);
    target.llSjRlTime = Utils.findRequiredViewAsType(source, R.id.ll_sj_rl_time, "field 'llSjRlTime'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ll_zs_person, "field 'llZsPerson' and method 'onViewClicked'");
    target.llZsPerson = Utils.castView(view, R.id.ll_zs_person, "field 'llZsPerson'", LinearLayout.class);
    view2131689757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.sjJl = Utils.findRequiredViewAsType(source, R.id.sj_jl, "field 'sjJl'", TextView.class);
    target.lvJil = Utils.findRequiredViewAsType(source, R.id.lv_jil, "field 'lvJil'", ExtraListView.class);
    target.tvSjtj = Utils.findRequiredViewAsType(source, R.id.tv_sjtj, "field 'tvSjtj'", TextView.class);
    target.chsm = Utils.findRequiredViewAsType(source, R.id.chsm, "field 'chsm'", TextView.class);
    target.tvChsm = Utils.findRequiredViewAsType(source, R.id.tv_chsm, "field 'tvChsm'", TextView.class);
    target.llLdTime = Utils.findRequiredViewAsType(source, R.id.ll_ld_time, "field 'llLdTime'", LinearLayout.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.tvTimeData = Utils.findRequiredViewAsType(source, R.id.tv_time_data, "field 'tvTimeData'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GroomDetailsZhiXAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tfDetailes = null;
    target.lvImg = null;
    target.lvExplain = null;
    target.tvSex = null;
    target.llTjTime = null;
    target.tvState = null;
    target.llRlTime = null;
    target.llZxTime = null;
    target.tfTj = null;
    target.sjRlTime = null;
    target.llPerson = null;
    target.llSjRlTime = null;
    target.llZsPerson = null;
    target.sjJl = null;
    target.lvJil = null;
    target.tvSjtj = null;
    target.chsm = null;
    target.tvChsm = null;
    target.llLdTime = null;
    target.tvTime = null;
    target.tvTimeData = null;

    view2131689755.setOnClickListener(null);
    view2131689755 = null;
    view2131689757.setOnClickListener(null);
    view2131689757 = null;
  }
}
