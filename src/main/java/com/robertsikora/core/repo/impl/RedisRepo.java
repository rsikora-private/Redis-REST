package com.robertsikora.core.repo;

import com.robertsikora.core.model.RedisEntity;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * Created by robertsikora on 21.03.2016.
 */
public interface RedisRepo<E extends RedisEntity, ID extends Serializable> {

    E create(E entity);

    Optional<E> getById(ID id);

    Map<Object,Object> findAll();

    void delete(ID id);
}
