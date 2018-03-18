// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginAc_ViewBinding implements Unbinder {
  private LoginAc target;

  private View view2131689805;

  private View view2131689806;

  @UiThread
  public LoginAc_ViewBinding(LoginAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginAc_ViewBinding(final LoginAc target, View source) {
    this.target = target;

    View view;
    target.loginPhone = Utils.findRequiredViewAsType(source, R.id.login_phone, "field 'loginPhone'", EditText.class);
    target.loginPsw = Utils.findRequiredViewAsType(source, R.id.login_psw, "field 'loginPsw'", EditText.class);
    target.loginCode = Utils.findRequiredViewAsType(source, R.id.login_code, "field 'loginCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_code, "field 'btnCode' and method 'onViewClicked'");
    target.btnCode = Utils.castView(view, R.id.btn_code, "field 'btnCode'", TextView.class);
    view2131689805 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_login, "field 'btnLogin' and method 'onViewClicked'");
    target.btnLogin = Utils.castView(view, R.id.btn_login, "field 'btnLogin'", Button.class);
    view2131689806 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rootView = Utils.findRequiredViewAsType(source, R.id.root_view, "field 'rootView'", LinearLayout.class);
    target.contentView = Utils.findRequiredViewAsType(source, R.id.content_view, "field 'contentView'", LinearLayout.class);
    target.logo = Utils.findRequiredViewAsType(source, R.id.logo, "field 'logo'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.loginPhone = null;
    target.loginPsw = null;
    target.loginCode = null;
    target.btnCode = null;
    target.btnLogin = null;
    target.rootView = null;
    target.contentView = null;
    target.logo = null;

    view2131689805.setOnClickListener(null);
    view2131689805 = null;
    view2131689806.setOnClickListener(null);
    view2131689806 = null;
  }
}
