// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home.search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ClearableEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeSearchActivity_ViewBinding implements Unbinder {
  private HomeSearchActivity target;

  private View view2131689768;

  @UiThread
  public HomeSearchActivity_ViewBinding(HomeSearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeSearchActivity_ViewBinding(final HomeSearchActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.home_search_left_back_iv, "field 'homeSearchLeftBackIv' and method 'leftBack'");
    target.homeSearchLeftBackIv = Utils.castView(view, R.id.home_search_left_back_iv, "field 'homeSearchLeftBackIv'", ImageView.class);
    view2131689768 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftBack(p0);
      }
    });
    target.homeSearchInputEt = Utils.findRequiredViewAsType(source, R.id.home_search_input_et, "field 'homeSearchInputEt'", ClearableEditText.class);
    target.searchAllToolbarRl = Utils.findRequiredViewAsType(source, R.id.search_all_toolbar_rl, "field 'searchAllToolbarRl'", LinearLayout.class);
    target.homeSearchFragment = Utils.findRequiredViewAsType(source, R.id.home_search_fragment, "field 'homeSearchFragment'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeSearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.homeSearchLeftBackIv = null;
    target.homeSearchInputEt = null;
    target.searchAllToolbarRl = null;
    target.homeSearchFragment = null;

    view2131689768.setOnClickListener(null);
    view2131689768 = null;
  }
}
