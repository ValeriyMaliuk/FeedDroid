package com.valeriymaliuk.feeddroid.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by taras on 5/09/2016.
 */
public class News implements Serializable {

    @SerializedName("NewsItemId")
    String newsItemId;

    @SerializedName("HeadLine")
    String headLine;

    @SerializedName("ByLine")
    String byLine;

    @SerializedName("Agency")
    String agency;

    @SerializedName("DateLine")
    String dateLine;

    @SerializedName("WebURL")
    String newsURL;

    @SerializedName("Caption")
    String caption;

    @SerializedName("Keywords")
    String keywords;

    @SerializedName("Story")
    String story;

    @SerializedName("CommentCountUrl")
    String commentCountURL;

    @SerializedName("CommentFeedUrl")
    String commentFeedURL;

    @SerializedName("Related")
    String relatedNewsURL;

    @SerializedName("Image")
    NewsImage newsImage;

    public String getNewsItemId() {
        return newsItemId;
    }

    public void setNewsItemId(String newsItemId) {
        this.newsItemId = newsItemId;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getByLine() {
        return byLine;
    }

    public void setByLine(String byLine) {
        this.byLine = byLine;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getDateLine() {
        return dateLine;
    }

    public void setDateLine(String dateLine) {
        this.dateLine = dateLine;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public void setNewsURL(String newsURL) {
        this.newsURL = newsURL;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getCommentCountURL() {
        return commentCountURL;
    }

    public void setCommentCountURL(String commentCountURL) {
        this.commentCountURL = commentCountURL;
    }

    public String getCommentFeedURL() {
        return commentFeedURL;
    }

    public void setCommentFeedURL(String commentFeedURL) {
        this.commentFeedURL = commentFeedURL;
    }

    public String getRelatedNewsURL() {
        return relatedNewsURL;
    }

    public void setRelatedNewsURL(String relatedNewsURL) {
        this.relatedNewsURL = relatedNewsURL;
    }

    public NewsImage getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(NewsImage newsImage) {
        this.newsImage = newsImage;
    }

    public String getFormattedDate(){
        String formattedDate = "";
        if(this.dateLine != null){
            SimpleDateFormat formatDefault = new SimpleDateFormat("MMM dd, yyyy, hh.mma", Locale.US);
            SimpleDateFormat formatApp     = new SimpleDateFormat("MMM dd, HH:mm", Locale.US);
            try {
                Date parsed   = formatDefault.parse(this.dateLine );
                formattedDate = formatApp.format(parsed);
            }
            catch(ParseException pe) { }
        }

        return formattedDate;
    }


}
