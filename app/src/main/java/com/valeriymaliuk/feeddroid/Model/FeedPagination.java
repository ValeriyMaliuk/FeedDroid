package com.valeriymaliuk.feeddroid.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gotaras on 28.11.2015.
 */
public class FeedPagination implements Serializable {
    @SerializedName("TotalPages")
    String totalPages;

    @SerializedName("PageNo")
    String pageNumber;

    @SerializedName("PerPage")
    String perPage;

    @SerializedName("WebURL")
    String webURL;

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }
}
