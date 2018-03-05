package com.examples.android.healthcross.Model;

import java.util.List;

import javax.xml.transform.Source;

public class WebSite {
    private String status;
    private List<Source> sources;

    public WebSite() {
    }

    public WebSite(String status, List<Source> sources) {
        this.sources = sources;
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
