package com.robertsikora.core.service.impl;

import com.robertsikora.core.service.api.CommonService;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class CommonServiceImpl<E> implements CommonService<E> {

    @Override
    public long create(E entity) {
        return 0;
    }

    @Override
    public E findById(long id) {
        return null;
    }
}
