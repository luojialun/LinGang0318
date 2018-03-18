// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home.search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SeachBusinessAc_ViewBinding implements Unbinder {
  private SeachBusinessAc target;

  private View view2131690507;

  private View view2131690509;

  @UiThread
  public SeachBusinessAc_ViewBinding(SeachBusinessAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SeachBusinessAc_ViewBinding(final SeachBusinessAc target, View source) {
    this.target = target;

    View view;
    target.tvBtnLeft = Utils.findRequiredViewAsType(source, R.id.tv_btn_left, "field 'tvBtnLeft'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_left, "field 'rlLeft' and method 'onViewClicked'");
    target.rlLeft = Utils.castView(view, R.id.rl_left, "field 'rlLeft'", RelativeLayout.class);
    view2131690507 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvBtnRight = Utils.findRequiredViewAsType(source, R.id.tv_btn_right, "field 'tvBtnRight'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_right, "field 'rlRight' and method 'onViewClicked'");
    target.rlRight = Utils.castView(view, R.id.rl_right, "field 'rlRight'", RelativeLayout.class);
    view2131690509 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.vvLine = Utils.findRequiredView(source, R.id.vv_line, "field 'vvLine'");
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.tvNewsnum = Utils.findRequiredViewAsType(source, R.id.tv_newsnum, "field 'tvNewsnum'", TextView.class);
    target.llBusiness = Utils.findRequiredViewAsType(source, R.id.ll_business, "field 'llBusiness'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SeachBusinessAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvBtnLeft = null;
    target.rlLeft = null;
    target.tvBtnRight = null;
    target.rlRight = null;
    target.vvLine = null;
    target.recyclerview = null;
    target.refresh = null;
    target.tvNewsnum = null;
    target.llBusiness = null;

    view2131690507.setOnClickListener(null);
    view2131690507 = null;
    view2131690509.setOnClickListener(null);
    view2131690509 = null;
  }
}
