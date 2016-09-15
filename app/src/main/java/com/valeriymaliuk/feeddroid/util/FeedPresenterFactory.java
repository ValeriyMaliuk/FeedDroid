package com.valeriymaliuk.feeddroid.util;

import com.valeriymaliuk.feeddroid.fragment.FeedView;
import com.valeriymaliuk.feeddroid.interactor.FeedInteractor;
import com.valeriymaliuk.feeddroid.presenter.FeedPresenter;
import com.valeriymaliuk.feeddroid.presenter.FeedPresenterImp;

/**
 * Created by taras on 15/09/2016.
 */
public class FeedPresenterFactory implements PresenterFactory<FeedPresenter> {

    private final FeedView mFeedView;
    private final FeedInteractor mFeedInteractor;

    public FeedPresenterFactory(FeedView mFeedView, FeedInteractor mFeedInteractor) {
        this.mFeedView = mFeedView;
        this.mFeedInteractor = mFeedInteractor;
    }

    @Override
    public FeedPresenterImp create() {
        return new FeedPresenterImp(mFeedView,mFeedInteractor);
    }
}
