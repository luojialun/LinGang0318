// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home.search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lingang.R;
import com.lingang.view.ClearableEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeSearchResultActivity_ViewBinding implements Unbinder {
  private HomeSearchResultActivity target;

  private View view2131689771;

  @UiThread
  public HomeSearchResultActivity_ViewBinding(HomeSearchResultActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeSearchResultActivity_ViewBinding(final HomeSearchResultActivity target, View source) {
    this.target = target;

    View view;
    target.searchResultSTL = Utils.findRequiredViewAsType(source, R.id.search_result_stl, "field 'searchResultSTL'", SlidingTabLayout.class);
    target.searchResultViewpager = Utils.findRequiredViewAsType(source, R.id.search_result_viewpager, "field 'searchResultViewpager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.home_search_result_left_back_iv, "field 'homeSearchResultLeftBackIv' and method 'leftBack'");
    target.homeSearchResultLeftBackIv = Utils.castView(view, R.id.home_search_result_left_back_iv, "field 'homeSearchResultLeftBackIv'", ImageView.class);
    view2131689771 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftBack(p0);
      }
    });
    target.homeSearchResultInputEt = Utils.findRequiredViewAsType(source, R.id.home_search_result_input_et, "field 'homeSearchResultInputEt'", ClearableEditText.class);
    target.searchAllToolbarRl = Utils.findRequiredViewAsType(source, R.id.search_all_toolbar_rl, "field 'searchAllToolbarRl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeSearchResultActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.searchResultSTL = null;
    target.searchResultViewpager = null;
    target.homeSearchResultLeftBackIv = null;
    target.homeSearchResultInputEt = null;
    target.searchAllToolbarRl = null;

    view2131689771.setOnClickListener(null);
    view2131689771 = null;
  }
}
