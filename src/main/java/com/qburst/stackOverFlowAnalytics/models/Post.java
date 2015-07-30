package com.qburst.stackOverFlowAnalytics.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Post {
    @JacksonXmlProperty(isAttribute = true)
    private String Id;
    @JacksonXmlProperty(isAttribute = true)
    private String PostTypeId;
    @JacksonXmlProperty(isAttribute = true)
    private String AcceptedAnswerId;
    @JacksonXmlProperty(isAttribute = true)
    private String CreationDate;
    @JacksonXmlProperty(isAttribute = true)
    private String Score;
    @JacksonXmlProperty(isAttribute = true)
    private String ViewCount;
    @JacksonXmlProperty(isAttribute = true)
    private String Body;
    @JacksonXmlProperty(isAttribute = true)
    private String OwnerUserId;
    @JacksonXmlProperty(isAttribute = true)
    private String LastEditorUserId;
    @JacksonXmlProperty(isAttribute = true)
    private String LastEditorDisplayName;
    @JacksonXmlProperty(isAttribute = true)
    private String LastEditDate;
    @JacksonXmlProperty(isAttribute = true)
    private String LastActivityDate;
    @JacksonXmlProperty(isAttribute = true)
    private String Title;
    @JacksonXmlProperty(isAttribute = true)
    private String Tags;
    @JacksonXmlProperty(isAttribute = true)
    private String AnswerCount;
    @JacksonXmlProperty(isAttribute = true)
    private String CommentCount;
    @JacksonXmlProperty(isAttribute = true)
    private String FavoriteCount;
    @JacksonXmlProperty(isAttribute = true)
    private String CommunityOwnedDate;

    public Post() {
    }

    public Post(String id, String postTypeId, String acceptedAnswerId, String creationDate, String score, String viewCount, String body, String ownerUserId, String lastEditorUserId, String lastEditorDisplayName, String lastEditDate, String lastActivityDate, String title, String tags, String answerCount, String commentCount, String favoriteCount, String communityOwnedDate) {
        Id = id;
        PostTypeId = postTypeId;
        AcceptedAnswerId = acceptedAnswerId;
        CreationDate = creationDate;
        Score = score;
        ViewCount = viewCount;
        Body = body;
        OwnerUserId = ownerUserId;
        LastEditorUserId = lastEditorUserId;
        LastEditorDisplayName = lastEditorDisplayName;
        LastEditDate = lastEditDate;
        LastActivityDate = lastActivityDate;
        Title = title;
        Tags = tags;
        AnswerCount = answerCount;
        CommentCount = commentCount;
        FavoriteCount = favoriteCount;
        CommunityOwnedDate = communityOwnedDate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPostTypeId() {
        return PostTypeId;
    }

    public void setPostTypeId(String postTypeId) {
        PostTypeId = postTypeId;
    }

    public String getAcceptedAnswerId() {
        return AcceptedAnswerId;
    }

    public void setAcceptedAnswerId(String acceptedAnswerId) {
        AcceptedAnswerId = acceptedAnswerId;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getViewCount() {
        return ViewCount;
    }

    public void setViewCount(String viewCount) {
        ViewCount = viewCount;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getOwnerUserId() {
        return OwnerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        OwnerUserId = ownerUserId;
    }

    public String getLastEditorUserId() {
        return LastEditorUserId;
    }

    public void setLastEditorUserId(String lastEditorUserId) {
        LastEditorUserId = lastEditorUserId;
    }

    public String getLastEditorDisplayName() {
        return LastEditorDisplayName;
    }

    public void setLastEditorDisplayName(String lastEditorDisplayName) {
        LastEditorDisplayName = lastEditorDisplayName;
    }

    public String getLastEditDate() {
        return LastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        LastEditDate = lastEditDate;
    }

    public String getLastActivityDate() {
        return LastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        LastActivityDate = lastActivityDate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getAnswerCount() {
        return AnswerCount;
    }

    public void setAnswerCount(String answerCount) {
        AnswerCount = answerCount;
    }

    public String getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(String commentCount) {
        CommentCount = commentCount;
    }

    public String getFavoriteCount() {
        return FavoriteCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        FavoriteCount = favoriteCount;
    }

    public String getCommunityOwnedDate() {
        return CommunityOwnedDate;
    }

    public void setCommunityOwnedDate(String communityOwnedDate) {
        CommunityOwnedDate = communityOwnedDate;
    }
}
