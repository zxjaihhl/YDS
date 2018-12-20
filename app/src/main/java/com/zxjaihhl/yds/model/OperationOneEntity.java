package com.zxjaihhl.yds.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class OperationOneEntity implements Serializable {

    private String title;
    private String subtitle;
    private String image_url;

    public OperationOneEntity() {
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public OperationOneEntity(String title, String subtitle, String image_url) {
        this.title = title;
        this.subtitle = subtitle;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

