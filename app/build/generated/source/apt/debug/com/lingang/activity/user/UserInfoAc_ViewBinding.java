// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.view.CircleImageView;
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserInfoAc_ViewBinding implements Unbinder {
  private UserInfoAc target;

  private View view2131690058;

  private View view2131690054;

  @UiThread
  public UserInfoAc_ViewBinding(UserInfoAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserInfoAc_ViewBinding(final UserInfoAc target, View source) {
    this.target = target;

    View view;
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
    target.userNameSt = Utils.findRequiredViewAsType(source, R.id.user_name_st, "field 'userNameSt'", SettingItem.class);
    target.userParkSt = Utils.findRequiredViewAsType(source, R.id.user_park_st, "field 'userParkSt'", SettingItem.class);
    target.userDepSt = Utils.findRequiredViewAsType(source, R.id.user_dep_st, "field 'userDepSt'", SettingItem.class);
    target.userPostSt = Utils.findRequiredViewAsType(source, R.id.user_post_st, "field 'userPostSt'", SettingItem.class);
    target.userTelSt = Utils.findRequiredViewAsType(source, R.id.user_tel_st, "field 'userTelSt'", SettingItem.class);
    target.userMobileSt = Utils.findRequiredViewAsType(source, R.id.user_mobile_st, "field 'userMobileSt'", SettingItem.class);
    target.userEmailSt = Utils.findRequiredViewAsType(source, R.id.user_email_st, "field 'userEmailSt'", SettingItem.class);
    target.userHeadIv = Utils.findRequiredViewAsType(source, R.id.user_head_iv, "field 'userHeadIv'", CircleImageView.class);
    view = Utils.findRequiredView(source, R.id.user_nick_st, "field 'userNickSt' and method 'onViewClicked'");
    target.userNickSt = Utils.castView(view, R.id.user_nick_st, "field 'userNickSt'", SettingItem.class);
    view2131690058 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.select_phone_head, "field 'selectPhoneHead' and method 'onViewClicked'");
    target.selectPhoneHead = Utils.castView(view, R.id.select_phone_head, "field 'selectPhoneHead'", RelativeLayout.class);
    view2131690054 = view;
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
    UserInfoAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.refresh = null;
    target.userNameSt = null;
    target.userParkSt = null;
    target.userDepSt = null;
    target.userPostSt = null;
    target.userTelSt = null;
    target.userMobileSt = null;
    target.userEmailSt = null;
    target.userHeadIv = null;
    target.userNickSt = null;
    target.selectPhoneHead = null;

    view2131690058.setOnClickListener(null);
    view2131690058 = null;
    view2131690054.setOnClickListener(null);
    view2131690054 = null;
  }
}
