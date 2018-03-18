// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DownloadManageActivity_ViewBinding implements Unbinder {
  private DownloadManageActivity target;

  @UiThread
  public DownloadManageActivity_ViewBinding(DownloadManageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DownloadManageActivity_ViewBinding(DownloadManageActivity target, View source) {
    this.target = target;

    target.mSlidingTabs = Utils.findRequiredViewAsType(source, R.id.sliding_tabs, "field 'mSlidingTabs'", TabLayout.class);
    target.mViewpager = Utils.findRequiredViewAsType(source, R.id.viewpager, "field 'mViewpager'", NoScrollViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DownloadManageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSlidingTabs = null;
    target.mViewpager = null;
  }
}
