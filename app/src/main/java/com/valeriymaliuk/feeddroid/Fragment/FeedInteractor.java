package com.valeriymaliuk.feeddroid.Fragment;

import com.valeriymaliuk.feeddroid.Model.News;

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
