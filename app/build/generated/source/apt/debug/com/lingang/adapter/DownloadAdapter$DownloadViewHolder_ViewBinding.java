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

public class DownloadAdapter$DownloadViewHolder_ViewBinding implements Unbinder {
  private DownloadAdapter.DownloadViewHolder target;

  @UiThread
  public DownloadAdapter$DownloadViewHolder_ViewBinding(DownloadAdapter.DownloadViewHolder target,
      View source) {
    this.target = target;

    target.mImageView = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'mImageView'", ImageView.class);
    target.mTvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    target.mTvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mTvDate'", TextView.class);
    target.mTvSize = Utils.findRequiredViewAsType(source, R.id.tv_size, "field 'mTvSize'", TextView.class);
    target.doneTv = Utils.findRequiredViewAsType(source, R.id.done_tv, "field 'doneTv'", TextView.class);
    target.downloadCircleStatus = Utils.findRequiredViewAsType(source, R.id.download_circle_status, "field 'downloadCircleStatus'", FrameLayout.class);
    target.downloadCircleImg = Utils.findRequiredViewAsType(source, R.id.download_circle_img, "field 'downloadCircleImg'", ImageView.class);
    target.downloadCircleProgress = Utils.findRequiredViewAsType(source, R.id.download_circle_progress, "field 'downloadCircleProgress'", CustomCircleProgress.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DownloadAdapter.DownloadViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImageView = null;
    target.mTvTitle = null;
    target.mTvDate = null;
    target.mTvSize = null;
    target.doneTv = null;
    target.downloadCircleStatus = null;
    target.downloadCircleImg = null;
    target.downloadCircleProgress = null;
  }
}
