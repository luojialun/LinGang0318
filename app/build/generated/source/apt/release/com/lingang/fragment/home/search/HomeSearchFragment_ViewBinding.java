// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home.search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ExtraListView;
import com.lingang.view.flowlayout.TagFlowLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeSearchFragment_ViewBinding implements Unbinder {
  private HomeSearchFragment target;

  private View view2131690162;

  @UiThread
  public HomeSearchFragment_ViewBinding(final HomeSearchFragment target, View source) {
    this.target = target;

    View view;
    target.HomeSearchListview = Utils.findRequiredViewAsType(source, R.id.Home_search_listview, "field 'HomeSearchListview'", ExtraListView.class);
    target.mainSearchTagflowlayout = Utils.findRequiredViewAsType(source, R.id.main_search_tagflowlayout, "field 'mainSearchTagflowlayout'", TagFlowLayout.class);
    view = Utils.findRequiredView(source, R.id.main_search_history_clear_ll, "field 'mainSearchHistoryClearLl' and method 'clearRecord'");
    target.mainSearchHistoryClearLl = Utils.castView(view, R.id.main_search_history_clear_ll, "field 'mainSearchHistoryClearLl'", LinearLayout.class);
    view2131690162 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clearRecord(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeSearchFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.HomeSearchListview = null;
    target.mainSearchTagflowlayout = null;
    target.mainSearchHistoryClearLl = null;

    view2131690162.setOnClickListener(null);
    view2131690162 = null;
  }
}
