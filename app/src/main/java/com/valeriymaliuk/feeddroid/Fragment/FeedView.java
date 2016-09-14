package com.valeriymaliuk.feeddroid.fragment;

import com.valeriymaliuk.feeddroid.model.News;

import java.util.List;

/**
 * Created by taras on 9/09/2016.
 */
public interface FeedView {

    void showProgress();

    void hideProgress();

    void setItems(List<News> items);

    void showMessage(String message);
}
