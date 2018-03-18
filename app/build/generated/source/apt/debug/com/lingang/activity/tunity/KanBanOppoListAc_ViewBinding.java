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

public class KanBanOppoListAc_ViewBinding implements Unbinder {
  private KanBanOppoListAc target;

  private View view2131689784;

  private View view2131689786;

  private View view2131689630;

  @UiThread
  public KanBanOppoListAc_ViewBinding(KanBanOppoListAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public KanBanOppoListAc_ViewBinding(final KanBanOppoListAc target, View source) {
    this.target = target;

    View view;
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.popLl = Utils.findRequiredViewAsType(source, R.id.pop_ll, "field 'popLl'", LinearLayout.class);
    target.sourceTv = Utils.findRequiredViewAsType(source, R.id.source_tv, "field 'sourceTv'", TextView.class);
    target.typeTv = Utils.findRequiredViewAsType(source, R.id.type_tv, "field 'typeTv'", TextView.class);
    target.numTv = Utils.findRequiredViewAsType(source, R.id.num_tv, "field 'numTv'", TextView.class);
    target.parkTv = Utils.findRequiredViewAsType(source, R.id.park_tv, "field 'parkTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.park_ll, "field 'parkLl' and method 'onClick'");
    target.parkLl = Utils.castView(view, R.id.park_ll, "field 'parkLl'", LinearLayout.class);
    view2131689784 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.source_ll, "method 'onClick'");
    view2131689786 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.type_ll, "method 'onClick'");
    view2131689630 = view;
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
    KanBanOppoListAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.refresh = null;
    target.recyclerview = null;
    target.popLl = null;
    target.sourceTv = null;
    target.typeTv = null;
    target.numTv = null;
    target.parkTv = null;
    target.parkLl = null;

    view2131689784.setOnClickListener(null);
    view2131689784 = null;
    view2131689786.setOnClickListener(null);
    view2131689786 = null;
    view2131689630.setOnClickListener(null);
    view2131689630 = null;
  }
}
