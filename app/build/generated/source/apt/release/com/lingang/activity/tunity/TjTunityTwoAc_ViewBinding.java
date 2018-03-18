// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TjTunityTwoAc_ViewBinding implements Unbinder {
  private TjTunityTwoAc target;

  private View view2131690027;

  private View view2131690029;

  @UiThread
  public TjTunityTwoAc_ViewBinding(TjTunityTwoAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TjTunityTwoAc_ViewBinding(final TjTunityTwoAc target, View source) {
    this.target = target;

    View view;
    target.imgXqInfo = Utils.findRequiredViewAsType(source, R.id.img_xq_info, "field 'imgXqInfo'", ImageView.class);
    target.tvXuq = Utils.findRequiredViewAsType(source, R.id.tv_xuq, "field 'tvXuq'", TextView.class);
    target.llClass = Utils.findRequiredViewAsType(source, R.id.ll_class, "field 'llClass'", LinearLayout.class);
    target.etExplan = Utils.findRequiredViewAsType(source, R.id.et_explan, "field 'etExplan'", EditText.class);
    target.etNum = Utils.findRequiredViewAsType(source, R.id.et_num, "field 'etNum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_add, "method 'onViewClicked'");
    view2131690027 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_next_two, "method 'onViewClicked'");
    view2131690029 = view;
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
    TjTunityTwoAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgXqInfo = null;
    target.tvXuq = null;
    target.llClass = null;
    target.etExplan = null;
    target.etNum = null;

    view2131690027.setOnClickListener(null);
    view2131690027 = null;
    view2131690029.setOnClickListener(null);
    view2131690029 = null;
  }
}
