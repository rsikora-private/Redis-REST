package com.robertsikora.rest.controller.impl;

import com.robertsikora.core.model.RedisEntity;
import com.robertsikora.core.service.CommonService;
import com.robertsikora.rest.controller.BasicController;
import com.robertsikora.rest.dto.Dto;
import com.robertsikora.rest.dto.mapper.Mapper;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Created by robertsikora on 18.03.2016.
 */
public abstract class BasicControllerImpl<E extends RedisEntity,
                                 D extends Dto,
                                 K extends Serializable>
        implements BasicController<D, K> {

    Mapper<E, D>            mapper;
    CommonService<E, K>     commonService;

    public K create(final D dto){
        Assert.notNull(dto);
        final E entity = commonService.create(map(dto));
        //noinspection unchecked
        return (K) entity.getId();
    }

    public D findById(final K id){
        return map(commonService.findById(id));
    }

    public void delete(final K id){
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
    public void setCommonService(final CommonService<E, K> commonService) {
        this.commonService = commonService;
    }

    @Required
    public void setMapper(final Mapper<E, D> mapper) {
        this.mapper = mapper;
    }
}
