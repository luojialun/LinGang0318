// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyTunity_ViewBinding implements Unbinder {
  private MyTunity target;

  @UiThread
  public MyTunity_ViewBinding(MyTunity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyTunity_ViewBinding(MyTunity target, View source) {
    this.target = target;

    target.imgTest = Utils.findRequiredViewAsType(source, R.id.img_test, "field 'imgTest'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyTunity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgTest = null;
  }
}
