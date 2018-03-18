// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

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

public class NeedFlowFragment_ViewBinding implements Unbinder {
  private NeedFlowFragment target;

  @UiThread
  public NeedFlowFragment_ViewBinding(NeedFlowFragment target, View source) {
    this.target = target;

    target.needFlowRv = Utils.findRequiredViewAsType(source, R.id.need_flow_rv, "field 'needFlowRv'", RecyclerView.class);
    target.needFlowRefresh = Utils.findRequiredViewAsType(source, R.id.need_flow_refresh, "field 'needFlowRefresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NeedFlowFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.needFlowRv = null;
    target.needFlowRefresh = null;
  }
}
