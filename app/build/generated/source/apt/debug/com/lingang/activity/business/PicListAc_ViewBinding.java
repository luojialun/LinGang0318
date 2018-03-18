// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PicListAc_ViewBinding implements Unbinder {
  private PicListAc target;

  @UiThread
  public PicListAc_ViewBinding(PicListAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PicListAc_ViewBinding(PicListAc target, View source) {
    this.target = target;

    target.tbPic = Utils.findRequiredViewAsType(source, R.id.tb_pic, "field 'tbPic'", TabLayout.class);
    target.vpPci = Utils.findRequiredViewAsType(source, R.id.vp_pci, "field 'vpPci'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PicListAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tbPic = null;
    target.vpPci = null;
  }
}
