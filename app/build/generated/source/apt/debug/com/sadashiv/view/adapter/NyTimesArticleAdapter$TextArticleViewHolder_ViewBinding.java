// Generated code from Butter Knife. Do not modify!
package com.sadashiv.view.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sadashiv.articlesearch.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NyTimesArticleAdapter$TextArticleViewHolder_ViewBinding<T extends NyTimesArticleAdapter.TextArticleViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public NyTimesArticleAdapter$TextArticleViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tvArticleText = Utils.findRequiredViewAsType(source, R.id.tvArticleText, "field 'tvArticleText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvArticleText = null;

    this.target = null;
  }
}
