package com.sadashiv.view.search;

import android.content.Context;

import com.sadashiv.model.Article;
import com.sadashiv.model.ArticleResponse;

import java.util.List;

public interface ArticleSearchView {

    Context getContext();

    void articleList(List<Article> fetchedArticles);

    void showError(String message);

    void loaderVisibility(boolean visibility);
}
