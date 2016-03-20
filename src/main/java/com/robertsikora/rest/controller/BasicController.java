package com.robertsikora.rest.controller;

import com.robertsikora.core.service.api.CommonService;
import com.robertsikora.core.service.model.RedisEntity;
import com.robertsikora.rest.dto.Dto;
import com.robertsikora.rest.mapper.Mapper;
import org.springframework.util.Assert;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class BasicController<E extends RedisEntity, D extends Dto> {

    private Mapper<E, D>     mapper;
    private CommonService<E> commonService;

    public D findById(final long id){
        return map(commonService.findById(id));
    }

    public long create(final D entity){
        Assert.notNull(entity);
        return commonService.create(map(entity));
    }

    public E map(final D dto){
        return mapper.fromDTO(dto);
    }

    public D map(final E entity){
        return mapper.fromEntity(entity);
    }

    public CommonService<E> getCommonService() {
        return commonService;
    }

    public void setCommonService(final CommonService<E> commonService) {
        this.commonService = commonService;
    }

    public void setMapper(final Mapper<E, D> mapper) {
        this.mapper = mapper;
    }
}
