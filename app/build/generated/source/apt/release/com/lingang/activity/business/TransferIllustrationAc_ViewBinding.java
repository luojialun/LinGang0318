// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TransferIllustrationAc_ViewBinding implements Unbinder {
  private TransferIllustrationAc target;

  private View view2131689879;

  @UiThread
  public TransferIllustrationAc_ViewBinding(TransferIllustrationAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TransferIllustrationAc_ViewBinding(final TransferIllustrationAc target, View source) {
    this.target = target;

    View view;
    target.userTv = Utils.findRequiredViewAsType(source, R.id.user_tv, "field 'userTv'", TextView.class);
    target.contentEt = Utils.findRequiredViewAsType(source, R.id.content_et, "field 'contentEt'", EditText.class);
    target.numTv = Utils.findRequiredViewAsType(source, R.id.num_tv, "field 'numTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.submit_tv, "method 'onClick'");
    view2131689879 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TransferIllustrationAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.userTv = null;
    target.contentEt = null;
    target.numTv = null;

    view2131689879.setOnClickListener(null);
    view2131689879 = null;
  }
}
