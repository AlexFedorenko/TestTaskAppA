package com.example.dizzer.testtaskappa.model;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class LinkModel {

    private long linkID;
    private String link;
    private int status;
    private long time;

    public LinkModel(long linkID, String link, int status, long time) {
        this.linkID = linkID;
        this.link = link;
        this.status = status;
        this.time = time;
    }

    public long getLinkID() {
        return linkID;
    }

    public String getLink() {
        return link;
    }

    public int getStatus() {
        return status;
    }

    public long getTime() {
        return time;
    }

}
