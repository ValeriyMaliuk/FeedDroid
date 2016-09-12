package com.valeriymaliuk.feeddroid.Fragment;

import com.valeriymaliuk.feeddroid.Model.News;

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
