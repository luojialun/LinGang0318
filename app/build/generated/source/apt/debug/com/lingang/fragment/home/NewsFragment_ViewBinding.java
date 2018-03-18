// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsFragment_ViewBinding implements Unbinder {
  private NewsFragment target;

  private View view2131690191;

  @UiThread
  public NewsFragment_ViewBinding(final NewsFragment target, View source) {
    this.target = target;

    View view;
    target.newsCategoryStl = Utils.findRequiredViewAsType(source, R.id.news_category_stl, "field 'newsCategoryStl'", SlidingTabLayout.class);
    target.newsCategoryViewPager = Utils.findRequiredViewAsType(source, R.id.news_category_viewPager, "field 'newsCategoryViewPager'", ViewPager.class);
    target.titleTv = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'titleTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ib_right, "field 'rightIv' and method 'onClick'");
    target.rightIv = Utils.castView(view, R.id.ib_right, "field 'rightIv'", ImageView.class);
    view2131690191 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.newsCategoryStl = null;
    target.newsCategoryViewPager = null;
    target.titleTv = null;
    target.rightIv = null;

    view2131690191.setOnClickListener(null);
    view2131690191 = null;
  }
}
