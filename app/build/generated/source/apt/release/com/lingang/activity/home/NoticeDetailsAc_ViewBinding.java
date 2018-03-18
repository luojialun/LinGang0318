// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ExtraListView;
import com.lingang.view.JustifiedWebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticeDetailsAc_ViewBinding implements Unbinder {
  private NoticeDetailsAc target;

  @UiThread
  public NoticeDetailsAc_ViewBinding(NoticeDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NoticeDetailsAc_ViewBinding(NoticeDetailsAc target, View source) {
    this.target = target;

    target.tvNoTitle = Utils.findRequiredViewAsType(source, R.id.tv_no_title, "field 'tvNoTitle'", TextView.class);
    target.tvNoTeam = Utils.findRequiredViewAsType(source, R.id.tv_no_team, "field 'tvNoTeam'", TextView.class);
    target.tvNoTime = Utils.findRequiredViewAsType(source, R.id.tv_no_time, "field 'tvNoTime'", TextView.class);
    target.tvNoNum = Utils.findRequiredViewAsType(source, R.id.tv_no_num, "field 'tvNoNum'", TextView.class);
    target.contentTv = Utils.findRequiredViewAsType(source, R.id.content_tv, "field 'contentTv'", JustifiedWebView.class);
    target.lvRes = Utils.findRequiredViewAsType(source, R.id.lv_cail, "field 'lvRes'", ExtraListView.class);
    target.scNotice = Utils.findRequiredViewAsType(source, R.id.sc_notice, "field 'scNotice'", ScrollView.class);
    target.llFile = Utils.findRequiredViewAsType(source, R.id.ll_file, "field 'llFile'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NoticeDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvNoTitle = null;
    target.tvNoTeam = null;
    target.tvNoTime = null;
    target.tvNoNum = null;
    target.contentTv = null;
    target.lvRes = null;
    target.scNotice = null;
    target.llFile = null;
  }
}
