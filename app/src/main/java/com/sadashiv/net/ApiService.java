package com.sadashiv.net;

import com.sadashiv.model.ArticleResponse;
import com.sadashiv.utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by emb-sadabir on 5/4/18.
 */

public interface ApiService {

    @GET(Constants.API_ARTICLE_SEARCH)
    Observable<ArticleResponse> getArticle(
            @Query(Constants.API_KEY) String key,
            @Query(Constants.NY_SORT_ORDER) String sortOrder,
            @Query(Constants.PAGE) int pageNumber,
            @Query(Constants.QUERY) String query);
}
