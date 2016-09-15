package com.valeriymaliuk.feeddroid.util;

import com.valeriymaliuk.feeddroid.presenter.FeedPresenter;

/**
 * Created by taras on 15/09/2016.
 */
public interface PresenterFactory<T extends FeedPresenter> {
    T create();
}