// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.contacts;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.flyco.tablayout.CommonTabLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactsAc_ViewBinding implements Unbinder {
  private ContactsAc target;

  @UiThread
  public ContactsAc_ViewBinding(ContactsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactsAc_ViewBinding(ContactsAc target, View source) {
    this.target = target;

    target.contactsTabTitle = Utils.findRequiredViewAsType(source, R.id.contacts_tab_title, "field 'contactsTabTitle'", CommonTabLayout.class);
    target.contactsViewPager = Utils.findRequiredViewAsType(source, R.id.contacts_viewPager, "field 'contactsViewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contactsTabTitle = null;
    target.contactsViewPager = null;
  }
}
