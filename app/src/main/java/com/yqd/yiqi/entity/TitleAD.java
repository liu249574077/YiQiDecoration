package com.yqd.yiqi.entity;

/**
 * Created by admin on 2017/1/5.
 */

public class TitleAD {
    private String title;
    private String imagesrc;
    private String imagesrc2;
    private String tid;
    private int type;
    private String banner_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public String getImagesrc2() {
        return imagesrc2;
    }

    public void setImagesrc2(String imagesrc2) {
        this.imagesrc2 = imagesrc2;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    @Override
    public String toString() {
        return "TitleAD{" +
                "title='" + title + '\'' +
                ", imagesrc='" + imagesrc + '\'' +
                ", imagesrc2='" + imagesrc2 + '\'' +
                ", tid='" + tid + '\'' +
                ", type=" + type +
                ", banner_url='" + banner_url + '\'' +
                '}';
    }
}
