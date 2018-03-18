// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserSettingAc_ViewBinding implements Unbinder {
  private UserSettingAc target;

  private View view2131689960;

  private View view2131689964;

  private View view2131689965;

  private View view2131689966;

  private View view2131689968;

  private View view2131689967;

  @UiThread
  public UserSettingAc_ViewBinding(UserSettingAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserSettingAc_ViewBinding(final UserSettingAc target, View source) {
    this.target = target;

    View view;
    target.settingUserIcon = Utils.findRequiredViewAsType(source, R.id.setting_user_icon, "field 'settingUserIcon'", ImageView.class);
    target.settingUserNameTv = Utils.findRequiredViewAsType(source, R.id.setting_user_name_tv, "field 'settingUserNameTv'", TextView.class);
    target.settingUserCompanyTv = Utils.findRequiredViewAsType(source, R.id.setting_user_company_tv, "field 'settingUserCompanyTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.setting_user_details_rl, "field 'settingUserDetailsRl' and method 'onViewClicked'");
    target.settingUserDetailsRl = Utils.castView(view, R.id.setting_user_details_rl, "field 'settingUserDetailsRl'", RelativeLayout.class);
    view2131689960 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.setting_gesture, "field 'settingGesture' and method 'onViewClicked'");
    target.settingGesture = Utils.castView(view, R.id.setting_gesture, "field 'settingGesture'", SettingItem.class);
    view2131689964 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.setting_clear_cache, "field 'settingClearCache' and method 'onViewClicked'");
    target.settingClearCache = Utils.castView(view, R.id.setting_clear_cache, "field 'settingClearCache'", SettingItem.class);
    view2131689965 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.setting_check_updater, "field 'settingCheckUpdater' and method 'onViewClicked'");
    target.settingCheckUpdater = Utils.castView(view, R.id.setting_check_updater, "field 'settingCheckUpdater'", SettingItem.class);
    view2131689966 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.setting_exit_login_tv, "field 'settingExitLoginTv' and method 'onViewClicked'");
    target.settingExitLoginTv = Utils.castView(view, R.id.setting_exit_login_tv, "field 'settingExitLoginTv'", TextView.class);
    view2131689968 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.setting_version_record, "field 'settingVersionRecord' and method 'onViewClicked'");
    target.settingVersionRecord = Utils.castView(view, R.id.setting_version_record, "field 'settingVersionRecord'", SettingItem.class);
    view2131689967 = view;
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
    UserSettingAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.settingUserIcon = null;
    target.settingUserNameTv = null;
    target.settingUserCompanyTv = null;
    target.settingUserDetailsRl = null;
    target.settingGesture = null;
    target.settingClearCache = null;
    target.settingCheckUpdater = null;
    target.settingExitLoginTv = null;
    target.settingVersionRecord = null;

    view2131689960.setOnClickListener(null);
    view2131689960 = null;
    view2131689964.setOnClickListener(null);
    view2131689964 = null;
    view2131689965.setOnClickListener(null);
    view2131689965 = null;
    view2131689966.setOnClickListener(null);
    view2131689966 = null;
    view2131689968.setOnClickListener(null);
    view2131689968 = null;
    view2131689967.setOnClickListener(null);
    view2131689967 = null;
  }
}
