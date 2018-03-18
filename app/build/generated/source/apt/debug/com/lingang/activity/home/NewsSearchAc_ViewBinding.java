// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lingang.R;
import com.lingang.view.ClearableEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsSearchAc_ViewBinding implements Unbinder {
  private NewsSearchAc target;

  private View view2131690580;

  @UiThread
  public NewsSearchAc_ViewBinding(NewsSearchAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NewsSearchAc_ViewBinding(final NewsSearchAc target, View source) {
    this.target = target;

    View view;
    target.newsCategoryStl = Utils.findRequiredViewAsType(source, R.id.news_search_category_stl, "field 'newsCategoryStl'", SlidingTabLayout.class);
    target.newsCategoryViewPager = Utils.findRequiredViewAsType(source, R.id.news_search_category_viewPager, "field 'newsCategoryViewPager'", ViewPager.class);
    target.searchInputEd = Utils.findRequiredViewAsType(source, R.id.search_input_ed, "field 'searchInputEd'", ClearableEditText.class);
    view = Utils.findRequiredView(source, R.id.search_cancel, "field 'searchCancel' and method 'onClick'");
    target.searchCancel = Utils.castView(view, R.id.search_cancel, "field 'searchCancel'", TextView.class);
    view2131690580 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.searchToolbar = Utils.findRequiredViewAsType(source, R.id.search_toolbar, "field 'searchToolbar'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsSearchAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.newsCategoryStl = null;
    target.newsCategoryViewPager = null;
    target.searchInputEd = null;
    target.searchCancel = null;
    target.searchToolbar = null;

    view2131690580.setOnClickListener(null);
    view2131690580 = null;
  }
}
