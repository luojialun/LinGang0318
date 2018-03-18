// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NeedBusinessReviewAc_ViewBinding implements Unbinder {
  private NeedBusinessReviewAc target;

  private View view2131689830;

  @UiThread
  public NeedBusinessReviewAc_ViewBinding(NeedBusinessReviewAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NeedBusinessReviewAc_ViewBinding(final NeedBusinessReviewAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.need_bus_submit_btn, "field 'needBusSubmitBtn' and method 'onViewClicked'");
    target.needBusSubmitBtn = Utils.castView(view, R.id.need_bus_submit_btn, "field 'needBusSubmitBtn'", Button.class);
    view2131689830 = view;
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
    NeedBusinessReviewAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.needBusSubmitBtn = null;

    view2131689830.setOnClickListener(null);
    view2131689830 = null;
  }
}
