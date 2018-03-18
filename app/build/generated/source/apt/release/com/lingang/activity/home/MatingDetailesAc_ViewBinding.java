// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
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

public class MatingDetailesAc_ViewBinding implements Unbinder {
  private MatingDetailesAc target;

  private View view2131689659;

  private View view2131689666;

  private View view2131689667;

  private View view2131689816;

  @UiThread
  public MatingDetailesAc_ViewBinding(MatingDetailesAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MatingDetailesAc_ViewBinding(final MatingDetailesAc target, View source) {
    this.target = target;

    View view;
    target.imgEntry = Utils.findRequiredViewAsType(source, R.id.img_entry, "field 'imgEntry'", ImageView.class);
    target.tvEntry = Utils.findRequiredViewAsType(source, R.id.tv_entry, "field 'tvEntry'", TextView.class);
    target.tvEntryLable = Utils.findRequiredViewAsType(source, R.id.tv_entry_lable, "field 'tvEntryLable'", TextView.class);
    target.llIntro = Utils.findRequiredViewAsType(source, R.id.ll_intro, "field 'llIntro'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_expand, "field 'imgExpand' and method 'onViewClicked'");
    target.imgExpand = Utils.castView(view, R.id.img_expand, "field 'imgExpand'", ImageView.class);
    view2131689659 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.contentGroup = Utils.findRequiredViewAsType(source, R.id.content_group, "field 'contentGroup'", AlignTextView.class);
    target.tfTj = Utils.findRequiredViewAsType(source, R.id.tf_tj, "field 'tfTj'", TagCloudView.class);
    target.tvFwClass = Utils.findRequiredViewAsType(source, R.id.tv_fwClass, "field 'tvFwClass'", TextView.class);
    target.tvFwprj = Utils.findRequiredViewAsType(source, R.id.tv_fwprj, "field 'tvFwprj'", AlignTextView.class);
    target.rvZone = Utils.findRequiredViewAsType(source, R.id.rv_zone, "field 'rvZone'", RecyclerView.class);
    target.tvMap = Utils.findRequiredViewAsType(source, R.id.tv_map, "field 'tvMap'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_phone, "field 'tvPhone' and method 'onViewClicked'");
    target.tvPhone = Utils.castView(view, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    view2131689666 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_comp, "field 'tvComp' and method 'onViewClicked'");
    target.tvComp = Utils.castView(view, R.id.tv_comp, "field 'tvComp'", TextView.class);
    view2131689667 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.lvPer = Utils.findRequiredViewAsType(source, R.id.lv_per, "field 'lvPer'", ExtraListView.class);
    target.tvGs = Utils.findRequiredViewAsType(source, R.id.tv_gs, "field 'tvGs'", TextView.class);
    target.tvData = Utils.findRequiredViewAsType(source, R.id.tv_data, "field 'tvData'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_service, "field 'imgService' and method 'onViewClicked'");
    target.imgService = Utils.castView(view, R.id.img_service, "field 'imgService'", ImageView.class);
    view2131689816 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llTag = Utils.findRequiredViewAsType(source, R.id.ll_tag, "field 'llTag'", LinearLayout.class);
    target.tvYqnum = Utils.findRequiredViewAsType(source, R.id.tv_yqnum, "field 'tvYqnum'", TextView.class);
    target.perSta = Utils.findRequiredViewAsType(source, R.id.per_sta, "field 'perSta'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MatingDetailesAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgEntry = null;
    target.tvEntry = null;
    target.tvEntryLable = null;
    target.llIntro = null;
    target.imgExpand = null;
    target.contentGroup = null;
    target.tfTj = null;
    target.tvFwClass = null;
    target.tvFwprj = null;
    target.rvZone = null;
    target.tvMap = null;
    target.tvPhone = null;
    target.tvComp = null;
    target.lvPer = null;
    target.tvGs = null;
    target.tvData = null;
    target.imgService = null;
    target.llTag = null;
    target.tvYqnum = null;
    target.perSta = null;

    view2131689659.setOnClickListener(null);
    view2131689659 = null;
    view2131689666.setOnClickListener(null);
    view2131689666 = null;
    view2131689667.setOnClickListener(null);
    view2131689667 = null;
    view2131689816.setOnClickListener(null);
    view2131689816 = null;
  }
}
