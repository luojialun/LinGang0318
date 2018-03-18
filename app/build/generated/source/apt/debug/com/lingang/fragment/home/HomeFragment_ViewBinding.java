// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.view.AutoVerticalScrollTextView;
import com.lingang.view.ExtraGridView;
import com.lingang.view.ExtraListView;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131689801;

  private View view2131690149;

  private View view2131690150;

  private View view2131690153;

  private View view2131690156;

  private View view2131690076;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.logo, "field 'logo' and method 'onViewClicked'");
    target.logo = Utils.castView(view, R.id.logo, "field 'logo'", ImageView.class);
    view2131689801 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.more, "field 'more' and method 'onViewClicked'");
    target.more = Utils.castView(view, R.id.more, "field 'more'", ImageView.class);
    view2131690149 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.banner = Utils.findRequiredViewAsType(source, R.id.home_banner, "field 'banner'", Banner.class);
    target.homeMeg = Utils.findRequiredViewAsType(source, R.id.home_meg, "field 'homeMeg'", ExtraListView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.home_sc = Utils.findRequiredViewAsType(source, R.id.home_sc, "field 'home_sc'", ScrollView.class);
    view = Utils.findRequiredView(source, R.id.home_search_all, "field 'homeSearchAll' and method 'onViewClicked'");
    target.homeSearchAll = Utils.castView(view, R.id.home_search_all, "field 'homeSearchAll'", RelativeLayout.class);
    view2131690150 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toastContent = Utils.findRequiredViewAsType(source, R.id.toast_content, "field 'toastContent'", AutoVerticalScrollTextView.class);
    view = Utils.findRequiredView(source, R.id.ll_switch, "field 'llSwitch' and method 'onViewClicked'");
    target.llSwitch = Utils.castView(view, R.id.ll_switch, "field 'llSwitch'", LinearLayout.class);
    view2131690153 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.yiluodiTv = Utils.findRequiredViewAsType(source, R.id.yiluodi_tv, "field 'yiluodiTv'", TextView.class);
    target.totalTv = Utils.findRequiredViewAsType(source, R.id.total_tv, "field 'totalTv'", TextView.class);
    target.imgState = Utils.findRequiredViewAsType(source, R.id.img_state, "field 'imgState'", ImageView.class);
    target.homeGv = Utils.findRequiredViewAsType(source, R.id.home_gv, "field 'homeGv'", ExtraGridView.class);
    target.bannerImg = Utils.findRequiredViewAsType(source, R.id.banner_img, "field 'bannerImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ll_land, "method 'onViewClicked'");
    view2131690156 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_total, "method 'onViewClicked'");
    view2131690076 = view;
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
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.logo = null;
    target.more = null;
    target.banner = null;
    target.homeMeg = null;
    target.refresh = null;
    target.home_sc = null;
    target.homeSearchAll = null;
    target.toastContent = null;
    target.llSwitch = null;
    target.yiluodiTv = null;
    target.totalTv = null;
    target.imgState = null;
    target.homeGv = null;
    target.bannerImg = null;

    view2131689801.setOnClickListener(null);
    view2131689801 = null;
    view2131690149.setOnClickListener(null);
    view2131690149 = null;
    view2131690150.setOnClickListener(null);
    view2131690150 = null;
    view2131690153.setOnClickListener(null);
    view2131690153 = null;
    view2131690156.setOnClickListener(null);
    view2131690156 = null;
    view2131690076.setOnClickListener(null);
    view2131690076 = null;
  }
}
