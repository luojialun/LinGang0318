// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ExtraListView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TjTunityThreeAc_ViewBinding implements Unbinder {
  private TjTunityThreeAc target;

  private View view2131689744;

  private View view2131690019;

  private View view2131690023;

  private View view2131690025;

  @UiThread
  public TjTunityThreeAc_ViewBinding(TjTunityThreeAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TjTunityThreeAc_ViewBinding(final TjTunityThreeAc target, View source) {
    this.target = target;

    View view;
    target.imgYq = Utils.findRequiredViewAsType(source, R.id.img_yq, "field 'imgYq'", ImageView.class);
    target.vvLine2 = Utils.findRequiredView(source, R.id.vv_line2, "field 'vvLine2'");
    target.tvYuanq = Utils.findRequiredViewAsType(source, R.id.tv_yuanq, "field 'tvYuanq'", TextView.class);
    target.lvPower = Utils.findRequiredViewAsType(source, R.id.lv_power, "field 'lvPower'", ExtraListView.class);
    target.lvOther = Utils.findRequiredViewAsType(source, R.id.lv_other, "field 'lvOther'", ExtraListView.class);
    target.imgXqInfo = Utils.findRequiredViewAsType(source, R.id.img_xq_info, "field 'imgXqInfo'", ImageView.class);
    target.tvXuq = Utils.findRequiredViewAsType(source, R.id.tv_xuq, "field 'tvXuq'", TextView.class);
    target.tvPower = Utils.findRequiredViewAsType(source, R.id.tv_power, "field 'tvPower'", TextView.class);
    target.tvOther = Utils.findRequiredViewAsType(source, R.id.tv_other, "field 'tvOther'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_comit, "field 'btnComit' and method 'onViewClicked'");
    target.btnComit = Utils.castView(view, R.id.btn_comit, "field 'btnComit'", Button.class);
    view2131689744 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llPower = Utils.findRequiredViewAsType(source, R.id.ll_power, "field 'llPower'", LinearLayout.class);
    target.llOther = Utils.findRequiredViewAsType(source, R.id.ll_other, "field 'llOther'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_power_all, "field 'tvPowerAll' and method 'onViewClicked'");
    target.tvPowerAll = Utils.castView(view, R.id.tv_power_all, "field 'tvPowerAll'", TextView.class);
    view2131690019 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_other_all, "field 'tvOtherAll' and method 'onViewClicked'");
    target.tvOtherAll = Utils.castView(view, R.id.tv_other_all, "field 'tvOtherAll'", TextView.class);
    view2131690023 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_look, "method 'onViewClicked'");
    view2131690025 = view;
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
    TjTunityThreeAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgYq = null;
    target.vvLine2 = null;
    target.tvYuanq = null;
    target.lvPower = null;
    target.lvOther = null;
    target.imgXqInfo = null;
    target.tvXuq = null;
    target.tvPower = null;
    target.tvOther = null;
    target.btnComit = null;
    target.llPower = null;
    target.llOther = null;
    target.tvPowerAll = null;
    target.tvOtherAll = null;

    view2131689744.setOnClickListener(null);
    view2131689744 = null;
    view2131690019.setOnClickListener(null);
    view2131690019 = null;
    view2131690023.setOnClickListener(null);
    view2131690023 = null;
    view2131690025.setOnClickListener(null);
    view2131690025 = null;
  }
}
