package service.impl;

import repo.RedisRepo;
import service.CommonService;
import service.exception.NotFoundException;
import model.RedisEntity;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;
import java.util.Map;

/**
 * Created by robertsikora on 18.03.2016.
 */
abstract class CommonServiceImpl<E extends RedisEntity>
        implements CommonService<E> {

    private RedisRepo<E, Long> redisRepo;

    @Override
    public E create(final E entity) {
        Assert.notNull(entity);
        return redisRepo.create(entity);
    }

    @Override
    public E findById(final long id) {
        return redisRepo.getById(Long.valueOf(id)).orElseThrow(()
                -> new NotFoundException(String.format("There is not entity for id:%d", id)));
    }

    @Override
    public void delete(final long id) {
        redisRepo.delete(id);
    }

    @Override
    public Map<Object,Object> findAll(){
        return redisRepo.findAll();
    }

    @Required
    public void setRedisRepo(final RedisRepo<E, Long> redisRepo) {
        this.redisRepo = redisRepo;
    }
}
