// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lingang.R;
import com.lingang.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserFavoritesAc_ViewBinding implements Unbinder {
  private UserFavoritesAc target;

  @UiThread
  public UserFavoritesAc_ViewBinding(UserFavoritesAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserFavoritesAc_ViewBinding(UserFavoritesAc target, View source) {
    this.target = target;

    target.favoritesStl = Utils.findRequiredViewAsType(source, R.id.favorites_stl, "field 'favoritesStl'", SlidingTabLayout.class);
    target.favoritesViewpager = Utils.findRequiredViewAsType(source, R.id.favorites_viewpager, "field 'favoritesViewpager'", NoScrollViewPager.class);
    target.errorFl = Utils.findRequiredViewAsType(source, R.id.error_fl, "field 'errorFl'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserFavoritesAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.favoritesStl = null;
    target.favoritesViewpager = null;
    target.errorFl = null;
  }
}
