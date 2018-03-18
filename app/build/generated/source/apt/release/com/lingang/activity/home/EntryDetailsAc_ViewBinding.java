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

public class EntryDetailsAc_ViewBinding implements Unbinder {
  private EntryDetailsAc target;

  private View view2131689659;

  private View view2131689723;

  @UiThread
  public EntryDetailsAc_ViewBinding(EntryDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EntryDetailsAc_ViewBinding(final EntryDetailsAc target, View source) {
    this.target = target;

    View view;
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
    target.rvZone = Utils.findRequiredViewAsType(source, R.id.rv_zone, "field 'rvZone'", RecyclerView.class);
    target.imgEntry = Utils.findRequiredViewAsType(source, R.id.img_entry, "field 'imgEntry'", ImageView.class);
    target.tvEntry = Utils.findRequiredViewAsType(source, R.id.tv_entry, "field 'tvEntry'", TextView.class);
    target.tvEntryLable = Utils.findRequiredViewAsType(source, R.id.tv_entry_lable, "field 'tvEntryLable'", TextView.class);
    target.tvXiny = Utils.findRequiredViewAsType(source, R.id.tv_xiny, "field 'tvXiny'", TextView.class);
    target.lvJiqun = Utils.findRequiredViewAsType(source, R.id.lv_jiqun, "field 'lvJiqun'", ExtraListView.class);
    target.lvPer = Utils.findRequiredViewAsType(source, R.id.lv_per, "field 'lvPer'", ExtraListView.class);
    target.tvDw = Utils.findRequiredViewAsType(source, R.id.tv_dw, "field 'tvDw'", TextView.class);
    target.tvData = Utils.findRequiredViewAsType(source, R.id.tv_data, "field 'tvData'", TextView.class);
    target.tvIs = Utils.findRequiredViewAsType(source, R.id.tv_is, "field 'tvIs'", TextView.class);
    target.tvJiqun = Utils.findRequiredViewAsType(source, R.id.tv_jiqun, "field 'tvJiqun'", TextView.class);
    target.llTag = Utils.findRequiredViewAsType(source, R.id.ll_tag, "field 'llTag'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.jiqun_num, "field 'jiqunNum' and method 'onViewClicked'");
    target.jiqunNum = Utils.castView(view, R.id.jiqun_num, "field 'jiqunNum'", TextView.class);
    view2131689723 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.perNum = Utils.findRequiredViewAsType(source, R.id.per_num, "field 'perNum'", TextView.class);
    target.homepageTv = Utils.findRequiredViewAsType(source, R.id.homepage_tv, "field 'homepageTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EntryDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llIntro = null;
    target.imgExpand = null;
    target.contentGroup = null;
    target.tfTj = null;
    target.rvZone = null;
    target.imgEntry = null;
    target.tvEntry = null;
    target.tvEntryLable = null;
    target.tvXiny = null;
    target.lvJiqun = null;
    target.lvPer = null;
    target.tvDw = null;
    target.tvData = null;
    target.tvIs = null;
    target.tvJiqun = null;
    target.llTag = null;
    target.jiqunNum = null;
    target.perNum = null;
    target.homepageTv = null;

    view2131689659.setOnClickListener(null);
    view2131689659 = null;
    view2131689723.setOnClickListener(null);
    view2131689723 = null;
  }
}
