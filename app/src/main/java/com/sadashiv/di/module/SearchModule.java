package com.sadashiv.di.module;

import com.sadashiv.presenter.SearchPresenter;
import com.sadashiv.view.search.ArticleSearchView;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {

    private final ArticleSearchView view;

    public SearchModule(ArticleSearchView searchView) {
        this.view = searchView;
    }

    @Provides
    SearchPresenter providePresenter() {
        return new SearchPresenter(view, EventBus.getDefault());
    }
}
