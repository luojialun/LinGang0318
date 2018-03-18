// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.ProgressWebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebAc_ViewBinding implements Unbinder {
  private WebAc target;

  @UiThread
  public WebAc_ViewBinding(WebAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebAc_ViewBinding(WebAc target, View source) {
    this.target = target;

    target.webView = Utils.findRequiredViewAsType(source, R.id.wv_more, "field 'webView'", ProgressWebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webView = null;
  }
}
