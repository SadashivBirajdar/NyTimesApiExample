package com.sadashiv.presenter;

import com.sadashiv.job.NetworkJob;
import com.sadashiv.model.ArticleRequest;
import com.sadashiv.model.ArticleResponse;
import com.sadashiv.utils.Constants;
import com.sadashiv.utils.Utils;
import com.sadashiv.view.search.ArticleSearchView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by emb-sadabir on 5/4/18.
 */

public class SearchPresenter extends BasePresenter {

    private ArticleSearchView mView;

    public SearchPresenter(ArticleSearchView view, EventBus eventBus) {
        super(eventBus);
        mView = view;
    }

    public void getArticles(String query, int page) {
        if (!Utils.isNetworkAvailable(mView.getContext())) {
            mView.showError(Constants.NETWORK_NOT_AVAILABLE);
        } else {
            mView.loaderVisibility(true);
            ArticleRequest articleRequest = new ArticleRequest();
            articleRequest.setApiKey(Constants.KEY);
            articleRequest.setPage(page);
            articleRequest.setQuery(query);
            articleRequest.setSortOrder(Constants.SORT_ORDER);
            NetworkJob networkJob = new NetworkJob(mEventBus, Constants.ARTICLE_SEARCH);
            networkJob.searchArticle(articleRequest);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetworkJobFinished(NetworkJob.FinishedEvent event) {
        if(event.isSuccess()){
            switch (event.getAction()){
                case Constants.ARTICLE_SEARCH:
                    ArticleResponse response = (ArticleResponse) event.getObject();
                    mView.articleList(response.getResponse().getDocs());
                    break;
            }
        } else {
            mView.showError(event.getErrorMessage());
        }
    }
}
