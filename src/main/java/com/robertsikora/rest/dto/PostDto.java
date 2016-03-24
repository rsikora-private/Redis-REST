package com.robertsikora.rest.dto;

import java.util.Date;

/**
 * Created by robertsikora on 24.03.2016.
 */
public class PostDto extends Dto {

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
