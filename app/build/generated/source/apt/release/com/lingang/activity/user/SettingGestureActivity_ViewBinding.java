// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.SettingItem;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingGestureActivity_ViewBinding implements Unbinder {
  private SettingGestureActivity target;

  private View view2131689970;

  @UiThread
  public SettingGestureActivity_ViewBinding(SettingGestureActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingGestureActivity_ViewBinding(final SettingGestureActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.setting_modify_gesture, "field 'settingModifyGesture' and method 'modifyGesture'");
    target.settingModifyGesture = Utils.castView(view, R.id.setting_modify_gesture, "field 'settingModifyGesture'", SettingItem.class);
    view2131689970 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.modifyGesture(p0);
      }
    });
    target.settingGestureSwitch = Utils.findRequiredViewAsType(source, R.id.switch_cb, "field 'settingGestureSwitch'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingGestureActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.settingModifyGesture = null;
    target.settingGestureSwitch = null;

    view2131689970.setOnClickListener(null);
    view2131689970 = null;
  }
}
