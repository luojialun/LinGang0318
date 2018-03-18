// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SubmitLandReview_ViewBinding implements Unbinder {
  private SubmitLandReview target;

  private View view2131689992;

  private View view2131689994;

  private View view2131689997;

  @UiThread
  public SubmitLandReview_ViewBinding(SubmitLandReview target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SubmitLandReview_ViewBinding(final SubmitLandReview target, View source) {
    this.target = target;

    View view;
    target.businessName = Utils.findRequiredViewAsType(source, R.id.business_name, "field 'businessName'", SettingItem.class);
    target.businessLandPark = Utils.findRequiredViewAsType(source, R.id.business_land_park, "field 'businessLandPark'", SettingItem.class);
    target.workshopTypeNameTxt = Utils.findRequiredViewAsType(source, R.id.workshopTypeName_txt, "field 'workshopTypeNameTxt'", TextView.class);
    target.workshopAreaTxt = Utils.findRequiredViewAsType(source, R.id.workshopArea_txt, "field 'workshopAreaTxt'", EditText.class);
    target.workshopPriceTxt = Utils.findRequiredViewAsType(source, R.id.workshopPrice_txt, "field 'workshopPriceTxt'", EditText.class);
    target.workshopLl = Utils.findRequiredViewAsType(source, R.id.workshop_ll, "field 'workshopLl'", LinearLayout.class);
    target.officeTypeNameTxt = Utils.findRequiredViewAsType(source, R.id.officeTypeName_txt, "field 'officeTypeNameTxt'", TextView.class);
    target.officeAreaTxt = Utils.findRequiredViewAsType(source, R.id.officeArea_txt, "field 'officeAreaTxt'", EditText.class);
    target.officePriceTxt = Utils.findRequiredViewAsType(source, R.id.officePrice_txt, "field 'officePriceTxt'", EditText.class);
    target.officeTimeTxt = Utils.findRequiredViewAsType(source, R.id.officeTime_txt, "field 'officeTimeTxt'", EditText.class);
    target.officeLl = Utils.findRequiredViewAsType(source, R.id.office_ll, "field 'officeLl'", LinearLayout.class);
    target.landAreaTxt = Utils.findRequiredViewAsType(source, R.id.landArea_txt, "field 'landAreaTxt'", EditText.class);
    target.landPriceTxt = Utils.findRequiredViewAsType(source, R.id.landPrice_txt, "field 'landPriceTxt'", EditText.class);
    target.landTimeTxt = Utils.findRequiredViewAsType(source, R.id.landTime_txt, "field 'landTimeTxt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.landTypeName, "field 'landTypeName' and method 'onViewClicked'");
    target.landTypeName = Utils.castView(view, R.id.landTypeName, "field 'landTypeName'", LinearLayout.class);
    view2131689992 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.landGetType, "field 'landGetType' and method 'onViewClicked'");
    target.landGetType = Utils.castView(view, R.id.landGetType, "field 'landGetType'", LinearLayout.class);
    view2131689994 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.landLl = Utils.findRequiredViewAsType(source, R.id.land_ll, "field 'landLl'", LinearLayout.class);
    target.registerPriceTxt = Utils.findRequiredViewAsType(source, R.id.registerPrice_txt, "field 'registerPriceTxt'", EditText.class);
    target.registerLl = Utils.findRequiredViewAsType(source, R.id.register_ll, "field 'registerLl'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.update_execute_submit, "field 'updateExecuteSubmit' and method 'onViewClicked'");
    target.updateExecuteSubmit = Utils.castView(view, R.id.update_execute_submit, "field 'updateExecuteSubmit'", TextView.class);
    view2131689997 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.landNatureTxt = Utils.findRequiredViewAsType(source, R.id.landNature_txt, "field 'landNatureTxt'", TextView.class);
    target.landGetTxt = Utils.findRequiredViewAsType(source, R.id.landGet_txt, "field 'landGetTxt'", TextView.class);
    target.workshopTimeTxt = Utils.findRequiredViewAsType(source, R.id.workshopTime_txt, "field 'workshopTimeTxt'", EditText.class);
    target.workshopTypeNameBuyTxt = Utils.findRequiredViewAsType(source, R.id.workshopTypeName_buy_txt, "field 'workshopTypeNameBuyTxt'", TextView.class);
    target.workshopAreaBuyTxt = Utils.findRequiredViewAsType(source, R.id.workshopArea_buy_txt, "field 'workshopAreaBuyTxt'", EditText.class);
    target.workshopPriceBuyTxt = Utils.findRequiredViewAsType(source, R.id.workshopPrice_buy_txt, "field 'workshopPriceBuyTxt'", EditText.class);
    target.workshopBuyLl = Utils.findRequiredViewAsType(source, R.id.workshop_buy_ll, "field 'workshopBuyLl'", LinearLayout.class);
    target.officeTypeNameBuyTxt = Utils.findRequiredViewAsType(source, R.id.officeTypeName_buy_txt, "field 'officeTypeNameBuyTxt'", TextView.class);
    target.officeAreaBuyTxt = Utils.findRequiredViewAsType(source, R.id.officeArea_buy_txt, "field 'officeAreaBuyTxt'", EditText.class);
    target.officePriceBuyTxt = Utils.findRequiredViewAsType(source, R.id.officePrice_buy_txt, "field 'officePriceBuyTxt'", EditText.class);
    target.officeByLl = Utils.findRequiredViewAsType(source, R.id.office_by_ll, "field 'officeByLl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SubmitLandReview target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.businessName = null;
    target.businessLandPark = null;
    target.workshopTypeNameTxt = null;
    target.workshopAreaTxt = null;
    target.workshopPriceTxt = null;
    target.workshopLl = null;
    target.officeTypeNameTxt = null;
    target.officeAreaTxt = null;
    target.officePriceTxt = null;
    target.officeTimeTxt = null;
    target.officeLl = null;
    target.landAreaTxt = null;
    target.landPriceTxt = null;
    target.landTimeTxt = null;
    target.landTypeName = null;
    target.landGetType = null;
    target.landLl = null;
    target.registerPriceTxt = null;
    target.registerLl = null;
    target.updateExecuteSubmit = null;
    target.landNatureTxt = null;
    target.landGetTxt = null;
    target.workshopTimeTxt = null;
    target.workshopTypeNameBuyTxt = null;
    target.workshopAreaBuyTxt = null;
    target.workshopPriceBuyTxt = null;
    target.workshopBuyLl = null;
    target.officeTypeNameBuyTxt = null;
    target.officeAreaBuyTxt = null;
    target.officePriceBuyTxt = null;
    target.officeByLl = null;

    view2131689992.setOnClickListener(null);
    view2131689992 = null;
    view2131689994.setOnClickListener(null);
    view2131689994 = null;
    view2131689997.setOnClickListener(null);
    view2131689997 = null;
  }
}
