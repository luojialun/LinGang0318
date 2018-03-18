// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListAc_ViewBinding implements Unbinder {
  private ListAc target;

  private View view2131690522;

  private View view2131689797;

  @UiThread
  public ListAc_ViewBinding(ListAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListAc_ViewBinding(final ListAc target, View source) {
    this.target = target;

    View view;
    target.rankingRecyclerView = Utils.findRequiredViewAsType(source, R.id.ranking_recycler_view, "field 'rankingRecyclerView'", RecyclerView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ibRight = Utils.findRequiredViewAsType(source, R.id.ib_right, "field 'ibRight'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ib_left, "field 'ibLeft' and method 'onViewClicked'");
    target.ibLeft = Utils.castView(view, R.id.ib_left, "field 'ibLeft'", ImageView.class);
    view2131690522 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ranking_about_iv, "field 'rankingAboutIv' and method 'onViewClicked'");
    target.rankingAboutIv = Utils.castView(view, R.id.ranking_about_iv, "field 'rankingAboutIv'", ImageView.class);
    view2131689797 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refreshLayout, "field 'refreshLayout'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rankingRecyclerView = null;
    target.tvTitle = null;
    target.ibRight = null;
    target.ibLeft = null;
    target.rankingAboutIv = null;
    target.refreshLayout = null;

    view2131690522.setOnClickListener(null);
    view2131690522 = null;
    view2131689797.setOnClickListener(null);
    view2131689797 = null;
  }
}
