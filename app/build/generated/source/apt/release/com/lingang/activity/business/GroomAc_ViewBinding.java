// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.next.tagview.TagCloudView;

public class GroomAc_ViewBinding implements Unbinder {
  private GroomAc target;

  private View view2131689744;

  private View view2131689622;

  private View view2131689742;

  @UiThread
  public GroomAc_ViewBinding(GroomAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GroomAc_ViewBinding(final GroomAc target, View source) {
    this.target = target;

    View view;
    target.tcClass = Utils.findRequiredViewAsType(source, R.id.tc_class, "field 'tcClass'", TagCloudView.class);
    target.recycler = Utils.findRequiredViewAsType(source, R.id.recycler, "field 'recycler'", RecyclerView.class);
    target.tfTuijian = Utils.findRequiredViewAsType(source, R.id.tf_tuijian, "field 'tfTuijian'", TagCloudView.class);
    view = Utils.findRequiredView(source, R.id.btn_comit, "field 'btnComit' and method 'onViewClicked'");
    target.btnComit = Utils.castView(view, R.id.btn_comit, "field 'btnComit'", Button.class);
    view2131689744 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_class, "field 'tvClass' and method 'onViewClicked'");
    target.tvClass = Utils.castView(view, R.id.tv_class, "field 'tvClass'", TextView.class);
    view2131689622 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_claim, "field 'tvClaim' and method 'onViewClicked'");
    target.tvClaim = Utils.castView(view, R.id.tv_claim, "field 'tvClaim'", TextView.class);
    view2131689742 = view;
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
    GroomAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tcClass = null;
    target.recycler = null;
    target.tfTuijian = null;
    target.btnComit = null;
    target.tvClass = null;
    target.tvClaim = null;

    view2131689744.setOnClickListener(null);
    view2131689744 = null;
    view2131689622.setOnClickListener(null);
    view2131689622 = null;
    view2131689742.setOnClickListener(null);
    view2131689742 = null;
  }
}
