// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavoritesBusinessFragment_ViewBinding implements Unbinder {
  private FavoritesBusinessFragment target;

  @UiThread
  public FavoritesBusinessFragment_ViewBinding(FavoritesBusinessFragment target, View source) {
    this.target = target;

    target.recycleview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recycleview'", RecyclerView.class);
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refreshLayout'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavoritesBusinessFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recycleview = null;
    target.refreshLayout = null;
  }
}
