// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ExtraListView;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.next.tagview.TagCloudView;

public class PolicyDetialesAc_ViewBinding implements Unbinder {
  private PolicyDetialesAc target;

  private View view2131689847;

  @UiThread
  public PolicyDetialesAc_ViewBinding(PolicyDetialesAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PolicyDetialesAc_ViewBinding(final PolicyDetialesAc target, View source) {
    this.target = target;

    View view;
    target.tvPoliTitle = Utils.findRequiredViewAsType(source, R.id.tv_poli_title, "field 'tvPoliTitle'", TextView.class);
    target.tvPoliData = Utils.findRequiredViewAsType(source, R.id.tv_poli_data, "field 'tvPoliData'", TextView.class);
    target.tvPoliContent = Utils.findRequiredViewAsType(source, R.id.tv_poli_content, "field 'tvPoliContent'", TextView.class);
    target.lvCail = Utils.findRequiredViewAsType(source, R.id.lv_cail, "field 'lvCail'", ExtraListView.class);
    target.scPoli = Utils.findRequiredViewAsType(source, R.id.sc_poli, "field 'scPoli'", ScrollView.class);
    target.imgRelease = Utils.findRequiredViewAsType(source, R.id.img_release, "field 'imgRelease'", ImageView.class);
    target.tvPoliGs = Utils.findRequiredViewAsType(source, R.id.tv_poli_gs, "field 'tvPoliGs'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_watch, "field 'ivWatch' and method 'onViewClicked'");
    target.ivWatch = Utils.castView(view, R.id.iv_watch, "field 'ivWatch'", ImageView.class);
    view2131689847 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.pcLable = Utils.findRequiredViewAsType(source, R.id.pc_lable, "field 'pcLable'", TagCloudView.class);
    target.llFile = Utils.findRequiredViewAsType(source, R.id.ll_file, "field 'llFile'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PolicyDetialesAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvPoliTitle = null;
    target.tvPoliData = null;
    target.tvPoliContent = null;
    target.lvCail = null;
    target.scPoli = null;
    target.imgRelease = null;
    target.tvPoliGs = null;
    target.ivWatch = null;
    target.pcLable = null;
    target.llFile = null;

    view2131689847.setOnClickListener(null);
    view2131689847 = null;
  }
}
