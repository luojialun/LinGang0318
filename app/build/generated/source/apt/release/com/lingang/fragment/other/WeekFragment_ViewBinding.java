// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.other;

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

public class WeekFragment_ViewBinding implements Unbinder {
  private WeekFragment target;

  @UiThread
  public WeekFragment_ViewBinding(WeekFragment target, View source) {
    this.target = target;

    target.lvWeek = Utils.findRequiredViewAsType(source, R.id.lv_week, "field 'lvWeek'", ExpandableListView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WeekFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvWeek = null;
    target.refresh = null;
  }
}
