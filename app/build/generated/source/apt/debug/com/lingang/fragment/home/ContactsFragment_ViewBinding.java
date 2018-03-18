// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.home;

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

public class ContactsFragment_ViewBinding implements Unbinder {
  private ContactsFragment target;

  @UiThread
  public ContactsFragment_ViewBinding(ContactsFragment target, View source) {
    this.target = target;

    target.contactsRecyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'contactsRecyclerview'", RecyclerView.class);
    target.contactsRefresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'contactsRefresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contactsRecyclerview = null;
    target.contactsRefresh = null;
  }
}
