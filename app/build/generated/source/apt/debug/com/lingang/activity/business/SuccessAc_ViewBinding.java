// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

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

public class SuccessAc_ViewBinding implements Unbinder {
  private SuccessAc target;

  private View view2131689998;

  @UiThread
  public SuccessAc_ViewBinding(SuccessAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SuccessAc_ViewBinding(final SuccessAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.submit, "field 'submit' and method 'onViewClicked'");
    target.submit = Utils.castView(view, R.id.submit, "field 'submit'", TextView.class);
    view2131689998 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SuccessAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.submit = null;

    view2131689998.setOnClickListener(null);
    view2131689998 = null;
  }
}
