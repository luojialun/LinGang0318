// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TransferAc_ViewBinding implements Unbinder {
  private TransferAc target;

  @UiThread
  public TransferAc_ViewBinding(TransferAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TransferAc_ViewBinding(TransferAc target, View source) {
    this.target = target;

    target.userRv = Utils.findRequiredViewAsType(source, R.id.user_rv, "field 'userRv'", RecyclerView.class);
    target.typeTv = Utils.findRequiredViewAsType(source, R.id.type_tv, "field 'typeTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TransferAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.userRv = null;
    target.typeTv = null;
  }
}
