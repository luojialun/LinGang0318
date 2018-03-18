// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PolicyListAc_ViewBinding implements Unbinder {
  private PolicyListAc target;

  @UiThread
  public PolicyListAc_ViewBinding(PolicyListAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PolicyListAc_ViewBinding(PolicyListAc target, View source) {
    this.target = target;

    target.tbPolicy = Utils.findRequiredViewAsType(source, R.id.tb_policy, "field 'tbPolicy'", TabLayout.class);
    target.vpPolicy = Utils.findRequiredViewAsType(source, R.id.vp_policy, "field 'vpPolicy'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PolicyListAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tbPolicy = null;
    target.vpPolicy = null;
  }
}
