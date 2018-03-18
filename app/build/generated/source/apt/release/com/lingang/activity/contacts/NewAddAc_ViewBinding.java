// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.contacts;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewAddAc_ViewBinding implements Unbinder {
  private NewAddAc target;

  @UiThread
  public NewAddAc_ViewBinding(NewAddAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NewAddAc_ViewBinding(NewAddAc target, View source) {
    this.target = target;

    target.tbNew = Utils.findRequiredViewAsType(source, R.id.tb_new, "field 'tbNew'", TabLayout.class);
    target.vpNew = Utils.findRequiredViewAsType(source, R.id.vp_new, "field 'vpNew'", ViewPager.class);
    target.flEntry = Utils.findRequiredViewAsType(source, R.id.fl_entry, "field 'flEntry'", FrameLayout.class);
    target.llNewadd = Utils.findRequiredViewAsType(source, R.id.ll_newadd, "field 'llNewadd'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewAddAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tbNew = null;
    target.vpNew = null;
    target.flEntry = null;
    target.llNewadd = null;
  }
}
