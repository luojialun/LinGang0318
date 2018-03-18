// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserRecordAc_ViewBinding implements Unbinder {
  private UserRecordAc target;

  @UiThread
  public UserRecordAc_ViewBinding(UserRecordAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserRecordAc_ViewBinding(UserRecordAc target, View source) {
    this.target = target;

    target.favoritesStl = Utils.findRequiredViewAsType(source, R.id.favorites_stl, "field 'favoritesStl'", SlidingTabLayout.class);
    target.favoritesViewpager = Utils.findRequiredViewAsType(source, R.id.favorites_viewpager, "field 'favoritesViewpager'", ViewPager.class);
    target.errorLl = Utils.findRequiredViewAsType(source, R.id.error_ll, "field 'errorLl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserRecordAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.favoritesStl = null;
    target.favoritesViewpager = null;
    target.errorLl = null;
  }
}
