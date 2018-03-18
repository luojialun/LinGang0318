// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

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
import com.lingang.view.ExtraListView;
import com.lingang.view.JustifiedWebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsDetailsAc_ViewBinding implements Unbinder {
  private NewsDetailsAc target;

  private View view2131689847;

  @UiThread
  public NewsDetailsAc_ViewBinding(NewsDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NewsDetailsAc_ViewBinding(final NewsDetailsAc target, View source) {
    this.target = target;

    View view;
    target.wbDetails = Utils.findRequiredViewAsType(source, R.id.wb_details, "field 'wbDetails'", JustifiedWebView.class);
    target.tvDetaiTitle = Utils.findRequiredViewAsType(source, R.id.tv_detai_title, "field 'tvDetaiTitle'", TextView.class);
    target.tvTeam = Utils.findRequiredViewAsType(source, R.id.tv_team, "field 'tvTeam'", TextView.class);
    target.tvDateTime = Utils.findRequiredViewAsType(source, R.id.tv_details_time, "field 'tvDateTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_watch, "field 'ivWatch' and method 'onViewClicked'");
    target.ivWatch = Utils.castView(view, R.id.iv_watch, "field 'ivWatch'", ImageView.class);
    view2131689847 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llFile = Utils.findRequiredViewAsType(source, R.id.ll_file, "field 'llFile'", LinearLayout.class);
    target.lvCail = Utils.findRequiredViewAsType(source, R.id.lv_cail, "field 'lvCail'", ExtraListView.class);
    target.authorNameIv = Utils.findRequiredViewAsType(source, R.id.author_name_iv, "field 'authorNameIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.wbDetails = null;
    target.tvDetaiTitle = null;
    target.tvTeam = null;
    target.tvDateTime = null;
    target.ivWatch = null;
    target.llFile = null;
    target.lvCail = null;
    target.authorNameIv = null;

    view2131689847.setOnClickListener(null);
    view2131689847 = null;
  }
}
