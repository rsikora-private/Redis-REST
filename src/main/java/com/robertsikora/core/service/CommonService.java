package com.robertsikora.core.service;

import com.robertsikora.core.model.RedisEntity;
import java.util.Map;

/**
 * Created by robertsikora on 18.03.2016.
 */
public interface CommonService<E extends RedisEntity> {

    E create(E entity);

    /**
     * Method return entity by id
     * @param id entity identifier
     * @return entity
     * @throws com.robertsikora.core.service.exception.NotFoundException
     */
    E findById(long id);

    void delete(long id);

    Map<Object,Object> findAll();
}
