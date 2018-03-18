// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home.search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SeachClusterAc_ViewBinding implements Unbinder {
  private SeachClusterAc target;

  @UiThread
  public SeachClusterAc_ViewBinding(SeachClusterAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SeachClusterAc_ViewBinding(SeachClusterAc target, View source) {
    this.target = target;

    target.llCluster = Utils.findRequiredViewAsType(source, R.id.ll_cluster, "field 'llCluster'", LinearLayout.class);
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SeachClusterAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llCluster = null;
    target.recyclerview = null;
    target.refresh = null;
  }
}
