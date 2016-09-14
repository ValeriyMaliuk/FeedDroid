package com.valeriymaliuk.feeddroid.fragment;

import com.valeriymaliuk.feeddroid.model.News;

import java.util.List;

/**
 * Created by taras on 12/09/2016.
 */
public class FeedPresenterImp implements FeedPresenter, FeedInteractor.OnInteractorResult {

    private FeedView mFeedView;
    private FeedInteractor mFeedInteractor;

    public FeedPresenterImp(FeedView mFeedView, FeedInteractor mFeedInteractor) {
        this.mFeedView = mFeedView;
        this.mFeedInteractor = mFeedInteractor;
    }

    @Override
    public void onItemClicked(int position) {
        //TODO: open WebView in new screen with full news page
    }

    @Override
    public void addItemToReadList(int position) {
        //TODO: Add clicked News object to storage
    }

    @Override
    public void onResume() {
        if(mFeedView != null){
            mFeedView.showProgress();
        }
        mFeedInteractor.getNewsList(this);
    }

    @Override
    public void onDestroy() {
        mFeedView = null;
    }

    /*
     * Callback that is fired when interactor returns list
     */
    @Override
    public void onSuccess(List<News> newsList) {
        if (mFeedView != null){
            mFeedView.setItems(newsList);
            mFeedView.hideProgress();
        }
    }

    @Override
    public void onFailure() {
        if(mFeedView != null){
            mFeedView.showMessage("Some error occurred");
        }
    }
}
