// Generated code from Butter Knife. Do not modify!
package com.lingang.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.barteksc.pdfviewer.PDFView;
import com.lingang.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PdfViewerActivity_ViewBinding implements Unbinder {
  private PdfViewerActivity target;

  @UiThread
  public PdfViewerActivity_ViewBinding(PdfViewerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PdfViewerActivity_ViewBinding(PdfViewerActivity target, View source) {
    this.target = target;

    target.pdfNameTv = Utils.findRequiredViewAsType(source, R.id.pdf_name_tv, "field 'pdfNameTv'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progressBar'", ProgressBar.class);
    target.progressContainerLl = Utils.findRequiredViewAsType(source, R.id.progress_container_ll, "field 'progressContainerLl'", LinearLayout.class);
    target.pdfViewer = Utils.findRequiredViewAsType(source, R.id.pdf_viewer, "field 'pdfViewer'", PDFView.class);
    target.pagerIndexTv = Utils.findRequiredViewAsType(source, R.id.pager_index_tv, "field 'pagerIndexTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PdfViewerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pdfNameTv = null;
    target.progressBar = null;
    target.progressContainerLl = null;
    target.pdfViewer = null;
    target.pagerIndexTv = null;
  }
}
