package com.valeriymaliuk.feeddroid.interactor;

import android.util.Log;

import com.valeriymaliuk.feeddroid.api.TimesOfIndiaService;
import com.valeriymaliuk.feeddroid.interactor.FeedInteractor;
import com.valeriymaliuk.feeddroid.model.FeedResponse;
import com.valeriymaliuk.feeddroid.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by valeriymaliuk on 9/13/16.
 */
public class FeedNetworkInteractorImp implements FeedInteractor {

    private static final String TAG = "FeedNetworkInteractorIm";

    @Override
    public void getNewsList(final OnInteractorResult callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.URL_DOMAIN_URL)
                .build();

        TimesOfIndiaService weatherService = retrofit.create(TimesOfIndiaService.class);
        Observable<FeedResponse> london = weatherService.search(Constants.RESPONSE_TYPE_JSON);

        london.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FeedResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: make some clever error handling
                        callback.onFailure();
                    }

                    @Override
                    public void onNext(FeedResponse feedResponse) {
                        Log.d(TAG, feedResponse.toString());
                        callback.onSuccess(feedResponse.getNewsList());
                    }
                });


    }
}
