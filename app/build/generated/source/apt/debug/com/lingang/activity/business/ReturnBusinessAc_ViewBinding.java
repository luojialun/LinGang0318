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

public class ReturnBusinessAc_ViewBinding implements Unbinder {
  private ReturnBusinessAc target;

  private View view2131689879;

  @UiThread
  public ReturnBusinessAc_ViewBinding(ReturnBusinessAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReturnBusinessAc_ViewBinding(final ReturnBusinessAc target, View source) {
    this.target = target;

    View view;
    target.contentEt = Utils.findRequiredViewAsType(source, R.id.content_et, "field 'contentEt'", EditText.class);
    target.numTv = Utils.findRequiredViewAsType(source, R.id.num_tv, "field 'numTv'", TextView.class);
    target.tipTv = Utils.findRequiredViewAsType(source, R.id.tip_tv, "field 'tipTv'", TextView.class);
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
    ReturnBusinessAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contentEt = null;
    target.numTv = null;
    target.tipTv = null;

    view2131689879.setOnClickListener(null);
    view2131689879 = null;
  }
}
