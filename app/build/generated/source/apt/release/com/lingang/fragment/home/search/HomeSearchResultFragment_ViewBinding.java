// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home.search;

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

public class HomeSearchResultFragment_ViewBinding implements Unbinder {
  private HomeSearchResultFragment target;

  @UiThread
  public HomeSearchResultFragment_ViewBinding(HomeSearchResultFragment target, View source) {
    this.target = target;

    target.searchResultSTL = Utils.findRequiredViewAsType(source, R.id.search_result_stl, "field 'searchResultSTL'", SlidingTabLayout.class);
    target.searchResultViewpager = Utils.findRequiredViewAsType(source, R.id.search_result_viewpager, "field 'searchResultViewpager'", ViewPager.class);
    target.emptyLl = Utils.findRequiredViewAsType(source, R.id.empty_ll, "field 'emptyLl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeSearchResultFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.searchResultSTL = null;
    target.searchResultViewpager = null;
    target.emptyLl = null;
  }
}
