package com.valeriymaliuk.feeddroid.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gotaras on 28.11.2015.
 */
public class NewsImage implements Serializable {

    @SerializedName("Photo")
    String photoURL;

    @SerializedName("Thumb")
    String thumbURL;

    @SerializedName("PhotoCaption")
    String photoCaption;


    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public String getPhotoCaption() {
        return photoCaption;
    }

    public void setPhotoCaption(String photoCaption) {
        this.photoCaption = photoCaption;
    }
}
