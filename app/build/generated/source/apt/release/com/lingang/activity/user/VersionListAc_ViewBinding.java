// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VersionListAc_ViewBinding implements Unbinder {
  private VersionListAc target;

  @UiThread
  public VersionListAc_ViewBinding(VersionListAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VersionListAc_ViewBinding(VersionListAc target, View source) {
    this.target = target;

    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VersionListAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerview = null;
  }
}
