// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WeekPlanAc_ViewBinding implements Unbinder {
  private WeekPlanAc target;

  private View view2131690524;

  private View view2131689676;

  @UiThread
  public WeekPlanAc_ViewBinding(WeekPlanAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WeekPlanAc_ViewBinding(final WeekPlanAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.left_btn, "field 'leftBtn' and method 'onViewClicked'");
    target.leftBtn = Utils.castView(view, R.id.left_btn, "field 'leftBtn'", ImageView.class);
    view2131690524 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.titleRbleft = Utils.findRequiredViewAsType(source, R.id.title_rbleft, "field 'titleRbleft'", RadioButton.class);
    target.titleRbright = Utils.findRequiredViewAsType(source, R.id.title_rbright, "field 'titleRbright'", RadioButton.class);
    target.titleRg = Utils.findRequiredViewAsType(source, R.id.title_rg, "field 'titleRg'", RadioGroup.class);
    target.tvTagWeek = Utils.findRequiredViewAsType(source, R.id.tv_tag_week, "field 'tvTagWeek'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_tag, "field 'llTag' and method 'onViewClicked'");
    target.llTag = Utils.castView(view, R.id.ll_tag, "field 'llTag'", LinearLayout.class);
    view2131689676 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tabWeek = Utils.findRequiredViewAsType(source, R.id.tb_week, "field 'tabWeek'", TabLayout.class);
    target.fmWeek = Utils.findRequiredViewAsType(source, R.id.fm_week, "field 'fmWeek'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WeekPlanAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.leftBtn = null;
    target.titleRbleft = null;
    target.titleRbright = null;
    target.titleRg = null;
    target.tvTagWeek = null;
    target.llTag = null;
    target.tabWeek = null;
    target.fmWeek = null;

    view2131690524.setOnClickListener(null);
    view2131690524 = null;
    view2131689676.setOnClickListener(null);
    view2131689676 = null;
  }
}
