// Generated code from Butter Knife. Do not modify!
package com.lingang.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.AlignTextView;
import com.lingang.view.ExtraListView;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.next.tagview.TagCloudView;

public class PartnerDetailsAc_ViewBinding implements Unbinder {
  private PartnerDetailsAc target;

  private View view2131689658;

  private View view2131689900;

  @UiThread
  public PartnerDetailsAc_ViewBinding(PartnerDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PartnerDetailsAc_ViewBinding(final PartnerDetailsAc target, View source) {
    this.target = target;

    View view;
    target.imgEntry = Utils.findRequiredViewAsType(source, R.id.img_entry, "field 'imgEntry'", ImageView.class);
    target.tvEntry = Utils.findRequiredViewAsType(source, R.id.tv_entry, "field 'tvEntry'", TextView.class);
    target.tvEntryLable = Utils.findRequiredViewAsType(source, R.id.tv_entry_lable, "field 'tvEntryLable'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_intro, "field 'llIntro' and method 'onViewClicked'");
    target.llIntro = Utils.castView(view, R.id.ll_intro, "field 'llIntro'", TextView.class);
    view2131689658 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.contentGroup = Utils.findRequiredViewAsType(source, R.id.content_group, "field 'contentGroup'", AlignTextView.class);
    target.tvJt = Utils.findRequiredViewAsType(source, R.id.tv_jt, "field 'tvJt'", TextView.class);
    target.tvJtclass = Utils.findRequiredViewAsType(source, R.id.tv_jtclass, "field 'tvJtclass'", TextView.class);
    target.tvDw = Utils.findRequiredViewAsType(source, R.id.tv_dw, "field 'tvDw'", TextView.class);
    target.tvXytime = Utils.findRequiredViewAsType(source, R.id.tv_xytime, "field 'tvXytime'", TextView.class);
    target.lvPer = Utils.findRequiredViewAsType(source, R.id.lv_per, "field 'lvPer'", ExtraListView.class);
    target.tvGs = Utils.findRequiredViewAsType(source, R.id.tv_gs, "field 'tvGs'", TextView.class);
    target.tvData = Utils.findRequiredViewAsType(source, R.id.tv_data, "field 'tvData'", TextView.class);
    target.tfTj = Utils.findRequiredViewAsType(source, R.id.tf_tj, "field 'tfTj'", TagCloudView.class);
    target.llGs = Utils.findRequiredViewAsType(source, R.id.ll_gs, "field 'llGs'", LinearLayout.class);
    target.tvPj = Utils.findRequiredViewAsType(source, R.id.tv_pj, "field 'tvPj'", AlignTextView.class);
    view = Utils.findRequiredView(source, R.id.tv_xmpj, "field 'tvXmpj' and method 'onViewClicked'");
    target.tvXmpj = Utils.castView(view, R.id.tv_xmpj, "field 'tvXmpj'", TextView.class);
    view2131689900 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llTag = Utils.findRequiredViewAsType(source, R.id.ll_tag, "field 'llTag'", LinearLayout.class);
    target.perSta = Utils.findRequiredViewAsType(source, R.id.per_sta, "field 'perSta'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PartnerDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgEntry = null;
    target.tvEntry = null;
    target.tvEntryLable = null;
    target.llIntro = null;
    target.contentGroup = null;
    target.tvJt = null;
    target.tvJtclass = null;
    target.tvDw = null;
    target.tvXytime = null;
    target.lvPer = null;
    target.tvGs = null;
    target.tvData = null;
    target.tfTj = null;
    target.llGs = null;
    target.tvPj = null;
    target.tvXmpj = null;
    target.llTag = null;
    target.perSta = null;

    view2131689658.setOnClickListener(null);
    view2131689658 = null;
    view2131689900.setOnClickListener(null);
    view2131689900 = null;
  }
}
