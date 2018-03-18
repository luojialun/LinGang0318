// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.update;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateTunityOneFr_ViewBinding implements Unbinder {
  private UpdateTunityOneFr target;

  private View view2131690003;

  private View view2131690005;

  private View view2131690015;

  private View view2131690001;

  private View view2131690522;

  @UiThread
  public UpdateTunityOneFr_ViewBinding(final UpdateTunityOneFr target, View source) {
    this.target = target;

    View view;
    target.tvKehu = Utils.findRequiredViewAsType(source, R.id.tv_kehu, "field 'tvKehu'", TextView.class);
    target.tvCh = Utils.findRequiredViewAsType(source, R.id.tv_ch, "field 'tvCh'", TextView.class);
    target.rgZc = Utils.findRequiredViewAsType(source, R.id.rg_zc, "field 'rgZc'", RadioGroup.class);
    target.imgName = Utils.findRequiredViewAsType(source, R.id.img_name, "field 'imgName'", ImageView.class);
    target.etNum = Utils.findRequiredViewAsType(source, R.id.et_num, "field 'etNum'", TextView.class);
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'etName'", EditText.class);
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", EditText.class);
    target.rbZc = Utils.findRequiredViewAsType(source, R.id.rb_zc, "field 'rbZc'", RadioButton.class);
    target.etGsname = Utils.findRequiredViewAsType(source, R.id.et_gsname, "field 'etGsname'", EditText.class);
    target.etMail = Utils.findRequiredViewAsType(source, R.id.et_mail, "field 'etMail'", EditText.class);
    target.editText = Utils.findRequiredViewAsType(source, R.id.editText, "field 'editText'", EditText.class);
    target.scLl = Utils.findRequiredViewAsType(source, R.id.sc_ll, "field 'scLl'", ScrollView.class);
    target.titleTv = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'titleTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_keh, "method 'onViewClicked'");
    view2131690003 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_chengh, "method 'onViewClicked'");
    view2131690005 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_next, "method 'onViewClicked'");
    view2131690015 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_contacts, "method 'onViewClicked'");
    view2131690001 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ib_left, "method 'onViewClicked'");
    view2131690522 = view;
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
    UpdateTunityOneFr target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvKehu = null;
    target.tvCh = null;
    target.rgZc = null;
    target.imgName = null;
    target.etNum = null;
    target.etName = null;
    target.etPhone = null;
    target.rbZc = null;
    target.etGsname = null;
    target.etMail = null;
    target.editText = null;
    target.scLl = null;
    target.titleTv = null;

    view2131690003.setOnClickListener(null);
    view2131690003 = null;
    view2131690005.setOnClickListener(null);
    view2131690005 = null;
    view2131690015.setOnClickListener(null);
    view2131690015 = null;
    view2131690001.setOnClickListener(null);
    view2131690001 = null;
    view2131690522.setOnClickListener(null);
    view2131690522 = null;
  }
}
