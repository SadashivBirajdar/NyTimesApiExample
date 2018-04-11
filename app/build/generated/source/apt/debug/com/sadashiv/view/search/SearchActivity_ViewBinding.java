// Generated code from Butter Knife. Do not modify!
package com.sadashiv.view.search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sadashiv.articlesearch.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding<T extends SearchActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SearchActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mArticlesRecyclerView = Utils.findRequiredViewAsType(source, R.id.rvArticles, "field 'mArticlesRecyclerView'", RecyclerView.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'mProgressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mArticlesRecyclerView = null;
    target.mToolbar = null;
    target.mProgressBar = null;

    this.target = null;
  }
}
