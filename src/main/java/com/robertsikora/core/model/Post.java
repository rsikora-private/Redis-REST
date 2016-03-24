package com.robertsikora.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class Post extends RedisEntity<Long> implements Serializable {

    private String description;
    private Date enterDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
}
