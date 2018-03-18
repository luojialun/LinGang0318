// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DownloadMyFragment_ViewBinding implements Unbinder {
  private DownloadMyFragment target;

  @UiThread
  public DownloadMyFragment_ViewBinding(DownloadMyFragment target, View source) {
    this.target = target;

    target.mSwipeRv = Utils.findRequiredViewAsType(source, R.id.swipe_rv, "field 'mSwipeRv'", SwipeMenuRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DownloadMyFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSwipeRv = null;
  }
}
