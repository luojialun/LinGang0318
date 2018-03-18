// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RlTunityAc_ViewBinding implements Unbinder {
  private RlTunityAc target;

  private View view2131689617;

  private View view2131689619;

  private View view2131689621;

  @UiThread
  public RlTunityAc_ViewBinding(RlTunityAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RlTunityAc_ViewBinding(final RlTunityAc target, View source) {
    this.target = target;

    View view;
    target.tvYaunq = Utils.findRequiredViewAsType(source, R.id.tv_yaunq, "field 'tvYaunq'", TextView.class);
    target.tvLaiy = Utils.findRequiredViewAsType(source, R.id.tv_laiy, "field 'tvLaiy'", TextView.class);
    target.tvClass = Utils.findRequiredViewAsType(source, R.id.tv_class, "field 'tvClass'", TextView.class);
    target.tvNewsnum = Utils.findRequiredViewAsType(source, R.id.tv_newsnum, "field 'tvNewsnum'", TextView.class);
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.rl_yaunq, "field 'rlYaunq' and method 'onViewClicked'");
    target.rlYaunq = Utils.castView(view, R.id.rl_yaunq, "field 'rlYaunq'", RelativeLayout.class);
    view2131689617 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_laiy, "method 'onViewClicked'");
    view2131689619 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_class, "method 'onViewClicked'");
    view2131689621 = view;
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
    RlTunityAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvYaunq = null;
    target.tvLaiy = null;
    target.tvClass = null;
    target.tvNewsnum = null;
    target.recyclerview = null;
    target.refresh = null;
    target.rlYaunq = null;

    view2131689617.setOnClickListener(null);
    view2131689617 = null;
    view2131689619.setOnClickListener(null);
    view2131689619 = null;
    view2131689621.setOnClickListener(null);
    view2131689621 = null;
  }
}
