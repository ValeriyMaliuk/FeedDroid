package com.valeriymaliuk.feeddroid.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by taras on 4/09/2016.
 */
public class FeedResponse  implements Serializable{

    @SerializedName("Pagination")
    FeedPagination pagination;

    @SerializedName("NewsItem")
    List<News> newsList;

    public FeedPagination getPagination() {
        return pagination;
    }

    public void setPagination(FeedPagination pagination) {
        this.pagination = pagination;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public String toString() {
        return "FeedResponse{" +
                "pagination=" + pagination +
                ", newsList=" + newsList +
                '}';
    }
}
