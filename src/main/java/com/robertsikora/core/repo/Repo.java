package com.robertsikora.core.repo;

import com.robertsikora.core.model.RedisEntity;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * Created by robertsikora on 21.03.2016.
 */
public interface Repo<E extends RedisEntity, K extends Serializable> {

    E create(E entity);

    Optional<E> getById(K id);

    Map<Object,Object> findAll();

    void delete(K id);
}
