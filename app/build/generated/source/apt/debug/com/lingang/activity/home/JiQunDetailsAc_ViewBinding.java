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

public class JiQunDetailsAc_ViewBinding implements Unbinder {
  private JiQunDetailsAc target;

  private View view2131690111;

  private View view2131689659;

  private View view2131689673;

  @UiThread
  public JiQunDetailsAc_ViewBinding(JiQunDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public JiQunDetailsAc_ViewBinding(final JiQunDetailsAc target, View source) {
    this.target = target;

    View view;
    target.imgGroup = Utils.findRequiredViewAsType(source, R.id.img_group, "field 'imgGroup'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.img_more, "field 'imgMore' and method 'onViewClicked'");
    target.imgMore = Utils.castView(view, R.id.img_more, "field 'imgMore'", ImageView.class);
    view2131690111 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llIntro = Utils.findRequiredViewAsType(source, R.id.ll_intro, "field 'llIntro'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_expand, "field 'imgExpand' and method 'onViewClicked'");
    target.imgExpand = Utils.castView(view, R.id.img_expand, "field 'imgExpand'", ImageView.class);
    view2131689659 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.contentGroup = Utils.findRequiredViewAsType(source, R.id.content_group, "field 'contentGroup'", AlignTextView.class);
    target.tfTj = Utils.findRequiredViewAsType(source, R.id.tf_tj, "field 'tfTj'", TagCloudView.class);
    target.lvZone = Utils.findRequiredViewAsType(source, R.id.lv_zone, "field 'lvZone'", ExtraListView.class);
    target.rvZone = Utils.findRequiredViewAsType(source, R.id.rv_zone, "field 'rvZone'", RecyclerView.class);
    target.lvZoneTeam = Utils.findRequiredViewAsType(source, R.id.lv_zone_team, "field 'lvZoneTeam'", ExtraListView.class);
    target.yuanqNum = Utils.findRequiredViewAsType(source, R.id.yuanq_num, "field 'yuanqNum'", TextView.class);
    target.tvTeamnum = Utils.findRequiredViewAsType(source, R.id.tv_teamnum, "field 'tvTeamnum'", TextView.class);
    target.llTag = Utils.findRequiredViewAsType(source, R.id.ll_tag, "field 'llTag'", LinearLayout.class);
    target.jiqunNum = Utils.findRequiredViewAsType(source, R.id.jiqun_num, "field 'jiqunNum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_moregs, "method 'onViewClicked'");
    view2131689673 = view;
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
    JiQunDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgGroup = null;
    target.imgMore = null;
    target.llIntro = null;
    target.imgExpand = null;
    target.contentGroup = null;
    target.tfTj = null;
    target.lvZone = null;
    target.rvZone = null;
    target.lvZoneTeam = null;
    target.yuanqNum = null;
    target.tvTeamnum = null;
    target.llTag = null;
    target.jiqunNum = null;

    view2131690111.setOnClickListener(null);
    view2131690111 = null;
    view2131689659.setOnClickListener(null);
    view2131689659 = null;
    view2131689673.setOnClickListener(null);
    view2131689673 = null;
  }
}
