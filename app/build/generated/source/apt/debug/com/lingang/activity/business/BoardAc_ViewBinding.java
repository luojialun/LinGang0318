// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ProgressWebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BoardAc_ViewBinding implements Unbinder {
  private BoardAc target;

  private View view2131689630;

  private View view2131689636;

  private View view2131689639;

  private View view2131689643;

  private View view2131689646;

  private View view2131689649;

  private View view2131689652;

  @UiThread
  public BoardAc_ViewBinding(BoardAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BoardAc_ViewBinding(final BoardAc target, View source) {
    this.target = target;

    View view;
    target.unitTv = Utils.findRequiredViewAsType(source, R.id.unit_tv, "field 'unitTv'", TextView.class);
    target.webView = Utils.findRequiredViewAsType(source, R.id.chart_wv, "field 'webView'", ProgressWebView.class);
    target.totalTv = Utils.findRequiredViewAsType(source, R.id.total_tv, "field 'totalTv'", TextView.class);
    target.addTv = Utils.findRequiredViewAsType(source, R.id.add_tv, "field 'addTv'", TextView.class);
    target.claimTv = Utils.findRequiredViewAsType(source, R.id.claim_tv, "field 'claimTv'", TextView.class);
    target.executingTv = Utils.findRequiredViewAsType(source, R.id.executing_tv, "field 'executingTv'", TextView.class);
    target.successTv = Utils.findRequiredViewAsType(source, R.id.success_tv, "field 'successTv'", TextView.class);
    target.avgTimeTv = Utils.findRequiredViewAsType(source, R.id.avg_time_tv, "field 'avgTimeTv'", TextView.class);
    target.typeTv = Utils.findRequiredViewAsType(source, R.id.type_tv, "field 'typeTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.type_ll, "field 'typeLl' and method 'onClick'");
    target.typeLl = Utils.castView(view, R.id.type_ll, "field 'typeLl'", LinearLayout.class);
    view2131689630 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.arrowIv = Utils.findRequiredViewAsType(source, R.id.arrow_iv, "field 'arrowIv'", ImageView.class);
    target.totalContentTv = Utils.findRequiredViewAsType(source, R.id.total_content_tv, "field 'totalContentTv'", TextView.class);
    target.addContentTv = Utils.findRequiredViewAsType(source, R.id.add_content_tv, "field 'addContentTv'", TextView.class);
    target.claimContentTv = Utils.findRequiredViewAsType(source, R.id.claim_content_tv, "field 'claimContentTv'", TextView.class);
    target.executingContentTv = Utils.findRequiredViewAsType(source, R.id.executing_content_tv, "field 'executingContentTv'", TextView.class);
    target.successContentTv = Utils.findRequiredViewAsType(source, R.id.success_content_tv, "field 'successContentTv'", TextView.class);
    target.avgTimeContentTv = Utils.findRequiredViewAsType(source, R.id.avg_time_content_tv, "field 'avgTimeContentTv'", TextView.class);
    target.errorLl = Utils.findRequiredViewAsType(source, R.id.error_ll, "field 'errorLl'", LinearLayout.class);
    target.secendIv = Utils.findRequiredViewAsType(source, R.id.secend_iv, "field 'secendIv'", ImageView.class);
    target.sixthIv = Utils.findRequiredViewAsType(source, R.id.sixth_iv, "field 'sixthIv'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.all_oppo_rl, "method 'onClick'");
    view2131689636 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.add_rl, "method 'onClick'");
    view2131689639 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.unclaimed_rl, "method 'onClick'");
    view2131689643 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.exec_oppo_rl, "method 'onClick'");
    view2131689646 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.landed_oppo_rl, "method 'onClick'");
    view2131689649 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.avg_land_oppo_rl, "method 'onClick'");
    view2131689652 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    BoardAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.unitTv = null;
    target.webView = null;
    target.totalTv = null;
    target.addTv = null;
    target.claimTv = null;
    target.executingTv = null;
    target.successTv = null;
    target.avgTimeTv = null;
    target.typeTv = null;
    target.typeLl = null;
    target.arrowIv = null;
    target.totalContentTv = null;
    target.addContentTv = null;
    target.claimContentTv = null;
    target.executingContentTv = null;
    target.successContentTv = null;
    target.avgTimeContentTv = null;
    target.errorLl = null;
    target.secendIv = null;
    target.sixthIv = null;

    view2131689630.setOnClickListener(null);
    view2131689630 = null;
    view2131689636.setOnClickListener(null);
    view2131689636 = null;
    view2131689639.setOnClickListener(null);
    view2131689639 = null;
    view2131689643.setOnClickListener(null);
    view2131689643 = null;
    view2131689646.setOnClickListener(null);
    view2131689646 = null;
    view2131689649.setOnClickListener(null);
    view2131689649 = null;
    view2131689652.setOnClickListener(null);
    view2131689652 = null;
  }
}
