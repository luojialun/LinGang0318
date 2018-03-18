// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContractSummaryAc_ViewBinding implements Unbinder {
  private ContractSummaryAc target;

  @UiThread
  public ContractSummaryAc_ViewBinding(ContractSummaryAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContractSummaryAc_ViewBinding(ContractSummaryAc target, View source) {
    this.target = target;

    target.companyNameSi = Utils.findRequiredViewAsType(source, R.id.company_name_si, "field 'companyNameSi'", SettingItem.class);
    target.yuanquSi = Utils.findRequiredViewAsType(source, R.id.yuanqu_si, "field 'yuanquSi'", SettingItem.class);
    target.workshopLl = Utils.findRequiredViewAsType(source, R.id.workshop_ll, "field 'workshopLl'", LinearLayout.class);
    target.officeLl = Utils.findRequiredViewAsType(source, R.id.office_ll, "field 'officeLl'", LinearLayout.class);
    target.landLl = Utils.findRequiredViewAsType(source, R.id.land_ll, "field 'landLl'", LinearLayout.class);
    target.registerLl = Utils.findRequiredViewAsType(source, R.id.register_ll, "field 'registerLl'", LinearLayout.class);
    target.changfang1Si = Utils.findRequiredViewAsType(source, R.id.changfang1_si, "field 'changfang1Si'", SettingItem.class);
    target.changfang2Si = Utils.findRequiredViewAsType(source, R.id.changfang2_si, "field 'changfang2Si'", SettingItem.class);
    target.changfang3Si = Utils.findRequiredViewAsType(source, R.id.changfang3_si, "field 'changfang3Si'", SettingItem.class);
    target.changfang4Si = Utils.findRequiredViewAsType(source, R.id.changfang4_si, "field 'changfang4Si'", SettingItem.class);
    target.yanfa1Si = Utils.findRequiredViewAsType(source, R.id.yanfa1_si, "field 'yanfa1Si'", SettingItem.class);
    target.yanfa2Si = Utils.findRequiredViewAsType(source, R.id.yanfa2_si, "field 'yanfa2Si'", SettingItem.class);
    target.yanfa3Si = Utils.findRequiredViewAsType(source, R.id.yanfa3_si, "field 'yanfa3Si'", SettingItem.class);
    target.yanfa4Si = Utils.findRequiredViewAsType(source, R.id.yanfa4_si, "field 'yanfa4Si'", SettingItem.class);
    target.buyLandSi = Utils.findRequiredViewAsType(source, R.id.buy_land_si, "field 'buyLandSi'", SettingItem.class);
    target.landPriceSi = Utils.findRequiredViewAsType(source, R.id.land_price_si, "field 'landPriceSi'", SettingItem.class);
    target.landYearsSi = Utils.findRequiredViewAsType(source, R.id.land_years_si, "field 'landYearsSi'", SettingItem.class);
    target.landPropertySi = Utils.findRequiredViewAsType(source, R.id.land_property_si, "field 'landPropertySi'", SettingItem.class);
    target.landGetSi = Utils.findRequiredViewAsType(source, R.id.land_get_si, "field 'landGetSi'", SettingItem.class);
    target.registeredEnterpriseMoneyTxt = Utils.findRequiredViewAsType(source, R.id.registeredEnterpriseMoney_txt, "field 'registeredEnterpriseMoneyTxt'", SettingItem.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContractSummaryAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.companyNameSi = null;
    target.yuanquSi = null;
    target.workshopLl = null;
    target.officeLl = null;
    target.landLl = null;
    target.registerLl = null;
    target.changfang1Si = null;
    target.changfang2Si = null;
    target.changfang3Si = null;
    target.changfang4Si = null;
    target.yanfa1Si = null;
    target.yanfa2Si = null;
    target.yanfa3Si = null;
    target.yanfa4Si = null;
    target.buyLandSi = null;
    target.landPriceSi = null;
    target.landYearsSi = null;
    target.landPropertySi = null;
    target.landGetSi = null;
    target.registeredEnterpriseMoneyTxt = null;
  }
}
