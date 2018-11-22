package com.example.namp5.intent_permission;

/**
 * Created by namp5 on 11/22/2018.
 */

public class Photo {
    private String mTitle ;
    private String mUrl;

    public Photo(String mTitle, String mUrl) {
        this.mTitle = mTitle;
        this.mUrl = mUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
