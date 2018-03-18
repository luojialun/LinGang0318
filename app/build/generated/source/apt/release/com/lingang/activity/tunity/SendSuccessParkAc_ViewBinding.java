// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SendSuccessParkAc_ViewBinding implements Unbinder {
  private SendSuccessParkAc target;

  private View view2131689959;

  @UiThread
  public SendSuccessParkAc_ViewBinding(SendSuccessParkAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SendSuccessParkAc_ViewBinding(final SendSuccessParkAc target, View source) {
    this.target = target;

    View view;
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.tvSusend = Utils.findRequiredViewAsType(source, R.id.tv_susend, "field 'tvSusend'", TextView.class);
    target.tvTs = Utils.findRequiredViewAsType(source, R.id.tv_ts, "field 'tvTs'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_succ_park, "method 'onViewClicked'");
    view2131689959 = view;
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
    SendSuccessParkAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerview = null;
    target.tvSusend = null;
    target.tvTs = null;

    view2131689959.setOnClickListener(null);
    view2131689959 = null;
  }
}
