// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NeedBusinessFragment_ViewBinding implements Unbinder {
  private NeedBusinessFragment target;

  @UiThread
  public NeedBusinessFragment_ViewBinding(NeedBusinessFragment target, View source) {
    this.target = target;

    target.needBusinessRefresh = Utils.findRequiredViewAsType(source, R.id.need_business_refresh, "field 'needBusinessRefresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NeedBusinessFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.needBusinessRefresh = null;
  }
}
