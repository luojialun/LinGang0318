// Generated code from Butter Knife. Do not modify!
package com.lingang.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactsSelectTypeDialog$ViewHolder_ViewBinding implements Unbinder {
  private ContactsSelectTypeDialog.ViewHolder target;

  @UiThread
  public ContactsSelectTypeDialog$ViewHolder_ViewBinding(ContactsSelectTypeDialog.ViewHolder target,
      View source) {
    this.target = target;

    target.contactItemIconTxt = Utils.findRequiredViewAsType(source, R.id.contact_item_icon_txt, "field 'contactItemIconTxt'", ImageView.class);
    target.contactItemTxt = Utils.findRequiredViewAsType(source, R.id.contact_item_txt, "field 'contactItemTxt'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactsSelectTypeDialog.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contactItemIconTxt = null;
    target.contactItemTxt = null;
  }
}
