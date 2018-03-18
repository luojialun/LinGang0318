// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SuppiyAc_ViewBinding implements Unbinder {
  private SuppiyAc target;

  @UiThread
  public SuppiyAc_ViewBinding(SuppiyAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SuppiyAc_ViewBinding(SuppiyAc target, View source) {
    this.target = target;

    target.etSuppiy = Utils.findRequiredViewAsType(source, R.id.et_suppiy, "field 'etSuppiy'", EditText.class);
    target.tvNum = Utils.findRequiredViewAsType(source, R.id.tv_num, "field 'tvNum'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SuppiyAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etSuppiy = null;
    target.tvNum = null;
  }
}
