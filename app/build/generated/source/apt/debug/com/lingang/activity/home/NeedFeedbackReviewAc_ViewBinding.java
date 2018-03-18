// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NeedFeedbackReviewAc_ViewBinding implements Unbinder {
  private NeedFeedbackReviewAc target;

  private View view2131689833;

  @UiThread
  public NeedFeedbackReviewAc_ViewBinding(NeedFeedbackReviewAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NeedFeedbackReviewAc_ViewBinding(final NeedFeedbackReviewAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.need_feedback_submit_btn, "field 'submitBtn' and method 'onViewClicked'");
    target.submitBtn = Utils.castView(view, R.id.need_feedback_submit_btn, "field 'submitBtn'", Button.class);
    view2131689833 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NeedFeedbackReviewAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.submitBtn = null;

    view2131689833.setOnClickListener(null);
    view2131689833 = null;
  }
}
