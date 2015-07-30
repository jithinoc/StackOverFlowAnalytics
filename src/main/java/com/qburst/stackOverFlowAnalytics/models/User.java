package com.qburst.stackOverFlowAnalytics.models;

public class User {
    private String Id;
    private String Reputation;
    private String CreationDate;
    private String DisplayName;
    private String LastAccessDate;
    private String WebsiteUrl;
    private String Location;
    private String AboutMe;
    private String Views;
    private String UpVotes;
    private String DownVotes;
    private String AccountId;

    public User() {
    }

    public User(String id, String reputation, String creationDate, String displayName, String lastAccessDate, String websiteUrl, String location, String aboutMe, String views, String upVotes, String downVotes, String accountId) {
        Id = id;
        Reputation = reputation;
        CreationDate = creationDate;
        DisplayName = displayName;
        LastAccessDate = lastAccessDate;
        WebsiteUrl = websiteUrl;
        Location = location;
        AboutMe = aboutMe;
        Views = views;
        UpVotes = upVotes;
        DownVotes = downVotes;
        AccountId = accountId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getReputation() {
        return Reputation;
    }

    public void setReputation(String reputation) {
        Reputation = reputation;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getLastAccessDate() {
        return LastAccessDate;
    }

    public void setLastAccessDate(String lastAccessDate) {
        LastAccessDate = lastAccessDate;
    }

    public String getWebsiteUrl() {
        return WebsiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        WebsiteUrl = websiteUrl;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAboutMe() {
        return AboutMe;
    }

    public void setAboutMe(String aboutMe) {
        AboutMe = aboutMe;
    }

    public String getViews() {
        return Views;
    }

    public void setViews(String views) {
        Views = views;
    }

    public String getUpVotes() {
        return UpVotes;
    }

    public void setUpVotes(String upVotes) {
        UpVotes = upVotes;
    }

    public String getDownVotes() {
        return DownVotes;
    }

    public void setDownVotes(String downVotes) {
        DownVotes = downVotes;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }
}
