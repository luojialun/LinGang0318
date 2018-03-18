// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.gesturelock.LockPatternView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GestureLockLoginActivity_ViewBinding implements Unbinder {
  private GestureLockLoginActivity target;

  private View view2131689739;

  @UiThread
  public GestureLockLoginActivity_ViewBinding(GestureLockLoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GestureLockLoginActivity_ViewBinding(final GestureLockLoginActivity target, View source) {
    this.target = target;

    View view;
    target.messageTv = Utils.findRequiredViewAsType(source, R.id.gesture_lock_login_tip_tv, "field 'messageTv'", TextView.class);
    target.lockPatternView = Utils.findRequiredViewAsType(source, R.id.gesture_lock_login_lockpatternview, "field 'lockPatternView'", LockPatternView.class);
    target.gestureLockLoginLockpatternviewContainer = Utils.findRequiredViewAsType(source, R.id.gesture_lock_login_lockpatternview_container, "field 'gestureLockLoginLockpatternviewContainer'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.gesture_lock_login_user, "field 'gestureLockLoginUser' and method 'forgetGesturePwd'");
    target.gestureLockLoginUser = Utils.castView(view, R.id.gesture_lock_login_user, "field 'gestureLockLoginUser'", TextView.class);
    view2131689739 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.forgetGesturePwd(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    GestureLockLoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.messageTv = null;
    target.lockPatternView = null;
    target.gestureLockLoginLockpatternviewContainer = null;
    target.gestureLockLoginUser = null;

    view2131689739.setOnClickListener(null);
    view2131689739 = null;
  }
}
