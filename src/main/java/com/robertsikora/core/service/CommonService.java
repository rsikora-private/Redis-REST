package com.robertsikora.core.service;

import com.robertsikora.core.model.RedisEntity;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by robertsikora on 18.03.2016.
 */
public interface CommonService<E extends RedisEntity, K extends Serializable> {

    E create(E entity);

    /**
     * Method return entity by id
     * @param id entity identifier
     * @return entity
     * @throws com.robertsikora.core.service.exception.NotFoundException
     */
    E findById(K id);

    void delete(K id);

    Map<Object,Object> findAll();
}
