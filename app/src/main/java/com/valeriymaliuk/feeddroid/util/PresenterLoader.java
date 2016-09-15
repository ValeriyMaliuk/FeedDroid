package com.valeriymaliuk.feeddroid.util;

import android.content.Context;
import android.support.v4.content.Loader;

import com.valeriymaliuk.feeddroid.presenter.FeedPresenter;

/**
 * Created by taras on 15/09/2016.
 */
public final class PresenterLoader<T extends FeedPresenter> extends Loader<T> {

    private final PresenterFactory<T> factory;
    private T presenter;

    public PresenterLoader(Context context, PresenterFactory<T> factory) {
        super(context);
        this.factory = factory;
    }

    @Override
    protected void onStartLoading() {
        // called on activity start

        // if we already own an instance of our presenter, simply deliver it.
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }

        // Otherwise, force a load
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        // Create the Presenter using the Factory
        presenter = factory.create();

        // Deliver the result
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        presenter.onDestroy();
        presenter = null;
    }
}