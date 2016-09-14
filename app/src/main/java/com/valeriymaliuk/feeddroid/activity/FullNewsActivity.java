package com.valeriymaliuk.feeddroid.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.valeriymaliuk.feeddroid.R;
import com.valeriymaliuk.feeddroid.fragment.FullNewsFragment;
import com.valeriymaliuk.feeddroid.model.News;
import com.valeriymaliuk.feeddroid.util.Constants;

/**
 * Created by gotaras on 26.11.2015.
 */
public class FullNewsActivity extends AppCompatActivity {

    FullNewsFragment mFullNewsFragment;
    News mNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);

        mNews = (News) getIntent().getExtras().get(Constants.EXTRAS_PARAM_NEWS);
        if (mNews !=null) setupActionBar(mNews.getHeadLine());

        if (findViewById(R.id.fragment_full_news_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            mFullNewsFragment = new FullNewsFragment();
            mFullNewsFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_full_news_container, mFullNewsFragment).commit();
        }
    }
    private  void setupActionBar(String title){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public void onBackPressed() {
        WebView webView = mFullNewsFragment.mWebView;

        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
