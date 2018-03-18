// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NeedAc_ViewBinding implements Unbinder {
  private NeedAc target;

  @UiThread
  public NeedAc_ViewBinding(NeedAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NeedAc_ViewBinding(NeedAc target, View source) {
    this.target = target;

    target.needCategoryStl = Utils.findRequiredViewAsType(source, R.id.need_category_stl, "field 'needCategoryStl'", SlidingTabLayout.class);
    target.needCategoryViewPager = Utils.findRequiredViewAsType(source, R.id.need_category_viewPager, "field 'needCategoryViewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NeedAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.needCategoryStl = null;
    target.needCategoryViewPager = null;
  }
}
