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

public class LandExamineFragment_ViewBinding implements Unbinder {
  private LandExamineFragment target;

  @UiThread
  public LandExamineFragment_ViewBinding(LandExamineFragment target, View source) {
    this.target = target;

    target.workshopLl = Utils.findRequiredViewAsType(source, R.id.workshop_ll, "field 'workshopLl'", LinearLayout.class);
    target.workshopAreaTv = Utils.findRequiredViewAsType(source, R.id.workshopArea_tv, "field 'workshopAreaTv'", TextView.class);
    target.workshopPriceTv = Utils.findRequiredViewAsType(source, R.id.workshopPrice_tv, "field 'workshopPriceTv'", TextView.class);
    target.workshopTimeTv = Utils.findRequiredViewAsType(source, R.id.workshopTime_tv, "field 'workshopTimeTv'", TextView.class);
    target.workshopBuyLl = Utils.findRequiredViewAsType(source, R.id.workshop_buy_ll, "field 'workshopBuyLl'", LinearLayout.class);
    target.workshopAreaBuyTv = Utils.findRequiredViewAsType(source, R.id.workshopArea_buy_tv, "field 'workshopAreaBuyTv'", TextView.class);
    target.workshopPriceBuyTv = Utils.findRequiredViewAsType(source, R.id.workshopPrice_buy_tv, "field 'workshopPriceBuyTv'", TextView.class);
    target.officeLl = Utils.findRequiredViewAsType(source, R.id.office_ll, "field 'officeLl'", LinearLayout.class);
    target.officeAreaTv = Utils.findRequiredViewAsType(source, R.id.officeArea_tv, "field 'officeAreaTv'", TextView.class);
    target.officePriceTv = Utils.findRequiredViewAsType(source, R.id.officePrice_tv, "field 'officePriceTv'", TextView.class);
    target.officeTimeTv = Utils.findRequiredViewAsType(source, R.id.officeTime_tv, "field 'officeTimeTv'", TextView.class);
    target.officeBuyLl = Utils.findRequiredViewAsType(source, R.id.office_buy_ll, "field 'officeBuyLl'", LinearLayout.class);
    target.officeAreaBuyTv = Utils.findRequiredViewAsType(source, R.id.officeArea_buy_tv, "field 'officeAreaBuyTv'", TextView.class);
    target.officePriceBuyTv = Utils.findRequiredViewAsType(source, R.id.officePrice_buy_tv, "field 'officePriceBuyTv'", TextView.class);
    target.landLl = Utils.findRequiredViewAsType(source, R.id.land_ll, "field 'landLl'", LinearLayout.class);
    target.landAreaTv = Utils.findRequiredViewAsType(source, R.id.landArea_tv, "field 'landAreaTv'", TextView.class);
    target.landPriceTv = Utils.findRequiredViewAsType(source, R.id.landPrice_tv, "field 'landPriceTv'", TextView.class);
    target.landTimeTv = Utils.findRequiredViewAsType(source, R.id.landTime_tv, "field 'landTimeTv'", TextView.class);
    target.landNatureTv = Utils.findRequiredViewAsType(source, R.id.landNature_tv, "field 'landNatureTv'", TextView.class);
    target.landGetTv = Utils.findRequiredViewAsType(source, R.id.landGet_tv, "field 'landGetTv'", TextView.class);
    target.registerLl = Utils.findRequiredViewAsType(source, R.id.register_ll, "field 'registerLl'", LinearLayout.class);
    target.registerPriceTv = Utils.findRequiredViewAsType(source, R.id.registerPrice_tv, "field 'registerPriceTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LandExamineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.workshopLl = null;
    target.workshopAreaTv = null;
    target.workshopPriceTv = null;
    target.workshopTimeTv = null;
    target.workshopBuyLl = null;
    target.workshopAreaBuyTv = null;
    target.workshopPriceBuyTv = null;
    target.officeLl = null;
    target.officeAreaTv = null;
    target.officePriceTv = null;
    target.officeTimeTv = null;
    target.officeBuyLl = null;
    target.officeAreaBuyTv = null;
    target.officePriceBuyTv = null;
    target.landLl = null;
    target.landAreaTv = null;
    target.landPriceTv = null;
    target.landTimeTv = null;
    target.landNatureTv = null;
    target.landGetTv = null;
    target.registerLl = null;
    target.registerPriceTv = null;
  }
}
