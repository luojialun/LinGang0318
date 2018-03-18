// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReasonsAc_ViewBinding implements Unbinder {
  private ReasonsAc target;

  @UiThread
  public ReasonsAc_ViewBinding(ReasonsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReasonsAc_ViewBinding(ReasonsAc target, View source) {
    this.target = target;

    target.rgReasons = Utils.findRequiredViewAsType(source, R.id.rg_reasons, "field 'rgReasons'", RadioGroup.class);
    target.etSuppiy = Utils.findRequiredViewAsType(source, R.id.et_suppiy, "field 'etSuppiy'", EditText.class);
    target.tvNum = Utils.findRequiredViewAsType(source, R.id.tv_num, "field 'tvNum'", TextView.class);
    target.llEt = Utils.findRequiredViewAsType(source, R.id.ll_et, "field 'llEt'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReasonsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rgReasons = null;
    target.etSuppiy = null;
    target.tvNum = null;
    target.llEt = null;
  }
}
