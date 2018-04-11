// Generated by Dagger (https://google.github.io/dagger).
package com.sadashiv.di.component;

import com.sadashiv.di.module.SearchModule;
import com.sadashiv.di.module.SearchModule_ProvidePresenterFactory;
import com.sadashiv.view.search.SearchActivity;
import com.sadashiv.view.search.SearchActivity_MembersInjector;
import dagger.internal.Preconditions;

public final class DaggerSearchComponent implements SearchComponent {
  private SearchModule searchModule;

  private DaggerSearchComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.searchModule = builder.searchModule;
  }

  @Override
  public void inject(SearchActivity searchActivity) {
    injectSearchActivity(searchActivity);
  }

  private SearchActivity injectSearchActivity(SearchActivity instance) {
    SearchActivity_MembersInjector.injectMSearchPresenter(
        instance, SearchModule_ProvidePresenterFactory.proxyProvidePresenter(searchModule));
    return instance;
  }

  public static final class Builder {
    private SearchModule searchModule;

    private Builder() {}

    public SearchComponent build() {
      if (searchModule == null) {
        throw new IllegalStateException(SearchModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerSearchComponent(this);
    }

    public Builder searchModule(SearchModule searchModule) {
      this.searchModule = Preconditions.checkNotNull(searchModule);
      return this;
    }
  }
}
