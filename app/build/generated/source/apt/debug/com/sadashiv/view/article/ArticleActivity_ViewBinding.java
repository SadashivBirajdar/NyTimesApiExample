// Generated code from Butter Knife. Do not modify!
package com.sadashiv.view.article;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sadashiv.articlesearch.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ArticleActivity_ViewBinding<T extends ArticleActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ArticleActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mArticleWebView = Utils.findRequiredViewAsType(source, R.id.wvArticle, "field 'mArticleWebView'", WebView.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.loader, "field 'mProgressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mArticleWebView = null;
    target.mProgressBar = null;

    this.target = null;
  }
}
