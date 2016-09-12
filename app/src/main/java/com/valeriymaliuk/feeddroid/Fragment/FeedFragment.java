package com.valeriymaliuk.feeddroid.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valeriymaliuk.feeddroid.Model.News;
import com.valeriymaliuk.feeddroid.R;

import java.util.List;


public class FeedFragment extends Fragment implements FeedView{
    private static final String ARG_NEWS_LIST = "news_list";

    private List<News> mNewsList;

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
//            mNewsList = getArguments().getSerializable(ARG_NEWS_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(List<News> items) {

    }

    @Override
    public void showMessage(String message) {

    }
}
