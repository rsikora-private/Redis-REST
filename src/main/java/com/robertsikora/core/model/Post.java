package com.robertsikora.core.model;

import java.util.Date;
import java.util.Objects;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class Post extends RedisEntity<Long> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(description, post.description) &&
                Objects.equals(enterDate, post.enterDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, enterDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("description='").append(description).append('\'');
        sb.append(", enterDate=").append(enterDate);
        sb.append('}');
        return sb.toString();
    }
}
