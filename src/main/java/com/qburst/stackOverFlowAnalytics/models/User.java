package com.qburst.stackOverFlowAnalytics.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonTypeName(value = "user" )
public class User {
    @JacksonXmlProperty(isAttribute = true)
    private String Id;
    @JacksonXmlProperty(isAttribute = true)
    private int Reputation;
    @JacksonXmlProperty(isAttribute = true)
    private String CreationDate;
    @JacksonXmlProperty(isAttribute = true)
    private String DisplayName;
    @JacksonXmlProperty(isAttribute = true)
    private String LastAccessDate;
    @JacksonXmlProperty(isAttribute = true)
    private String WebsiteUrl;
    @JacksonXmlProperty(isAttribute = true)
    private String Location;
    @JacksonXmlProperty(isAttribute = true)
    private String AboutMe;
    @JacksonXmlProperty(isAttribute = true)
    private int Views;
    @JacksonXmlProperty(isAttribute = true)
    private int UpVotes;
    @JacksonXmlProperty(isAttribute = true)
    private int DownVotes;
    @JacksonXmlProperty(isAttribute = true)
    private String Age;
    @JacksonXmlProperty(isAttribute = true)
    private String AccountId;
    @JacksonXmlProperty(isAttribute = true)
    private String ProfileImageUrl;


    public User(String id, int reputation, String creationDate, String displayName, String lastAccessDate, String websiteUrl, String location, String aboutMe, int views, int upVotes, int downVotes, String age, String accountId, String profileImageUrl) {
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
        Age = age;
        AccountId = accountId;
        ProfileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrl() {
        return ProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        ProfileImageUrl = profileImageUrl;
    }

    public User() {
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public int getReputation() {
        return Reputation;
    }

    public void setReputation(int reputation) {
        Reputation = reputation;
    }

    public int getViews() {
        return Views;
    }

    public void setViews(int views) {
        Views = views;
    }

    public int getUpVotes() {
        return UpVotes;
    }

    public void setUpVotes(int upVotes) {
        UpVotes = upVotes;
    }

    public int getDownVotes() {
        return DownVotes;
    }

    public void setDownVotes(int downVotes) {
        DownVotes = downVotes;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String   getLocation() {
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

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }
}
