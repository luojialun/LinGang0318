// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

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

public class MyExamineAc_ViewBinding implements Unbinder {
  private MyExamineAc target;

  private View view2131689822;

  private View view2131689823;

  @UiThread
  public MyExamineAc_ViewBinding(MyExamineAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyExamineAc_ViewBinding(final MyExamineAc target, View source) {
    this.target = target;

    View view;
    target.popLl = Utils.findRequiredViewAsType(source, R.id.pop_ll, "field 'popLl'", LinearLayout.class);
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.tvAll = Utils.findRequiredViewAsType(source, R.id.tv_all, "field 'tvAll'", TextView.class);
    target.tvNews = Utils.findRequiredViewAsType(source, R.id.tv_news, "field 'tvNews'", TextView.class);
    target.tvType = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'tvType'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_all, "method 'onViewClicked'");
    view2131689822 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_type, "method 'onViewClicked'");
    view2131689823 = view;
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
    MyExamineAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.popLl = null;
    target.recyclerview = null;
    target.refresh = null;
    target.tvAll = null;
    target.tvNews = null;
    target.tvType = null;

    view2131689822.setOnClickListener(null);
    view2131689822 = null;
    view2131689823.setOnClickListener(null);
    view2131689823 = null;
  }
}
