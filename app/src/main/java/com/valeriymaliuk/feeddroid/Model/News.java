package com.valeriymaliuk.feeddroid.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by taras on 5/09/2016.
 */
public class News implements Serializable{

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("sectionId")
    private String sectionId;

    @SerializedName("sectionName")
    private String sectionName;

    @SerializedName("webPublicationDate")
    private String publicationDate;

    @SerializedName("webTitle")
    private String title;

    @SerializedName("webUrl")
    private String webUrl;

    @SerializedName("apiUrl")
    private String apiUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
