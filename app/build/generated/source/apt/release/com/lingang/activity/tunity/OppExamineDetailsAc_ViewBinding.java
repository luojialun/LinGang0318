// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity;

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
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OppExamineDetailsAc_ViewBinding implements Unbinder {
  private OppExamineDetailsAc target;

  private View view2131689860;

  private View view2131689864;

  private View view2131689875;

  private View view2131689876;

  private View view2131689877;

  @UiThread
  public OppExamineDetailsAc_ViewBinding(OppExamineDetailsAc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OppExamineDetailsAc_ViewBinding(final OppExamineDetailsAc target, View source) {
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
    target.reasonTv = Utils.findRequiredViewAsType(source, R.id.reason_tv, "field 'reasonTv'", TextView.class);
    target.oppTimedContent = Utils.findRequiredViewAsType(source, R.id.opp_timed_content, "field 'oppTimedContent'", LinearLayout.class);
    target.stateBtn = Utils.findRequiredViewAsType(source, R.id.state_btn, "field 'stateBtn'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rec_man_si, "field 'recManSi' and method 'onViewClicked'");
    target.recManSi = Utils.castView(view, R.id.rec_man_si, "field 'recManSi'", SettingItem.class);
    view2131689864 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.recTimeSi = Utils.findRequiredViewAsType(source, R.id.rec_time_si, "field 'recTimeSi'", SettingItem.class);
    target.exaTimeSi = Utils.findRequiredViewAsType(source, R.id.exa_time_si, "field 'exaTimeSi'", SettingItem.class);
    target.customerEnterpriseIsregisterTxt = Utils.findRequiredViewAsType(source, R.id.customerEnterpriseIsregister_txt, "field 'customerEnterpriseIsregisterTxt'", SettingItem.class);
    target.customerEnterpriseNameTxt = Utils.findRequiredViewAsType(source, R.id.customerEnterpriseName_txt, "field 'customerEnterpriseNameTxt'", TextView.class);
    target.customerEnterpriseKeywordsTxt = Utils.findRequiredViewAsType(source, R.id.customerEnterpriseKeywords_txt, "field 'customerEnterpriseKeywordsTxt'", TextView.class);
    target.supplementaryNotesTxt = Utils.findRequiredViewAsType(source, R.id.supplementaryNotes_txt, "field 'supplementaryNotesTxt'", TextView.class);
    target.parkNameTxt = Utils.findRequiredViewAsType(source, R.id.parkName_txt, "field 'parkNameTxt'", AlignTextView.class);
    target.messageLl = Utils.findRequiredViewAsType(source, R.id.message_ll, "field 'messageLl'", LinearLayout.class);
    target.message2Ll = Utils.findRequiredViewAsType(source, R.id.message2_ll, "field 'message2Ll'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.opp_details_tv, "field 'oppDetailsTv' and method 'onViewClicked'");
    target.oppDetailsTv = Utils.castView(view, R.id.opp_details_tv, "field 'oppDetailsTv'", TextView.class);
    view2131689875 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.suggestLl = Utils.findRequiredViewAsType(source, R.id.suggest_ll, "field 'suggestLl'", LinearLayout.class);
    target.companyNameSi = Utils.findRequiredViewAsType(source, R.id.company_name_si, "field 'companyNameSi'", TextView.class);
    target.yuanquSi = Utils.findRequiredViewAsType(source, R.id.yuanqu_si, "field 'yuanquSi'", SettingItem.class);
    view = Utils.findRequiredView(source, R.id.disagree_tv, "field 'disagreeTv' and method 'onViewClicked'");
    target.disagreeTv = Utils.castView(view, R.id.disagree_tv, "field 'disagreeTv'", TextView.class);
    view2131689876 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.agree_tv, "field 'agreeTv' and method 'onViewClicked'");
    target.agreeTv = Utils.castView(view, R.id.agree_tv, "field 'agreeTv'", TextView.class);
    view2131689877 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.supplyParkLl = Utils.findRequiredViewAsType(source, R.id.supply_park_ll, "field 'supplyParkLl'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OppExamineDetailsAc target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.outdateTv = null;
    target.oppStateTab = null;
    target.reasonTv = null;
    target.oppTimedContent = null;
    target.stateBtn = null;
    target.recManSi = null;
    target.recTimeSi = null;
    target.exaTimeSi = null;
    target.customerEnterpriseIsregisterTxt = null;
    target.customerEnterpriseNameTxt = null;
    target.customerEnterpriseKeywordsTxt = null;
    target.supplementaryNotesTxt = null;
    target.parkNameTxt = null;
    target.messageLl = null;
    target.message2Ll = null;
    target.oppDetailsTv = null;
    target.suggestLl = null;
    target.companyNameSi = null;
    target.yuanquSi = null;
    target.disagreeTv = null;
    target.agreeTv = null;
    target.supplyParkLl = null;

    view2131689860.setOnClickListener(null);
    view2131689860 = null;
    view2131689864.setOnClickListener(null);
    view2131689864 = null;
    view2131689875.setOnClickListener(null);
    view2131689875 = null;
    view2131689876.setOnClickListener(null);
    view2131689876 = null;
    view2131689877.setOnClickListener(null);
    view2131689877 = null;
  }
}
