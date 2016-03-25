package repo.impl;

import model.RedisEntity;
import repo.RedisRepo;
import repo.id.IdGenerator;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * Created by robertsikora on 21.03.2016.
 */
abstract class RedisRepoImpl<T extends RedisEntity,
        ID extends Serializable> implements RedisRepo<T, ID> {

    private Class<T>                         clazz;
    private RedisTemplate<String, T>         redisTemplate;
    private IdGenerator<ID>                  idGenerator;

    public T create(final T entity){
        Assert.notNull(entity);
        final ID id = idGenerator.generate(key());
        this.redisTemplate.opsForHash().put(key(), id, entity);
        entity.setId(id);
        return entity;
    }

    public Optional<T> getById(final ID id){
        Assert.notNull(id);
        return Optional.ofNullable((T)this.redisTemplate.opsForHash().get(key(), id));
    }

    @Override
    public Map<Object,Object> findAll() {
        return this.redisTemplate.opsForHash().entries(key());
    }

    @Override
    public void delete(final ID id) {
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
    public void setIdGenerator(final IdGenerator<ID> idGenerator) {
        this.idGenerator = idGenerator;
    }
}