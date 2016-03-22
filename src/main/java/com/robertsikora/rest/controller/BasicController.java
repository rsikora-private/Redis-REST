package com.robertsikora.rest.controller;

import com.robertsikora.core.model.RedisEntity;
import com.robertsikora.core.service.CommonService;
import com.robertsikora.rest.dto.Dto;
import com.robertsikora.rest.mapper.Mapper;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class BasicController<E extends RedisEntity, D extends Dto> {

    private Mapper<E, D>     mapper;
    private CommonService<E, Long> commonService;

    public D findById(final Long id){
        return map(commonService.findById(id));
    }

    public Long create(final D entity){
        Assert.notNull(entity);
        return commonService.create(map(entity));
    }

    public E map(final D dto){
        return mapper.fromDTO(dto);
    }

    public D map(final E entity){
        return mapper.fromEntity(entity);
    }

    @Required
    public void setCommonService(final CommonService<E, Long> commonService) {
        this.commonService = commonService;
    }
    @Required
    public void setMapper(final Mapper<E, D> mapper) {
        this.mapper = mapper;
    }
}
