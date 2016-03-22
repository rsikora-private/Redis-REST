package com.robertsikora.core.service.impl;

import com.robertsikora.core.model.RedisEntity;
import com.robertsikora.core.repo.RedisRepo;
import com.robertsikora.core.service.CommonService;
import org.springframework.beans.factory.annotation.Required;

import java.io.Serializable;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class CommonServiceImpl<E extends RedisEntity, K extends Serializable>
        implements CommonService<E, K> {

    private RedisRepo<E, K> redisRepo;

    @Override
    public K create(final E entity) {
        return redisRepo.create(entity);
    }

    @Override
    public E findById(final K id) {
        return redisRepo.getById(id);
    }

    @Required
    public void setRedisRepo(final RedisRepo<E, K> redisRepo) {
        this.redisRepo = redisRepo;
    }
}
