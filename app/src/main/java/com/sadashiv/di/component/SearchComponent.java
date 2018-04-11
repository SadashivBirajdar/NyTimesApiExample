package com.sadashiv.di.component;


import com.sadashiv.di.module.SearchModule;
import com.sadashiv.view.search.SearchActivity;

import dagger.Component;


/**
 * Created by emb-sadabir on 05/03/18.
 */

@Component(modules = SearchModule.class)
public interface SearchComponent {

    void inject(SearchActivity searchActivity);
}
