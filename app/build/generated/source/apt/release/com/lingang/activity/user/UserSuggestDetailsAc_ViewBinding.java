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

public class UserSuggestDetailsAc_ViewBinding implements Unbinder {
  private UserSuggestDetailsAc target;

  @UiThread
  public UserSuggestDetailsAc_ViewBinding(UserSuggestDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserSuggestDetailsAc_ViewBinding(UserSuggestDetailsAc target, View source) {
    this.target = target;

    target.feedbackContentSi = Utils.findRequiredViewAsType(source, R.id.feedback_content_si, "field 'feedbackContentSi'", SettingItem.class);
    target.adminReplySi = Utils.findRequiredViewAsType(source, R.id.admin_reply_si, "field 'adminReplySi'", SettingItem.class);
    target.suggestContentTv = Utils.findRequiredViewAsType(source, R.id.suggest_content_tv, "field 'suggestContentTv'", TextView.class);
    target.suggestReplyContentTv = Utils.findRequiredViewAsType(source, R.id.suggest_reply_content_tv, "field 'suggestReplyContentTv'", TextView.class);
    target.suggestPlaneLl = Utils.findRequiredViewAsType(source, R.id.suggest_plane_ll, "field 'suggestPlaneLl'", LinearLayout.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserSuggestDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.feedbackContentSi = null;
    target.adminReplySi = null;
    target.suggestContentTv = null;
    target.suggestReplyContentTv = null;
    target.suggestPlaneLl = null;
    target.refresh = null;
  }
}
