// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.contacts;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactsCompanyAc_ViewBinding implements Unbinder {
  private ContactsCompanyAc target;

  @UiThread
  public ContactsCompanyAc_ViewBinding(ContactsCompanyAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactsCompanyAc_ViewBinding(ContactsCompanyAc target, View source) {
    this.target = target;

    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactsCompanyAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerview = null;
    target.refresh = null;
  }
}