// Generated code from Butter Knife. Do not modify!
package com.lingang.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mainActivityFragmentContainer = Utils.findRequiredViewAsType(source, R.id.main_activity_fragment_container, "field 'mainActivityFragmentContainer'", FrameLayout.class);
    target.rbMenuHome = Utils.findRequiredViewAsType(source, R.id.rb_menu_home, "field 'rbMenuHome'", RadioButton.class);
    target.rbMenuQuery = Utils.findRequiredViewAsType(source, R.id.rb_menu_query, "field 'rbMenuQuery'", RadioButton.class);
    target.rbMenuStatistics = Utils.findRequiredViewAsType(source, R.id.rb_menu_statistics, "field 'rbMenuStatistics'", RadioButton.class);
    target.rbMenuMine = Utils.findRequiredViewAsType(source, R.id.rb_menu_mine, "field 'rbMenuMine'", RadioButton.class);
    target.mainBottomNavigationRg = Utils.findRequiredViewAsType(source, R.id.main_bottom_navigation_rg, "field 'mainBottomNavigationRg'", RadioGroup.class);
    target.rgRl = Utils.findRequiredViewAsType(source, R.id.rg_rl, "field 'rgRl'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mainActivityFragmentContainer = null;
    target.rbMenuHome = null;
    target.rbMenuQuery = null;
    target.rbMenuStatistics = null;
    target.rbMenuMine = null;
    target.mainBottomNavigationRg = null;
    target.rgRl = null;
  }
}
