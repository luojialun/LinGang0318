// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.CircleImageView;
import com.lingang.view.gesturelock.LockPatternView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GestureLockEditActivity_ViewBinding implements Unbinder {
  private GestureLockEditActivity target;

  private View view2131689734;

  @UiThread
  public GestureLockEditActivity_ViewBinding(GestureLockEditActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GestureLockEditActivity_ViewBinding(final GestureLockEditActivity target, View source) {
    this.target = target;

    View view;
    target.gestureLockEditTipTv = Utils.findRequiredViewAsType(source, R.id.gesture_lock_edit_tip_tv, "field 'gestureLockEditTipTv'", TextView.class);
    target.lockPatternView = Utils.findRequiredViewAsType(source, R.id.gesture_lock_edit_lockpatternview, "field 'lockPatternView'", LockPatternView.class);
    target.gestureLockEditUserIcon = Utils.findRequiredViewAsType(source, R.id.gesture_lock_edit_user_icon, "field 'gestureLockEditUserIcon'", CircleImageView.class);
    view = Utils.findRequiredView(source, R.id.login_gesture_edit_skip_tv, "field 'loginGestureEditSkipTv' and method 'skipSetting'");
    target.loginGestureEditSkipTv = Utils.castView(view, R.id.login_gesture_edit_skip_tv, "field 'loginGestureEditSkipTv'", TextView.class);
    view2131689734 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.skipSetting(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    GestureLockEditActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.gestureLockEditTipTv = null;
    target.lockPatternView = null;
    target.gestureLockEditUserIcon = null;
    target.loginGestureEditSkipTv = null;

    view2131689734.setOnClickListener(null);
    view2131689734 = null;
  }
}
