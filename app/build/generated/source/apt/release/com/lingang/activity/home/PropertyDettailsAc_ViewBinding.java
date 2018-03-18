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
import com.lingang.view.CustomCircleProgress;
import com.lingang.view.ExtraListView;
import com.lingang.view.video.JCVPlayerTitleAfterFull;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.next.tagview.TagCloudView;

public class PropertyDettailsAc_ViewBinding implements Unbinder {
  private PropertyDettailsAc target;

  private View view2131690110;

  private View view2131690111;

  private View view2131689659;

  private View view2131689666;

  private View view2131690112;

  private View view2131689667;

  private View view2131690551;

  @UiThread
  public PropertyDettailsAc_ViewBinding(PropertyDettailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PropertyDettailsAc_ViewBinding(final PropertyDettailsAc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_group, "field 'imgGroup' and method 'onViewClicked'");
    target.imgGroup = Utils.castView(view, R.id.img_group, "field 'imgGroup'", ImageView.class);
    view2131690110 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
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
    target.tvClass = Utils.findRequiredViewAsType(source, R.id.tv_class, "field 'tvClass'", TextView.class);
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
    target.lvCail = Utils.findRequiredViewAsType(source, R.id.lv_cail, "field 'lvCail'", ExtraListView.class);
    target.videoplayer = Utils.findRequiredViewAsType(source, R.id.videoplayer, "field 'videoplayer'", JCVPlayerTitleAfterFull.class);
    target.tvVdtitle = Utils.findRequiredViewAsType(source, R.id.tv_vdtitle, "field 'tvVdtitle'", TextView.class);
    target.btnVddown = Utils.findRequiredViewAsType(source, R.id.btn_vddown, "field 'btnVddown'", ImageView.class);
    target.downloadVdprogress = Utils.findRequiredViewAsType(source, R.id.download_vdprogress, "field 'downloadVdprogress'", CustomCircleProgress.class);
    target.llVdinfo = Utils.findRequiredViewAsType(source, R.id.ll_vdinfo, "field 'llVdinfo'", LinearLayout.class);
    target.lvPer = Utils.findRequiredViewAsType(source, R.id.lv_per, "field 'lvPer'", ExtraListView.class);
    target.tvGs = Utils.findRequiredViewAsType(source, R.id.tv_gs, "field 'tvGs'", TextView.class);
    target.tvData = Utils.findRequiredViewAsType(source, R.id.tv_data, "field 'tvData'", TextView.class);
    target.flScVideo = Utils.findRequiredViewAsType(source, R.id.fl_sc_video, "field 'flScVideo'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_pic, "field 'tvPic' and method 'onViewClicked'");
    target.tvPic = Utils.castView(view, R.id.tv_pic, "field 'tvPic'", TextView.class);
    view2131690112 = view;
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
    target.tvState = Utils.findRequiredViewAsType(source, R.id.tv_state, "field 'tvState'", TextView.class);
    target.tvMs = Utils.findRequiredViewAsType(source, R.id.tv_ms, "field 'tvMs'", TextView.class);
    target.tvCompan = Utils.findRequiredViewAsType(source, R.id.tv_compan, "field 'tvCompan'", TextView.class);
    target.tvPerdata = Utils.findRequiredViewAsType(source, R.id.tv_perdata, "field 'tvPerdata'", TextView.class);
    target.llTag = Utils.findRequiredViewAsType(source, R.id.ll_tag, "field 'llTag'", LinearLayout.class);
    target.tvcailState = Utils.findRequiredViewAsType(source, R.id.tvcail_state, "field 'tvcailState'", TextView.class);
    target.tvpState = Utils.findRequiredViewAsType(source, R.id.tvp_state, "field 'tvpState'", TextView.class);
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
    PropertyDettailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgGroup = null;
    target.imgMore = null;
    target.llIntro = null;
    target.imgExpand = null;
    target.contentGroup = null;
    target.tfTj = null;
    target.tvClass = null;
    target.rvZone = null;
    target.tvMap = null;
    target.tvPhone = null;
    target.lvCail = null;
    target.videoplayer = null;
    target.tvVdtitle = null;
    target.btnVddown = null;
    target.downloadVdprogress = null;
    target.llVdinfo = null;
    target.lvPer = null;
    target.tvGs = null;
    target.tvData = null;
    target.flScVideo = null;
    target.tvPic = null;
    target.tvComp = null;
    target.tvState = null;
    target.tvMs = null;
    target.tvCompan = null;
    target.tvPerdata = null;
    target.llTag = null;
    target.tvcailState = null;
    target.tvpState = null;

    view2131690110.setOnClickListener(null);
    view2131690110 = null;
    view2131690111.setOnClickListener(null);
    view2131690111 = null;
    view2131689659.setOnClickListener(null);
    view2131689659 = null;
    view2131689666.setOnClickListener(null);
    view2131689666 = null;
    view2131690112.setOnClickListener(null);
    view2131690112 = null;
    view2131689667.setOnClickListener(null);
    view2131689667 = null;
    view2131690551.setOnClickListener(null);
    view2131690551 = null;
  }
}
