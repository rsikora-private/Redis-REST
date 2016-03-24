package com.robertsikora.core.repo;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * Created by robertsikora on 21.03.2016.
 */
public interface Repo<T, K extends Serializable> {

    T create(T entity);

    Optional<T> getById(K id);

    Map<Object,Object> findAll();

    void delete(K id);
}
