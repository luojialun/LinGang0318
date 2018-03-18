// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonInfoActivity_ViewBinding implements Unbinder {
  private PersonInfoActivity target;

  private View view2131689907;

  private View view2131689913;

  private View view2131689915;

  private View view2131689917;

  private View view2131689918;

  private View view2131689910;

  private View view2131689911;

  private View view2131689912;

  @UiThread
  public PersonInfoActivity_ViewBinding(PersonInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonInfoActivity_ViewBinding(final PersonInfoActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_userhead, "field 'imgUserhead' and method 'onViewClicked'");
    target.imgUserhead = Utils.castView(view, R.id.img_userhead, "field 'imgUserhead'", ImageView.class);
    view2131689907 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tvUsername = Utils.findRequiredViewAsType(source, R.id.tv_username, "field 'tvUsername'", TextView.class);
    target.tvUserstation = Utils.findRequiredViewAsType(source, R.id.tv_userstation, "field 'tvUserstation'", TextView.class);
    target.tvHomeline = Utils.findRequiredViewAsType(source, R.id.tv_homeline, "field 'tvHomeline'", TextView.class);
    target.tvDirectline = Utils.findRequiredViewAsType(source, R.id.tv_directline, "field 'tvDirectline'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    target.tvEmail = Utils.findRequiredViewAsType(source, R.id.tv_email, "field 'tvEmail'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_neix, "method 'onViewClicked'");
    view2131689913 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_zhix, "method 'onViewClicked'");
    view2131689915 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_phone, "method 'onViewClicked'");
    view2131689917 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_email, "method 'onViewClicked'");
    view2131689918 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_msg, "method 'onViewClicked'");
    view2131689910 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_phone, "method 'onViewClicked'");
    view2131689911 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_email, "method 'onViewClicked'");
    view2131689912 = view;
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
    PersonInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgUserhead = null;
    target.tvUsername = null;
    target.tvUserstation = null;
    target.tvHomeline = null;
    target.tvDirectline = null;
    target.tvPhone = null;
    target.tvEmail = null;

    view2131689907.setOnClickListener(null);
    view2131689907 = null;
    view2131689913.setOnClickListener(null);
    view2131689913 = null;
    view2131689915.setOnClickListener(null);
    view2131689915 = null;
    view2131689917.setOnClickListener(null);
    view2131689917 = null;
    view2131689918.setOnClickListener(null);
    view2131689918 = null;
    view2131689910.setOnClickListener(null);
    view2131689910 = null;
    view2131689911.setOnClickListener(null);
    view2131689911 = null;
    view2131689912.setOnClickListener(null);
    view2131689912 = null;
  }
}
