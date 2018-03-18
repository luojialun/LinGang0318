// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.view.AlignTextView;
import com.lingang.view.CustomCircleProgress;
import com.lingang.view.ExtraListView;
import com.lingang.view.ObservableScrollView;
import com.lingang.view.video.JCVPlayerTitleAfterFull;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GroupAc_ViewBinding implements Unbinder {
  private GroupAc target;

  private View view2131690111;

  private View view2131689659;

  private View view2131689666;

  private View view2131689667;

  private View view2131690551;

  @UiThread
  public GroupAc_ViewBinding(GroupAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GroupAc_ViewBinding(final GroupAc target, View source) {
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
        target.onViewClicked(p0);
      }
    });
    target.contentGroup = Utils.findRequiredViewAsType(source, R.id.content_group, "field 'contentGroup'", AlignTextView.class);
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
    target.lvCail = Utils.findRequiredViewAsType(source, R.id.lv_cail, "field 'lvCail'", ExtraListView.class);
    target.videoplayer = Utils.findRequiredViewAsType(source, R.id.videoplayer, "field 'videoplayer'", JCVPlayerTitleAfterFull.class);
    target.tvVdtitle = Utils.findRequiredViewAsType(source, R.id.tv_vdtitle, "field 'tvVdtitle'", TextView.class);
    target.btnVddown = Utils.findRequiredViewAsType(source, R.id.btn_vddown, "field 'btnVddown'", ImageView.class);
    target.downloadVdprogress = Utils.findRequiredViewAsType(source, R.id.download_vdprogress, "field 'downloadVdprogress'", CustomCircleProgress.class);
    target.llVdinfo = Utils.findRequiredViewAsType(source, R.id.ll_vdinfo, "field 'llVdinfo'", LinearLayout.class);
    target.flScVideo = Utils.findRequiredViewAsType(source, R.id.fl_sc_video, "field 'flScVideo'", LinearLayout.class);
    target.scGroup = Utils.findRequiredViewAsType(source, R.id.sc_group, "field 'scGroup'", ObservableScrollView.class);
    target.refreshlayout = Utils.findRequiredViewAsType(source, R.id.refreshlayout, "field 'refreshlayout'", TwinklingRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.vd_share, "method 'onViewClicked'");
    view2131690551 = view;
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
    GroupAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgGroup = null;
    target.imgMore = null;
    target.llIntro = null;
    target.imgExpand = null;
    target.contentGroup = null;
    target.tvMap = null;
    target.tvPhone = null;
    target.tvComp = null;
    target.lvCail = null;
    target.videoplayer = null;
    target.tvVdtitle = null;
    target.btnVddown = null;
    target.downloadVdprogress = null;
    target.llVdinfo = null;
    target.flScVideo = null;
    target.scGroup = null;
    target.refreshlayout = null;

    view2131690111.setOnClickListener(null);
    view2131690111 = null;
    view2131689659.setOnClickListener(null);
    view2131689659 = null;
    view2131689666.setOnClickListener(null);
    view2131689666 = null;
    view2131689667.setOnClickListener(null);
    view2131689667 = null;
    view2131690551.setOnClickListener(null);
    view2131690551 = null;
  }
}
