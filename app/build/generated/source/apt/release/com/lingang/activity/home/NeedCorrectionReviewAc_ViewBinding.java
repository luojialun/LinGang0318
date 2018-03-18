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

public class NeedCorrectionReviewAc_ViewBinding implements Unbinder {
  private NeedCorrectionReviewAc target;

  private View view2131689831;

  @UiThread
  public NeedCorrectionReviewAc_ViewBinding(NeedCorrectionReviewAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NeedCorrectionReviewAc_ViewBinding(final NeedCorrectionReviewAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.need_corr_submit_btn, "field 'needCorrSubmitBtn' and method 'onViewClicked'");
    target.needCorrSubmitBtn = Utils.castView(view, R.id.need_corr_submit_btn, "field 'needCorrSubmitBtn'", Button.class);
    view2131689831 = view;
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
    NeedCorrectionReviewAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.needCorrSubmitBtn = null;

    view2131689831.setOnClickListener(null);
    view2131689831 = null;
  }
}
