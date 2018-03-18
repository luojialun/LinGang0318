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

public class TunityResultAc_ViewBinding implements Unbinder {
  private TunityResultAc target;

  private View view2131690032;

  private View view2131690015;

  @UiThread
  public TunityResultAc_ViewBinding(TunityResultAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TunityResultAc_ViewBinding(final TunityResultAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_look, "method 'onViewClicked'");
    view2131690032 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_next, "method 'onViewClicked'");
    view2131690015 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131690032.setOnClickListener(null);
    view2131690032 = null;
    view2131690015.setOnClickListener(null);
    view2131690015 = null;
  }
}
