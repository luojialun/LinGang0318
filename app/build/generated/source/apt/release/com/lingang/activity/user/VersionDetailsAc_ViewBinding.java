// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VersionDetailsAc_ViewBinding implements Unbinder {
  private VersionDetailsAc target;

  @UiThread
  public VersionDetailsAc_ViewBinding(VersionDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VersionDetailsAc_ViewBinding(VersionDetailsAc target, View source) {
    this.target = target;

    target.contentTv = Utils.findRequiredViewAsType(source, R.id.content_tv, "field 'contentTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VersionDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contentTv = null;
  }
}
