// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity.execute;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyExecute_ViewBinding implements Unbinder {
  private MyExecute target;

  private View view2131689825;

  private View view2131689630;

  private View view2131689786;

  @UiThread
  public MyExecute_ViewBinding(MyExecute target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyExecute_ViewBinding(final MyExecute target, View source) {
    this.target = target;

    View view;
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.popLl = Utils.findRequiredViewAsType(source, R.id.pop_ll, "field 'popLl'", LinearLayout.class);
    target.stateTv = Utils.findRequiredViewAsType(source, R.id.state_tv, "field 'stateTv'", TextView.class);
    target.typeTv = Utils.findRequiredViewAsType(source, R.id.type_tv, "field 'typeTv'", TextView.class);
    target.sourceTv = Utils.findRequiredViewAsType(source, R.id.source_tv, "field 'sourceTv'", TextView.class);
    target.tvNews = Utils.findRequiredViewAsType(source, R.id.tv_news, "field 'tvNews'", TextView.class);
    view = Utils.findRequiredView(source, R.id.state_ll, "method 'onViewClicked'");
    view2131689825 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.type_ll, "method 'onViewClicked'");
    view2131689630 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.source_ll, "method 'onViewClicked'");
    view2131689786 = view;
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
    MyExecute target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerview = null;
    target.refresh = null;
    target.popLl = null;
    target.stateTv = null;
    target.typeTv = null;
    target.sourceTv = null;
    target.tvNews = null;

    view2131689825.setOnClickListener(null);
    view2131689825 = null;
    view2131689630.setOnClickListener(null);
    view2131689630 = null;
    view2131689786.setOnClickListener(null);
    view2131689786 = null;
  }
}
