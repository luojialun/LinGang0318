// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NeedFeedbackFragment_ViewBinding implements Unbinder {
  private NeedFeedbackFragment target;

  private View view2131690185;

  private View view2131690186;

  @UiThread
  public NeedFeedbackFragment_ViewBinding(final NeedFeedbackFragment target, View source) {
    this.target = target;

    View view;
    target.needFeedbackRefresh = Utils.findRequiredViewAsType(source, R.id.need_feedback_refresh, "field 'needFeedbackRefresh'", TwinklingRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.testClick, "field 'testClick' and method 'onViewClicked'");
    target.testClick = Utils.castView(view, R.id.testClick, "field 'testClick'", RelativeLayout.class);
    view2131690185 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.testClick2, "method 'onViewClicked'");
    view2131690186 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NeedFeedbackFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.needFeedbackRefresh = null;
    target.testClick = null;

    view2131690185.setOnClickListener(null);
    view2131690185 = null;
    view2131690186.setOnClickListener(null);
    view2131690186 = null;
  }
}
