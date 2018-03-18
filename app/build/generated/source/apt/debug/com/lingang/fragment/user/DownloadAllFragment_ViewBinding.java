// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ExpandableListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DownloadAllFragment_ViewBinding implements Unbinder {
  private DownloadAllFragment target;

  @UiThread
  public DownloadAllFragment_ViewBinding(DownloadAllFragment target, View source) {
    this.target = target;

    target.mExpendlist = Utils.findRequiredViewAsType(source, R.id.expendlist, "field 'mExpendlist'", ExpandableListView.class);
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refresh_layout, "field 'refreshLayout'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DownloadAllFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mExpendlist = null;
    target.refreshLayout = null;
  }
}
