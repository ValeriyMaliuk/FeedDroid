package com.valeriymaliuk.feeddroid.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.valeriymaliuk.feeddroid.R;
import com.valeriymaliuk.feeddroid.model.News;
import com.valeriymaliuk.feeddroid.util.Constants;


/**
 * Created by gotaras on 28.11.2015.
 */
public class FullNewsFragment extends Fragment {

    public WebView mWebView;
    private News mNews;
    private String mFullNewsUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_full_news, null);
        mWebView = (WebView) v.findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());

        mNews = (News) getArguments().get(Constants.EXTRAS_PARAM_NEWS);
        if (mNews != null) mFullNewsUrl = mNews.getNewsURL();
        if (mFullNewsUrl == null) mFullNewsUrl = Constants.URL_DOMAIN_URL;

        mWebView.loadUrl(mFullNewsUrl);
        return v;
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mFullNewsUrl = url;
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

}
