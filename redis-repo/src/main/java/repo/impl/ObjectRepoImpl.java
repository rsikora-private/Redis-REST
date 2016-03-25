package repo.impl;

import model.RedisEntity;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;
import repo.ObjectRepo;
import repo.exception.RepoException;
import repo.impl.id.IdGenerator;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * Created by robertsikora on 21.03.2016.
 */
abstract class ObjectRepoImpl<T extends RedisEntity,
        ID extends Serializable> implements ObjectRepo<T, ID> {

    private Class<T> clazz;
    private RedisTemplate<String, T> redisTemplate;
    private IdGenerator<ID> idGenerator;

    public T create(final T entity) throws RepoException {
        Assert.notNull(entity);
        try {
            final ID id = idGenerator.generate(key());
            this.redisTemplate.opsForHash().put(key(), id, entity);
            entity.setId(id);
        } catch (DataAccessException dae) {
            throw new RepoException(dae);
        }
        return entity;
    }

    public Optional<T> getById(final ID id) {
        Assert.notNull(id);
        T t;
        try {
            t = (T) this.redisTemplate.opsForHash().get(key(), id);
            if (t != null) {
                t.setId(id);
            }
        } catch (DataAccessException dae) {
            return Optional.empty();
        }
        return Optional.ofNullable(t);
    }

    @Override
    public Map<Object, Object> findAll() throws RepoException {
        try {
            return this.redisTemplate.opsForHash().entries(key());
        } catch (DataAccessException dae) {
            throw new RepoException(dae);
        }
    }

    @Override
    public void delete(final ID id) throws RepoException {
        Assert.notNull(id);
        try {
            this.redisTemplate.opsForHash().delete(key(), id);
        } catch (DataAccessException dae) {
            throw new RepoException(dae);
        }
    }

    private String key() {
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
