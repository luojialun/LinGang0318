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

public class NewsAc_ViewBinding implements Unbinder {
  private NewsAc target;

  @UiThread
  public NewsAc_ViewBinding(NewsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NewsAc_ViewBinding(NewsAc target, View source) {
    this.target = target;

    target.newsCategoryStl = Utils.findRequiredViewAsType(source, R.id.news_category_stl, "field 'newsCategoryStl'", SlidingTabLayout.class);
    target.newsCategoryViewPager = Utils.findRequiredViewAsType(source, R.id.news_category_viewPager, "field 'newsCategoryViewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.newsCategoryStl = null;
    target.newsCategoryViewPager = null;
  }
}
