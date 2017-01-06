package com.yqd.yiqi.entity;

import java.util.List;

/**
 * Created by admin on 2017/1/5.
 */

public class TitleADBean {
    private String error;
    private String message;
    private List<TitleAD> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TitleAD> getData() {
        return data;
    }

    public void setData(List<TitleAD> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TitleADBean{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
