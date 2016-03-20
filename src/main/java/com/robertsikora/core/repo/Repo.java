package com.robertsikora.core.repo;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by robertsikora on 21.03.2016.
 */
public interface Repo<T, K extends Serializable> {

    K create(T entity);

    T getById(K id);

    Map<Object,Object> findAll();

    void delete(K id);
}
