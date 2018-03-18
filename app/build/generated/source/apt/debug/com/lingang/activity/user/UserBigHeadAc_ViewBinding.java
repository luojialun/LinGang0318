// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import uk.co.senab.photoview.PhotoView;

public class UserBigHeadAc_ViewBinding implements Unbinder {
  private UserBigHeadAc target;

  @UiThread
  public UserBigHeadAc_ViewBinding(UserBigHeadAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserBigHeadAc_ViewBinding(UserBigHeadAc target, View source) {
    this.target = target;

    target.imgBig = Utils.findRequiredViewAsType(source, R.id.img_big, "field 'imgBig'", PhotoView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserBigHeadAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBig = null;
  }
}
