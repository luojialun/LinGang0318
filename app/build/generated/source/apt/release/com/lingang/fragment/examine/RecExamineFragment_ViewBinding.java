// Generated code from Butter Knife. Do not modify!
package com.lingang.fragment.examine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecExamineFragment_ViewBinding implements Unbinder {
  private RecExamineFragment target;

  @UiThread
  public RecExamineFragment_ViewBinding(RecExamineFragment target, View source) {
    this.target = target;

    target.workshopLl = Utils.findRequiredViewAsType(source, R.id.workshop_ll, "field 'workshopLl'", LinearLayout.class);
    target.workshopTypeNameTv = Utils.findRequiredViewAsType(source, R.id.workshopTypeName_tv, "field 'workshopTypeNameTv'", TextView.class);
    target.workshopAreaTv = Utils.findRequiredViewAsType(source, R.id.workshopArea_tv, "field 'workshopAreaTv'", TextView.class);
    target.workshopLocationTv = Utils.findRequiredViewAsType(source, R.id.workshopLocation_tv, "field 'workshopLocationTv'", TextView.class);
    target.officeLl = Utils.findRequiredViewAsType(source, R.id.office_ll, "field 'officeLl'", LinearLayout.class);
    target.officeTypeNameTv = Utils.findRequiredViewAsType(source, R.id.officeTypeName_tv, "field 'officeTypeNameTv'", TextView.class);
    target.officeAreaTv = Utils.findRequiredViewAsType(source, R.id.officeArea_tv, "field 'officeAreaTv'", TextView.class);
    target.officeLocationTv = Utils.findRequiredViewAsType(source, R.id.officeLocation_tv, "field 'officeLocationTv'", TextView.class);
    target.landLl = Utils.findRequiredViewAsType(source, R.id.land_ll, "field 'landLl'", LinearLayout.class);
    target.landAreaTv = Utils.findRequiredViewAsType(source, R.id.landArea_tv, "field 'landAreaTv'", TextView.class);
    target.landLocationTv = Utils.findRequiredViewAsType(source, R.id.landLocation_tv, "field 'landLocationTv'", TextView.class);
    target.landTypeTv = Utils.findRequiredViewAsType(source, R.id.landType_tv, "field 'landTypeTv'", TextView.class);
    target.registerLl = Utils.findRequiredViewAsType(source, R.id.register_ll, "field 'registerLl'", LinearLayout.class);
    target.registeredEnterpriseTypeTv = Utils.findRequiredViewAsType(source, R.id.registeredEnterpriseType_tv, "field 'registeredEnterpriseTypeTv'", TextView.class);
    target.registeredEnterpriseMoneyTv = Utils.findRequiredViewAsType(source, R.id.registeredEnterpriseMoney_tv, "field 'registeredEnterpriseMoneyTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecExamineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.workshopLl = null;
    target.workshopTypeNameTv = null;
    target.workshopAreaTv = null;
    target.workshopLocationTv = null;
    target.officeLl = null;
    target.officeTypeNameTv = null;
    target.officeAreaTv = null;
    target.officeLocationTv = null;
    target.landLl = null;
    target.landAreaTv = null;
    target.landLocationTv = null;
    target.landTypeTv = null;
    target.registerLl = null;
    target.registeredEnterpriseTypeTv = null;
    target.registeredEnterpriseMoneyTv = null;
  }
}
