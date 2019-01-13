package org.procoresample.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PullRequestsModel {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("user")
    @Expose
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public class User {

        @SerializedName("avatar_url")
        @Expose
        private String avatar_url;

        public String getAvatar_url() {
            return avatar_url;
        }

    }
}
