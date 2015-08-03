package com.qburst.stackOverFlowAnalytics.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonTypeName(value = "post" )
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
    private int Score;
    @JacksonXmlProperty(isAttribute = true)
    private int ViewCount;
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
    private int AnswerCount;
    @JacksonXmlProperty(isAttribute = true)
    private int CommentCount;
    @JacksonXmlProperty(isAttribute = true)
    private int FavoriteCount;
    @JacksonXmlProperty(isAttribute = true)
    private String CommunityOwnedDate;
    @JacksonXmlProperty(isAttribute = true)
    private String ParentId;
    @JacksonXmlProperty(isAttribute = true)
    private String OwnerDisplayName;
    @JacksonXmlProperty(isAttribute = true)
    private String ClosedDate;

    public Post(String id, String postTypeId, String acceptedAnswerId, String creationDate, int score, int viewCount, String body, String ownerUserId, String lastEditorUserId, String lastEditorDisplayName, String lastEditDate, String lastActivityDate, String title, String tags, int answerCount, int commentCount, int favoriteCount, String communityOwnedDate, String parentId, String ownerDisplayName, String closedDate) {
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
        ParentId = parentId;
        OwnerDisplayName = ownerDisplayName;
        ClosedDate = closedDate;
    }

    public String getOwnerDisplayName() {
        return OwnerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        OwnerDisplayName = ownerDisplayName;
    }

    public String getClosedDate() {
        return ClosedDate;
    }

    public void setClosedDate(String closedDate) {
        ClosedDate = closedDate;
    }

    public String getParentId() {
        return ParentId;

    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }

    public Post() {
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

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void setViewCount(int viewCount) {
        ViewCount = viewCount;
    }

    public int getAnswerCount() {
        return AnswerCount;
    }

    public void setAnswerCount(int answerCount) {
        AnswerCount = answerCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    public int getFavoriteCount() {
        return FavoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        FavoriteCount = favoriteCount;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
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

    public String getCommunityOwnedDate() {
        return CommunityOwnedDate;
    }

    public void setCommunityOwnedDate(String communityOwnedDate) {
        CommunityOwnedDate = communityOwnedDate;
    }
}
