package com.valeriymaliuk.feeddroid.Fragment;

import android.util.Log;

import com.valeriymaliuk.feeddroid.API.TimesOfIndiaService;
import com.valeriymaliuk.feeddroid.Model.FeedResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by valeriymaliuk on 9/13/16.
 */
public class FeedNetworkInteractorImp implements FeedInteractor {

    private static final String TAG = "FeedNetworkInteractorIm";

    @Override
    public void getNewsList(final OnInteractorResult callback) {
        //TODO: fire API and return list of news
        TimesOfIndiaService theGuardianService =
                TimesOfIndiaService.retrofit.create(TimesOfIndiaService.class);
        Call<FeedResponse> call = theGuardianService.search("sjson");
        FeedResponse result = null;
        call.enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response){
                FeedResponse feedResponse = response.body();
                Log.d(TAG,feedResponse.toString());
                callback.onSuccess(feedResponse.getNewsList());
            }
            @Override
            public void onFailure (Call < FeedResponse > call, Throwable t){
                // TODO: make some clever error handling
                callback.onFailure();
            }
        }

    );
}
}
