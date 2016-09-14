package com.valeriymaliuk.feeddroid.api;

import com.valeriymaliuk.feeddroid.model.FeedResponse;
import com.valeriymaliuk.feeddroid.util.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by taras on 4/09/2016.
 */
public interface TimesOfIndiaService {

    @GET(Constants.URL_NEWS_DEFAULT_FEED)
    Call<FeedResponse> search(
            @Query(Constants.PARAM_FEED_TYPE) String key);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.URL_DOMAIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
