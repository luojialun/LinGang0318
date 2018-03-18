// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NeedFlowReviewAc_ViewBinding implements Unbinder {
  private NeedFlowReviewAc target;

  @UiThread
  public NeedFlowReviewAc_ViewBinding(NeedFlowReviewAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NeedFlowReviewAc_ViewBinding(NeedFlowReviewAc target, View source) {
    this.target = target;

    target.flowDetailsRv = Utils.findRequiredViewAsType(source, R.id.flow_details_rv, "field 'flowDetailsRv'", RecyclerView.class);
    target.flowDetailsRefresh = Utils.findRequiredViewAsType(source, R.id.flow_details_refresh, "field 'flowDetailsRefresh'", TwinklingRefreshLayout.class);
    target.flowReviewTitle = Utils.findRequiredViewAsType(source, R.id.flow_review_title, "field 'flowReviewTitle'", TextView.class);
    target.flowTracingLl = Utils.findRequiredViewAsType(source, R.id.flow_tracing_ll, "field 'flowTracingLl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NeedFlowReviewAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.flowDetailsRv = null;
    target.flowDetailsRefresh = null;
    target.flowReviewTitle = null;
    target.flowTracingLl = null;
  }
}
