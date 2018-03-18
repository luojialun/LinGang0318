// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClaimAc_ViewBinding implements Unbinder {
  private ClaimAc target;

  private View view2131690524;

  private View view2131689676;

  @UiThread
  public ClaimAc_ViewBinding(ClaimAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ClaimAc_ViewBinding(final ClaimAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.left_btn, "field 'leftBtn' and method 'onViewClicked'");
    target.leftBtn = Utils.castView(view, R.id.left_btn, "field 'leftBtn'", ImageView.class);
    view2131690524 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.titleRbleft = Utils.findRequiredViewAsType(source, R.id.title_rbleft, "field 'titleRbleft'", RadioButton.class);
    target.titleRbright = Utils.findRequiredViewAsType(source, R.id.title_rbright, "field 'titleRbright'", RadioButton.class);
    target.titleRg = Utils.findRequiredViewAsType(source, R.id.title_rg, "field 'titleRg'", RadioGroup.class);
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.tvAll = Utils.findRequiredViewAsType(source, R.id.tv_all, "field 'tvAll'", TextView.class);
    target.tvNews = Utils.findRequiredViewAsType(source, R.id.tv_news, "field 'tvNews'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_tag, "field 'llTag' and method 'onViewClicked'");
    target.llTag = Utils.castView(view, R.id.ll_tag, "field 'llTag'", LinearLayout.class);
    view2131689676 = view;
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
    ClaimAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.leftBtn = null;
    target.titleRbleft = null;
    target.titleRbright = null;
    target.titleRg = null;
    target.recyclerview = null;
    target.refresh = null;
    target.tvAll = null;
    target.tvNews = null;
    target.llTag = null;

    view2131690524.setOnClickListener(null);
    view2131690524 = null;
    view2131689676.setOnClickListener(null);
    view2131689676 = null;
  }
}
