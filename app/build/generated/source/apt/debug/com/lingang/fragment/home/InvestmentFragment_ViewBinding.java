// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.view.ExtraGridView;
import com.lingang.view.ProgressWebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InvestmentFragment_ViewBinding implements Unbinder {
  private InvestmentFragment target;

  @UiThread
  public InvestmentFragment_ViewBinding(InvestmentFragment target, View source) {
    this.target = target;

    target.busiGv = Utils.findRequiredViewAsType(source, R.id.busi_gv, "field 'busiGv'", ExtraGridView.class);
    target.queryGv = Utils.findRequiredViewAsType(source, R.id.query_gv, "field 'queryGv'", ExtraGridView.class);
    target.ibLeft = Utils.findRequiredViewAsType(source, R.id.ib_left, "field 'ibLeft'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.unitTv = Utils.findRequiredViewAsType(source, R.id.unit_tv, "field 'unitTv'", TextView.class);
    target.webView = Utils.findRequiredViewAsType(source, R.id.chart_wv, "field 'webView'", ProgressWebView.class);
    target.totalTv = Utils.findRequiredViewAsType(source, R.id.total_tv, "field 'totalTv'", TextView.class);
    target.addTv = Utils.findRequiredViewAsType(source, R.id.add_tv, "field 'addTv'", TextView.class);
    target.errorLl = Utils.findRequiredViewAsType(source, R.id.error_ll, "field 'errorLl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InvestmentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.busiGv = null;
    target.queryGv = null;
    target.ibLeft = null;
    target.tvTitle = null;
    target.refresh = null;
    target.unitTv = null;
    target.webView = null;
    target.totalTv = null;
    target.addTv = null;
    target.errorLl = null;
  }
}
