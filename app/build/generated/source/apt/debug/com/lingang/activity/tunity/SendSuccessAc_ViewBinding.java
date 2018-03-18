// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SendSuccessAc_ViewBinding implements Unbinder {
  private SendSuccessAc target;

  private View view2131689955;

  @UiThread
  public SendSuccessAc_ViewBinding(SendSuccessAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SendSuccessAc_ViewBinding(final SendSuccessAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_succ, "method 'onViewClicked'");
    view2131689955 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131689955.setOnClickListener(null);
    view2131689955 = null;
  }
}
