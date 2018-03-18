// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

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
import me.next.tagview.TagCloudView;

public class ClaimDetailesAc_ViewBinding implements Unbinder {
  private ClaimDetailesAc target;

  private View view2131689680;

  private View view2131689681;

  @UiThread
  public ClaimDetailesAc_ViewBinding(ClaimDetailesAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ClaimDetailesAc_ViewBinding(final ClaimDetailesAc target, View source) {
    this.target = target;

    View view;
    target.tfDetailes = Utils.findRequiredViewAsType(source, R.id.tf_detailes, "field 'tfDetailes'", TagCloudView.class);
    view = Utils.findRequiredView(source, R.id.btn_refuse, "field 'btnRefuse' and method 'onViewClicked'");
    target.btnRefuse = Utils.castView(view, R.id.btn_refuse, "field 'btnRefuse'", Button.class);
    view2131689680 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_claim, "field 'btnClaim' and method 'onViewClicked'");
    target.btnClaim = Utils.castView(view, R.id.btn_claim, "field 'btnClaim'", Button.class);
    view2131689681 = view;
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
    ClaimDetailesAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tfDetailes = null;
    target.btnRefuse = null;
    target.btnClaim = null;

    view2131689680.setOnClickListener(null);
    view2131689680 = null;
    view2131689681.setOnClickListener(null);
    view2131689681 = null;
  }
}
