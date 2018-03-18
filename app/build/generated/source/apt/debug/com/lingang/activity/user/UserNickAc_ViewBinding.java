// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserNickAc_ViewBinding implements Unbinder {
  private UserNickAc target;

  @UiThread
  public UserNickAc_ViewBinding(UserNickAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserNickAc_ViewBinding(UserNickAc target, View source) {
    this.target = target;

    target.userNickEd = Utils.findRequiredViewAsType(source, R.id.user_nick_ed, "field 'userNickEd'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserNickAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.userNickEd = null;
  }
}
