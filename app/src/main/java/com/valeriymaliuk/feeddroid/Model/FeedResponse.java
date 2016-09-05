package com.valeriymaliuk.feeddroid.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by taras on 4/09/2016.
 */
public class FeedResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("orderBy")
    private String orderBy;

    @SerializedName("currentPage")
    private int currentPage;

    @SerializedName("results")
    private List<News> results;
}
