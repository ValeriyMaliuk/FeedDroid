package com.valeriymaliuk.feeddroid.interactor;

import com.valeriymaliuk.feeddroid.model.News;

import java.util.List;

/**
 * Created by valeriymaliuk on 9/13/16.
 */
public interface FeedInteractor {

    interface OnInteractorResult{
        void onSuccess(List<News> newsList);
        void onFailure();
    }

    void getNewsList(OnInteractorResult callback);
}
