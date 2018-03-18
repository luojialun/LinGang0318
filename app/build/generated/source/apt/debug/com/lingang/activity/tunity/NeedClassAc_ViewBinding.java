// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NeedClassAc_ViewBinding implements Unbinder {
  private NeedClassAc target;

  @UiThread
  public NeedClassAc_ViewBinding(NeedClassAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NeedClassAc_ViewBinding(NeedClassAc target, View source) {
    this.target = target;

    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NeedClassAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerview = null;
    target.refresh = null;
  }
}
