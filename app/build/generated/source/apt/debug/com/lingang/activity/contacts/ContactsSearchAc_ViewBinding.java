// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.contacts;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactsSearchAc_ViewBinding implements Unbinder {
  private ContactsSearchAc target;

  private View view2131690522;

  private View view2131690576;

  private View view2131690578;

  @UiThread
  public ContactsSearchAc_ViewBinding(ContactsSearchAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactsSearchAc_ViewBinding(final ContactsSearchAc target, View source) {
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
    view = Utils.findRequiredView(source, R.id.contact_select_name, "field 'contactSelectName' and method 'onViewClicked'");
    target.contactSelectName = Utils.castView(view, R.id.contact_select_name, "field 'contactSelectName'", TextView.class);
    view2131690576 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.searchInputEd = Utils.findRequiredViewAsType(source, R.id.search_input_ed, "field 'searchInputEd'", EditText.class);
    target.searchToolbar = Utils.findRequiredViewAsType(source, R.id.search_toolbar, "field 'searchToolbar'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.contact_search_iv, "field 'contactSearchIv' and method 'onViewClicked'");
    target.contactSearchIv = Utils.castView(view, R.id.contact_search_iv, "field 'contactSearchIv'", ImageView.class);
    view2131690578 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNewsnum = Utils.findRequiredViewAsType(source, R.id.tv_newsnum, "field 'tvNewsnum'", TextView.class);
    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", TwinklingRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactsSearchAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ibLeft = null;
    target.contactSelectName = null;
    target.searchInputEd = null;
    target.searchToolbar = null;
    target.contactSearchIv = null;
    target.tvNewsnum = null;
    target.recyclerview = null;
    target.refresh = null;

    view2131690522.setOnClickListener(null);
    view2131690522 = null;
    view2131690576.setOnClickListener(null);
    view2131690576 = null;
    view2131690578.setOnClickListener(null);
    view2131690578 = null;
  }
}
