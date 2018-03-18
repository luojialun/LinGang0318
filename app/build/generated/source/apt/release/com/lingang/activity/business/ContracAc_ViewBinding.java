// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContracAc_ViewBinding implements Unbinder {
  private ContracAc target;

  private View view2131689686;

  private View view2131689688;

  private View view2131689687;

  private View view2131689689;

  private View view2131689690;

  private View view2131689692;

  @UiThread
  public ContracAc_ViewBinding(ContracAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContracAc_ViewBinding(final ContracAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_fengm, "field 'btnFengm' and method 'onViewClicked'");
    target.btnFengm = Utils.castView(view, R.id.btn_fengm, "field 'btnFengm'", ImageView.class);
    view2131689686 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_qianz, "field 'btnQianz' and method 'onViewClicked'");
    target.btnQianz = Utils.castView(view, R.id.btn_qianz, "field 'btnQianz'", ImageView.class);
    view2131689688 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.shanc1, "field 'shanc1' and method 'onViewClicked'");
    target.shanc1 = Utils.castView(view, R.id.shanc1, "field 'shanc1'", ImageView.class);
    view2131689687 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.shanc2, "field 'shanc2' and method 'onViewClicked'");
    target.shanc2 = Utils.castView(view, R.id.shanc2, "field 'shanc2'", ImageView.class);
    view2131689689 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvLd = Utils.findRequiredViewAsType(source, R.id.tv_ld, "field 'tvLd'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_luodi, "field 'llLuodi' and method 'onViewClicked'");
    target.llLuodi = Utils.castView(view, R.id.ll_luodi, "field 'llLuodi'", LinearLayout.class);
    view2131689690 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_name, "field 'llName' and method 'onViewClicked'");
    target.llName = Utils.castView(view, R.id.ll_name, "field 'llName'", LinearLayout.class);
    view2131689692 = view;
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
    ContracAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnFengm = null;
    target.btnQianz = null;
    target.shanc1 = null;
    target.shanc2 = null;
    target.tvLd = null;
    target.llLuodi = null;
    target.tvName = null;
    target.llName = null;

    view2131689686.setOnClickListener(null);
    view2131689686 = null;
    view2131689688.setOnClickListener(null);
    view2131689688 = null;
    view2131689687.setOnClickListener(null);
    view2131689687 = null;
    view2131689689.setOnClickListener(null);
    view2131689689 = null;
    view2131689690.setOnClickListener(null);
    view2131689690 = null;
    view2131689692.setOnClickListener(null);
    view2131689692 = null;
  }
}
