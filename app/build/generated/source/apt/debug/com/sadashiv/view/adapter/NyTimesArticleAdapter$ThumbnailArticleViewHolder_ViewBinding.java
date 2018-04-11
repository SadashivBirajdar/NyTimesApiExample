// Generated code from Butter Knife. Do not modify!
package com.sadashiv.view.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sadashiv.articlesearch.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NyTimesArticleAdapter$ThumbnailArticleViewHolder_ViewBinding<T extends NyTimesArticleAdapter.ThumbnailArticleViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public NyTimesArticleAdapter$ThumbnailArticleViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivArticle = Utils.findRequiredViewAsType(source, R.id.ivArticle, "field 'ivArticle'", ImageView.class);
    target.tvArticle = Utils.findRequiredViewAsType(source, R.id.tvArticle, "field 'tvArticle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivArticle = null;
    target.tvArticle = null;

    this.target = null;
  }
}
