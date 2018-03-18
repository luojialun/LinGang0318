// Generated code from Butter Knife. Do not modify!
package com.lingang.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lingang.R;
import com.lingang.view.CustomCircleProgress;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DownloadExpandableAdapter$ChildHolder_ViewBinding implements Unbinder {
  private DownloadExpandableAdapter.ChildHolder target;

  @UiThread
  public DownloadExpandableAdapter$ChildHolder_ViewBinding(DownloadExpandableAdapter.ChildHolder target,
      View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'imageView'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'tvDate'", TextView.class);
    target.tvSize = Utils.findRequiredViewAsType(source, R.id.tv_size, "field 'tvSize'", TextView.class);
    target.fileStateTv = Utils.findRequiredViewAsType(source, R.id.file_state_tv, "field 'fileStateTv'", TextView.class);
    target.downloadCircleImg = Utils.findRequiredViewAsType(source, R.id.download_circle_img, "field 'downloadCircleImg'", ImageView.class);
    target.downloadCircleProgress = Utils.findRequiredViewAsType(source, R.id.download_circle_progress, "field 'downloadCircleProgress'", CustomCircleProgress.class);
    target.downloadCircleStatus = Utils.findRequiredViewAsType(source, R.id.download_circle_status, "field 'downloadCircleStatus'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DownloadExpandableAdapter.ChildHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageView = null;
    target.tvTitle = null;
    target.tvDate = null;
    target.tvSize = null;
    target.fileStateTv = null;
    target.downloadCircleImg = null;
    target.downloadCircleProgress = null;
    target.downloadCircleStatus = null;
  }
}
