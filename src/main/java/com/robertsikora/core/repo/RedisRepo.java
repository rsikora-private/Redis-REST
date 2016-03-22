package com.robertsikora.core.repo;

import com.robertsikora.core.model.RedisEntity;
import com.robertsikora.core.repo.id.IdGenerator;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by robertsikora on 21.03.2016.
 */
public abstract class RedisRepo<T extends RedisEntity, K extends Serializable> implements Repo<T, K> {

    private Class<T>                        clazz;
    private RedisTemplate<String, T>        redisTemplate;
    private IdGenerator<K>                  idGenerator;

    public K create(final T entity){
        Assert.notNull(entity);
        final K id = idGenerator.generate(key());
        this.redisTemplate.opsForHash().put(key(), id, entity);
        return id;
    }

    public T getById(final K id){
        Assert.notNull(id);
        @SuppressWarnings("unchecked")
        final T entity = (T)this.redisTemplate.opsForHash().get(key(), id);
        if(entity == null){
            throw new RedisNotFoundObjectException("Cannot find value for key:" + id);
        }
        return entity;
    }

    @Override
    public Map<Object,Object> findAll() {
        return this.redisTemplate.opsForHash().entries(key());

    }

    @Override
    public void delete(final K id) {
        Assert.notNull(id);
        this.redisTemplate.opsForHash().delete(key(),id);
    }

    private String key(){
        return clazz.getSimpleName();
    }

    @Required
    public void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }
    @Required
    public void setRedisTemplate(final RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @Required
    public void setIdGenerator(final IdGenerator<K> idGenerator) {
        this.idGenerator = idGenerator;
    }
}
