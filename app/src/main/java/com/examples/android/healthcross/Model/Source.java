package com.examples.android.healthcross.Model;

import java.util.List;

/**
 * Created by shava on 2018-03-03.
 */

class URLsToLogos{
    private String small,medium,large;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}

public class Source {
    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;
    private URLsToLogos urlstoLogos;
    private List<String> sortbysAvailable;

    public Source() {
    }

    public Source(String id) {
        this.id = id;
    }

}
