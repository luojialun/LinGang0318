// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.tunity.execute;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateExecute_ViewBinding implements Unbinder {
  private UpdateExecute target;

  private View view2131689997;

  @UiThread
  public UpdateExecute_ViewBinding(UpdateExecute target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateExecute_ViewBinding(final UpdateExecute target, View source) {
    this.target = target;

    View view;
    target.executeUpdateRv = Utils.findRequiredViewAsType(source, R.id.execute_update_rv, "field 'executeUpdateRv'", RecyclerView.class);
    target.updateExecuteContent = Utils.findRequiredViewAsType(source, R.id.update_execute_content, "field 'updateExecuteContent'", EditText.class);
    view = Utils.findRequiredView(source, R.id.update_execute_submit, "field 'updateExecuteSubmit' and method 'onViewClicked'");
    target.updateExecuteSubmit = Utils.castView(view, R.id.update_execute_submit, "field 'updateExecuteSubmit'", TextView.class);
    view2131689997 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.updateContentNum = Utils.findRequiredViewAsType(source, R.id.update_content_num, "field 'updateContentNum'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateExecute target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.executeUpdateRv = null;
    target.updateExecuteContent = null;
    target.updateExecuteSubmit = null;
    target.updateContentNum = null;

    view2131689997.setOnClickListener(null);
    view2131689997 = null;
  }
}
