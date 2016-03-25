package service.impl;

import model.RedisEntity;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;
import repo.ObjectRepo;
import service.CommonService;
import service.exception.NotFoundException;

import java.util.Map;

/**
 * Created by robertsikora on 18.03.2016.
 */
abstract class CommonServiceImpl<E extends RedisEntity>
        implements CommonService<E> {

    private ObjectRepo<E, Long> objectRepo;

    @Override
    public E create(final E entity) {
        Assert.notNull(entity);
        return objectRepo.create(entity);
    }

    @Override
    public E findById(final long id) {
        return objectRepo.getById(Long.valueOf(id)).orElseThrow(()
                -> new NotFoundException(String.format("There is not entity for id:%d", id)));
    }

    @Override
    public void delete(final long id) {
        objectRepo.delete(id);
    }

    @Override
    public Map<Object, Object> findAll() {
        return objectRepo.findAll();
    }

    @Required
    public void setObjectRepo(final ObjectRepo<E, Long> objectRepo) {
        this.objectRepo = objectRepo;
    }
}
