package com.valeriymaliuk.feeddroid.Fragment;

/**
 * Created by taras on 9/09/2016.
 */
public interface FeedPresenter {

    void onItemClicked(int position);

    void addItemToReadList(int position);

    void onResume();

    void onDestroy();
}
