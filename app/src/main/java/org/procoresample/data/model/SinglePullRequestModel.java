package org.procoresample.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SinglePullRequestModel {

    @SerializedName("patch")
    @Expose
    private String patch;

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

}
