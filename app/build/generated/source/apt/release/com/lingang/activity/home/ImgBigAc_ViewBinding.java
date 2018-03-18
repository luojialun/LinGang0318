// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ImgBigAc_ViewBinding implements Unbinder {
  private ImgBigAc target;

  private View view2131689780;

  private View view2131689777;

  @UiThread
  public ImgBigAc_ViewBinding(ImgBigAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ImgBigAc_ViewBinding(final ImgBigAc target, View source) {
    this.target = target;

    View view;
    target.tvNum = Utils.findRequiredViewAsType(source, R.id.tv_num, "field 'tvNum'", TextView.class);
    target.vpPci = Utils.findRequiredViewAsType(source, R.id.vp_pci, "field 'vpPci'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.btn_down, "field 'btnDown' and method 'onViewClicked'");
    target.btnDown = Utils.castView(view, R.id.btn_down, "field 'btnDown'", ImageView.class);
    view2131689780 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_left, "method 'onViewClicked'");
    view2131689777 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ImgBigAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvNum = null;
    target.vpPci = null;
    target.btnDown = null;

    view2131689780.setOnClickListener(null);
    view2131689780 = null;
    view2131689777.setOnClickListener(null);
    view2131689777 = null;
  }
}
