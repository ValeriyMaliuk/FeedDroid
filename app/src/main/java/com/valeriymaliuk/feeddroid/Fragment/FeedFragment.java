package com.valeriymaliuk.feeddroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.List;


public class FeedFragment extends Fragment implements FeedView{
    private static final String ARG_NEWS_LIST = "news_list";

    private List<News> mNewsList;
    private ProgressBar mProgressBar;
    private FeedPresenter mFeedPresenter;

    private RecyclerView mRecyclerView;
    private FeedAdapter mFeedAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance(List<News> newsList) {
        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_NEWS_LIST, newsList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //TODO:save newsList while changing device orientation
//            mNewsList = getArguments().getSerializable(ARG_NEWS_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_feed, container, false);
        initViews(v);
        mFeedPresenter = new FeedPresenterImp(this, new FeedNetworkInteractorImp());

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
}
