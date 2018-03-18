// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

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
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserFragment_ViewBinding implements Unbinder {
  private UserFragment target;

  private View view2131690522;

  private View view2131690123;

  private View view2131690205;

  private View view2131690206;

  private View view2131690208;

  private View view2131690209;

  private View view2131690211;

  private View view2131690200;

  private View view2131690201;

  private View view2131690210;

  private View view2131690207;

  @UiThread
  public UserFragment_ViewBinding(final UserFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ib_left, "field 'ibLeft' and method 'onViewClicked'");
    target.ibLeft = Utils.castView(view, R.id.ib_left, "field 'ibLeft'", ImageView.class);
    view2131690522 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_title, "field 'tvTitle' and method 'onViewClicked'");
    target.tvTitle = Utils.castView(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view2131690123 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mine_modify, "field 'mineModify' and method 'onViewClicked'");
    target.mineModify = Utils.castView(view, R.id.mine_modify, "field 'mineModify'", SettingItem.class);
    view2131690205 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mine_favorites, "field 'mineFavorites' and method 'onViewClicked'");
    target.mineFavorites = Utils.castView(view, R.id.mine_favorites, "field 'mineFavorites'", SettingItem.class);
    view2131690206 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mine_download_manage, "field 'mineDownloadManage' and method 'onViewClicked'");
    target.mineDownloadManage = Utils.castView(view, R.id.mine_download_manage, "field 'mineDownloadManage'", SettingItem.class);
    view2131690208 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mine_suggest_feed, "field 'mineSuggestFeed' and method 'onViewClicked'");
    target.mineSuggestFeed = Utils.castView(view, R.id.mine_suggest_feed, "field 'mineSuggestFeed'", SettingItem.class);
    view2131690209 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mine_setting, "field 'mineSetting' and method 'onViewClicked'");
    target.mineSetting = Utils.castView(view, R.id.mine_setting, "field 'mineSetting'", SettingItem.class);
    view2131690211 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.user_info_ll, "field 'userInfoLl' and method 'onViewClicked'");
    target.userInfoLl = Utils.castView(view, R.id.user_info_ll, "field 'userInfoLl'", LinearLayout.class);
    view2131690200 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.user_icon, "field 'userIcon' and method 'onViewClicked'");
    target.userIcon = Utils.castView(view, R.id.user_icon, "field 'userIcon'", ImageView.class);
    view2131690201 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mineUserNameTv = Utils.findRequiredViewAsType(source, R.id.mine_user_name_tv, "field 'mineUserNameTv'", TextView.class);
    target.mineUserCompanyTv = Utils.findRequiredViewAsType(source, R.id.mine_user_company_tv, "field 'mineUserCompanyTv'", TextView.class);
    target.mineUserNick = Utils.findRequiredViewAsType(source, R.id.mine_user_nick, "field 'mineUserNick'", TextView.class);
    view = Utils.findRequiredView(source, R.id.mine_share, "field 'mineShare' and method 'onViewClicked'");
    target.mineShare = Utils.castView(view, R.id.mine_share, "field 'mineShare'", SettingItem.class);
    view2131690210 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mine_record, "method 'onViewClicked'");
    view2131690207 = view;
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
    UserFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ibLeft = null;
    target.tvTitle = null;
    target.mineModify = null;
    target.mineFavorites = null;
    target.mineDownloadManage = null;
    target.mineSuggestFeed = null;
    target.mineSetting = null;
    target.refresh = null;
    target.userInfoLl = null;
    target.userIcon = null;
    target.mineUserNameTv = null;
    target.mineUserCompanyTv = null;
    target.mineUserNick = null;
    target.mineShare = null;

    view2131690522.setOnClickListener(null);
    view2131690522 = null;
    view2131690123.setOnClickListener(null);
    view2131690123 = null;
    view2131690205.setOnClickListener(null);
    view2131690205 = null;
    view2131690206.setOnClickListener(null);
    view2131690206 = null;
    view2131690208.setOnClickListener(null);
    view2131690208 = null;
    view2131690209.setOnClickListener(null);
    view2131690209 = null;
    view2131690211.setOnClickListener(null);
    view2131690211 = null;
    view2131690200.setOnClickListener(null);
    view2131690200 = null;
    view2131690201.setOnClickListener(null);
    view2131690201 = null;
    view2131690210.setOnClickListener(null);
    view2131690210 = null;
    view2131690207.setOnClickListener(null);
    view2131690207 = null;
  }
}
