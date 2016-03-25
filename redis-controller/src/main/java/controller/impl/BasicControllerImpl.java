package controller.impl;

import model.RedisEntity;
import controller.BasicController;
import dto.Dto;
import dto.mapper.Mapper;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;
import service.CommonService;

/**
 * Created by robertsikora on 18.03.2016.
 */
abstract class BasicControllerImpl<E extends RedisEntity,
                                 D extends Dto> implements BasicController<D> {

    Mapper<E, D>                  mapper;
    CommonService<E> commonService;

    public long create(final D dto){
        Assert.notNull(dto);
        final E entity = commonService.create(map(dto));
        //noinspection unchecked
        return (Long) entity.getId();
    }

    public D findById(final long id){
        return map(commonService.findById(id));
    }

    public void delete(final long id){
        Assert.notNull(id);
        commonService.delete(id);
    }

    public E map(final D dto){
        return mapper.fromDTO(dto);
    }

    public D map(final E entity){
        return mapper.fromEntity(entity);
    }

    @Required
    public void setCommonService(final CommonService<E> commonService) {
        this.commonService = commonService;
    }

    @Required
    public void setMapper(final Mapper<E, D> mapper) {
        this.mapper = mapper;
    }
}
