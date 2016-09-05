package com.valeriymaliuk.feeddroid.API;

import com.valeriymaliuk.feeddroid.Model.FeedResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by taras on 4/09/2016.
 */
public interface TheGuardianService {

    @GET("search")
    Call<FeedResponse> search(
            @Query("api-key") String key);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://content.guardianapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
