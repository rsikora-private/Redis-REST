package com.robertsikora.core.service.api;

import com.robertsikora.core.service.model.User;

/**
 * Created by robertsikora on 18.03.2016.
 */
public interface CommonService<E> {

    long create(E entity);

    E findById(long id);
}
