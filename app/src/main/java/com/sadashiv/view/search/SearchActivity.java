package com.sadashiv.view.search;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sadashiv.articlesearch.R;
import com.sadashiv.di.component.DaggerSearchComponent;
import com.sadashiv.di.module.SearchModule;
import com.sadashiv.model.Article;
import com.sadashiv.presenter.SearchPresenter;
import com.sadashiv.utils.EndlessRecyclerViewScrollListener;
import com.sadashiv.view.adapter.NyTimesArticleAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emb-sadabir on 5/4/18.
 */

public class SearchActivity extends AppCompatActivity implements ArticleSearchView{

    public static String cachedQueryString = "new york times";

    ArrayList<Article> articles;
    NyTimesArticleAdapter mNyTimesArticleAdapter;

    @BindView(R.id.rvArticles)
    RecyclerView mArticlesRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Inject
    SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setupComponent();
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        setTitle("News Article Search");
        mSearchPresenter.registerEventBus();
        articles = new ArrayList<>();
        mNyTimesArticleAdapter = new NyTimesArticleAdapter(this, articles);

        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mArticlesRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                loadMoreDataFromApi(page);
            }
        });
        mArticlesRecyclerView.setAdapter(mNyTimesArticleAdapter);
        mArticlesRecyclerView.setLayoutManager(gridLayoutManager);
        mSearchPresenter.getArticles(cachedQueryString, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSearchPresenter.registerEventBus();
    }

    private void setupComponent() {
        DaggerSearchComponent.builder()
                .searchModule(new SearchModule(this))
                .build()
                .inject(this);
    }

    public void loadMoreDataFromApi(int offset) {
        offset = offset % 100;
        Toast.makeText(this, "Loading more...", Toast.LENGTH_SHORT).show();
        mSearchPresenter.getArticles(cachedQueryString, offset);
        int curSize = mNyTimesArticleAdapter.getItemCount();
        mNyTimesArticleAdapter.notifyItemRangeInserted(curSize, articles.size() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                articles.clear();
                mNyTimesArticleAdapter.notifyDataSetChanged();
                cachedQueryString = query;
                mSearchPresenter.getArticles(query, 0);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void articleList(List<Article> fetchedArticles) {
        articles.addAll(fetchedArticles);
        Log.i("SearchActivity", articles.size() + " articles found");
        mNyTimesArticleAdapter.notifyDataSetChanged();
        loaderVisibility(false);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        loaderVisibility(false);
    }

    @Override
    public void loaderVisibility(boolean visibility) {
        if(visibility){
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStop() {
        mSearchPresenter.unregisterEventBus();
        super.onStop();
    }
}
