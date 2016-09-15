package com.valeriymaliuk.feeddroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.valeriymaliuk.feeddroid.adapter.FeedAdapter;
import com.valeriymaliuk.feeddroid.interactor.FeedNetworkInteractorImp;
import com.valeriymaliuk.feeddroid.model.News;
import com.valeriymaliuk.feeddroid.R;
import com.valeriymaliuk.feeddroid.presenter.FeedPresenter;
import com.valeriymaliuk.feeddroid.presenter.FeedPresenterImp;
import com.valeriymaliuk.feeddroid.util.FeedPresenterFactory;
import com.valeriymaliuk.feeddroid.util.PresenterFactory;
import com.valeriymaliuk.feeddroid.util.PresenterLoader;

import java.util.ArrayList;
import java.util.List;


public class FeedFragment extends Fragment implements FeedView, LoaderManager.LoaderCallbacks<FeedPresenter> {
    private static final String TAG = "FeedFragment";
    private static final int LOADER_ID = 911;

    private List<News> mNewsList;
    private ProgressBar mProgressBar;
    private FeedPresenter mFeedPresenter;

    private RecyclerView mRecyclerView;
    private FeedAdapter mFeedAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_feed, container, false);
        initViews(v);

        return v;
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setItems(List<News> items) {
        mNewsList.clear();
        mNewsList.addAll(items);
        mFeedAdapter.notifyDataSetChanged();
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {

    }

    private void initViews(View view){
        mProgressBar  = (ProgressBar)  view.findViewById(R.id.progressBar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.feed_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //init recyclerView and adapter
        mNewsList = new ArrayList<>();
        mFeedAdapter = new FeedAdapter(mNewsList, getContext());
        mRecyclerView.setAdapter(mFeedAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().initLoader(LOADER_ID,null,this);
        Log.d(TAG, mFeedPresenter.toString());
        mFeedPresenter.onResume();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /*
    * Loader callbacks to handle binding of presenter after orientation changed
     */
    @Override
    public Loader<FeedPresenter> onCreateLoader(int id, Bundle args) {
        Log.d(TAG,"create Loader");
        return new PresenterLoader<>(getContext(), new FeedPresenterFactory(this, new FeedNetworkInteractorImp()));
    }

    @Override
    public void onLoadFinished(Loader<FeedPresenter> loader, FeedPresenter presenter) {
        Log.d(TAG,"load finished");
        this.mFeedPresenter = presenter;
    }

    @Override
    public void onLoaderReset(Loader<FeedPresenter> loader) {
        Log.d(TAG,"loader reset");
        this.mFeedPresenter = null;
    }
}
