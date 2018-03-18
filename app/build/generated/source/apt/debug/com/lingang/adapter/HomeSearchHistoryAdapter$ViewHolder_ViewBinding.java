// Generated code from Butter Knife. Do not modify!
package com.lingang.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeSearchHistoryAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HomeSearchHistoryAdapter.ViewHolder target;

  @UiThread
  public HomeSearchHistoryAdapter$ViewHolder_ViewBinding(HomeSearchHistoryAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.searchHistoryLeftIcon = Utils.findRequiredViewAsType(source, R.id.search_history_left_icon, "field 'searchHistoryLeftIcon'", ImageView.class);
    target.searchHistoryText = Utils.findRequiredViewAsType(source, R.id.search_history_text, "field 'searchHistoryText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeSearchHistoryAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.searchHistoryLeftIcon = null;
    target.searchHistoryText = null;
  }
}
