// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import ezy.ui.view.RoundButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserSuggestAddAc_ViewBinding implements Unbinder {
  private UserSuggestAddAc target;

  private View view2131690062;

  @UiThread
  public UserSuggestAddAc_ViewBinding(UserSuggestAddAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserSuggestAddAc_ViewBinding(final UserSuggestAddAc target, View source) {
    this.target = target;

    View view;
    target.suggestFeedContentEt = Utils.findRequiredViewAsType(source, R.id.suggest_feed_content_et, "field 'suggestFeedContentEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.suggest_submit, "field 'suggestSubmit' and method 'onViewClicked'");
    target.suggestSubmit = Utils.castView(view, R.id.suggest_submit, "field 'suggestSubmit'", RoundButton.class);
    view2131690062 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tvFank = Utils.findRequiredViewAsType(source, R.id.tv_fank, "field 'tvFank'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserSuggestAddAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.suggestFeedContentEt = null;
    target.suggestSubmit = null;
    target.tvFank = null;

    view2131690062.setOnClickListener(null);
    view2131690062 = null;
  }
}
