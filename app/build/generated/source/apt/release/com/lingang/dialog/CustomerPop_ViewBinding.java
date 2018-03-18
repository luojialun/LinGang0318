// Generated code from Butter Knife. Do not modify!
package com.lingang.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerPop_ViewBinding implements Unbinder {
  private CustomerPop target;

  private View view2131690514;

  private View view2131690515;

  private View view2131690516;

  private View view2131690517;

  private View view2131690518;

  @UiThread
  public CustomerPop_ViewBinding(final CustomerPop target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.pop_all, "field 'popAll' and method 'onViewClicked'");
    target.popAll = Utils.castView(view, R.id.pop_all, "field 'popAll'", TextView.class);
    view2131690514 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.pop_rl, "field 'popRl' and method 'onViewClicked'");
    target.popRl = Utils.castView(view, R.id.pop_rl, "field 'popRl'", TextView.class);
    view2131690515 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.pop_zx, "field 'popZx' and method 'onViewClicked'");
    target.popZx = Utils.castView(view, R.id.pop_zx, "field 'popZx'", TextView.class);
    view2131690516 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.pop_ld, "field 'popLd' and method 'onViewClicked'");
    target.popLd = Utils.castView(view, R.id.pop_ld, "field 'popLd'", TextView.class);
    view2131690517 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.pop_ch, "field 'popCh' and method 'onViewClicked'");
    target.popCh = Utils.castView(view, R.id.pop_ch, "field 'popCh'", TextView.class);
    view2131690518 = view;
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
    CustomerPop target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.popAll = null;
    target.popRl = null;
    target.popZx = null;
    target.popLd = null;
    target.popCh = null;

    view2131690514.setOnClickListener(null);
    view2131690514 = null;
    view2131690515.setOnClickListener(null);
    view2131690515 = null;
    view2131690516.setOnClickListener(null);
    view2131690516 = null;
    view2131690517.setOnClickListener(null);
    view2131690517 = null;
    view2131690518.setOnClickListener(null);
    view2131690518 = null;
  }
}
