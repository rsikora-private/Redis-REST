package com.robertsikora.core.service;

import com.robertsikora.core.model.RedisEntity;

import java.io.Serializable;

/**
 * Created by robertsikora on 18.03.2016.
 */
public interface CommonService<E extends RedisEntity, K extends Serializable> {

    K create(E entity);

    E findById(K id);
}
