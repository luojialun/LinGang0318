// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserCorrectDetailsAc_ViewBinding implements Unbinder {
  private UserCorrectDetailsAc target;

  @UiThread
  public UserCorrectDetailsAc_ViewBinding(UserCorrectDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserCorrectDetailsAc_ViewBinding(UserCorrectDetailsAc target, View source) {
    this.target = target;

    target.correctDateSi = Utils.findRequiredViewAsType(source, R.id.correct_date_si, "field 'correctDateSi'", SettingItem.class);
    target.replyDateSi = Utils.findRequiredViewAsType(source, R.id.reply_date_si, "field 'replyDateSi'", SettingItem.class);
    target.correctContentTv = Utils.findRequiredViewAsType(source, R.id.correct_content_tv, "field 'correctContentTv'", TextView.class);
    target.correctReplyContentTv = Utils.findRequiredViewAsType(source, R.id.correct_reply_content_tv, "field 'correctReplyContentTv'", TextView.class);
    target.correctPlaneLl = Utils.findRequiredViewAsType(source, R.id.correct_plane_ll, "field 'correctPlaneLl'", LinearLayout.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserCorrectDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.correctDateSi = null;
    target.replyDateSi = null;
    target.correctContentTv = null;
    target.correctReplyContentTv = null;
    target.correctPlaneLl = null;
    target.refresh = null;
  }
}
