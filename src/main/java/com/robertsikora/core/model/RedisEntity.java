package com.robertsikora.core.model;

import java.io.Serializable;

/**
 * Created by robertsikora on 19.03.2016.
 */
public abstract class RedisEntity<K extends Serializable> {

    private K id;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }
}