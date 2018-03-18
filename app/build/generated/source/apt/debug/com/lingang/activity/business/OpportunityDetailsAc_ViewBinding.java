// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.AlignTextView;
import com.lingang.view.MyRecyclerView;
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OpportunityDetailsAc_ViewBinding implements Unbinder {
  private OpportunityDetailsAc target;

  private View view2131689860;

  @UiThread
  public OpportunityDetailsAc_ViewBinding(OpportunityDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OpportunityDetailsAc_ViewBinding(final OpportunityDetailsAc target, View source) {
    this.target = target;

    View view;
    target.outdateTv = Utils.findRequiredViewAsType(source, R.id.outdate_tv, "field 'outdateTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.opp_state_tab, "field 'oppStateTab' and method 'onViewClicked'");
    target.oppStateTab = Utils.castView(view, R.id.opp_state_tab, "field 'oppStateTab'", TextView.class);
    view2131689860 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.stateBtn = Utils.findRequiredViewAsType(source, R.id.state_btn, "field 'stateBtn'", TextView.class);
    target.flowDetailsRv = Utils.findRequiredViewAsType(source, R.id.flow_details_rv, "field 'flowDetailsRv'", MyRecyclerView.class);
    target.customerNameTxt = Utils.findRequiredViewAsType(source, R.id.customerName_txt, "field 'customerNameTxt'", SettingItem.class);
    target.customerTelTxt = Utils.findRequiredViewAsType(source, R.id.customerTel_txt, "field 'customerTelTxt'", SettingItem.class);
    target.customerRelationshipNameTxt = Utils.findRequiredViewAsType(source, R.id.customerRelationshipName_txt, "field 'customerRelationshipNameTxt'", SettingItem.class);
    target.customerCallIdTxt = Utils.findRequiredViewAsType(source, R.id.customerCallId_txt, "field 'customerCallIdTxt'", SettingItem.class);
    target.customerMailTxt = Utils.findRequiredViewAsType(source, R.id.customerMail_txt, "field 'customerMailTxt'", SettingItem.class);
    target.customerEnterpriseIsregisterTxt = Utils.findRequiredViewAsType(source, R.id.customerEnterpriseIsregister_txt, "field 'customerEnterpriseIsregisterTxt'", SettingItem.class);
    target.customerEnterpriseNameTxt = Utils.findRequiredViewAsType(source, R.id.customerEnterpriseName_txt, "field 'customerEnterpriseNameTxt'", TextView.class);
    target.customerEnterpriseKeywordsTxt = Utils.findRequiredViewAsType(source, R.id.customerEnterpriseKeywords_txt, "field 'customerEnterpriseKeywordsTxt'", TextView.class);
    target.workshopTypeIdTxt = Utils.findRequiredViewAsType(source, R.id.workshopTypeId_txt, "field 'workshopTypeIdTxt'", SettingItem.class);
    target.workshopAreaTxt = Utils.findRequiredViewAsType(source, R.id.workshopArea_txt, "field 'workshopAreaTxt'", SettingItem.class);
    target.workshopLocationIdTxt = Utils.findRequiredViewAsType(source, R.id.workshopLocationId_txt, "field 'workshopLocationIdTxt'", SettingItem.class);
    target.officeTypeIdTxt = Utils.findRequiredViewAsType(source, R.id.officeTypeId_txt, "field 'officeTypeIdTxt'", SettingItem.class);
    target.officeAreaTxt = Utils.findRequiredViewAsType(source, R.id.officeArea_txt, "field 'officeAreaTxt'", SettingItem.class);
    target.officeLocationIdTxt = Utils.findRequiredViewAsType(source, R.id.officeLocationId_txt, "field 'officeLocationIdTxt'", SettingItem.class);
    target.supplementaryTxt = Utils.findRequiredViewAsType(source, R.id.supplementary_txt, "field 'supplementaryTxt'", TextView.class);
    target.parkNameTxt = Utils.findRequiredViewAsType(source, R.id.parkName_txt, "field 'parkNameTxt'", AlignTextView.class);
    target.workshopLl = Utils.findRequiredViewAsType(source, R.id.workshop_ll, "field 'workshopLl'", LinearLayout.class);
    target.officeLl = Utils.findRequiredViewAsType(source, R.id.office_ll, "field 'officeLl'", LinearLayout.class);
    target.landAreaTxt = Utils.findRequiredViewAsType(source, R.id.landArea_txt, "field 'landAreaTxt'", SettingItem.class);
    target.landLocationTxt = Utils.findRequiredViewAsType(source, R.id.landLocation_txt, "field 'landLocationTxt'", SettingItem.class);
    target.landTypeTxt = Utils.findRequiredViewAsType(source, R.id.landType_txt, "field 'landTypeTxt'", SettingItem.class);
    target.landLl = Utils.findRequiredViewAsType(source, R.id.land_ll, "field 'landLl'", LinearLayout.class);
    target.registeredEnterpriseTypeTxt = Utils.findRequiredViewAsType(source, R.id.registeredEnterpriseType_txt, "field 'registeredEnterpriseTypeTxt'", SettingItem.class);
    target.registeredEnterpriseMoneyTxt = Utils.findRequiredViewAsType(source, R.id.registeredEnterpriseMoney_txt, "field 'registeredEnterpriseMoneyTxt'", SettingItem.class);
    target.registerLl = Utils.findRequiredViewAsType(source, R.id.register_ll, "field 'registerLl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OpportunityDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.outdateTv = null;
    target.oppStateTab = null;
    target.stateBtn = null;
    target.flowDetailsRv = null;
    target.customerNameTxt = null;
    target.customerTelTxt = null;
    target.customerRelationshipNameTxt = null;
    target.customerCallIdTxt = null;
    target.customerMailTxt = null;
    target.customerEnterpriseIsregisterTxt = null;
    target.customerEnterpriseNameTxt = null;
    target.customerEnterpriseKeywordsTxt = null;
    target.workshopTypeIdTxt = null;
    target.workshopAreaTxt = null;
    target.workshopLocationIdTxt = null;
    target.officeTypeIdTxt = null;
    target.officeAreaTxt = null;
    target.officeLocationIdTxt = null;
    target.supplementaryTxt = null;
    target.parkNameTxt = null;
    target.workshopLl = null;
    target.officeLl = null;
    target.landAreaTxt = null;
    target.landLocationTxt = null;
    target.landTypeTxt = null;
    target.landLl = null;
    target.registeredEnterpriseTypeTxt = null;
    target.registeredEnterpriseMoneyTxt = null;
    target.registerLl = null;

    view2131689860.setOnClickListener(null);
    view2131689860 = null;
  }
}
