// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserAppShare_ViewBinding implements Unbinder {
  private UserAppShare target;

  @UiThread
  public UserAppShare_ViewBinding(UserAppShare target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserAppShare_ViewBinding(UserAppShare target, View source) {
    this.target = target;

    target.sharePathIv = Utils.findRequiredViewAsType(source, R.id.share_path_iv, "field 'sharePathIv'", ImageView.class);
    target.installIv = Utils.findRequiredViewAsType(source, R.id.install_iv, "field 'installIv'", ImageView.class);
    target.phoneTv = Utils.findRequiredViewAsType(source, R.id.phone_tv, "field 'phoneTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserAppShare target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sharePathIv = null;
    target.installIv = null;
    target.phoneTv = null;
  }
}
