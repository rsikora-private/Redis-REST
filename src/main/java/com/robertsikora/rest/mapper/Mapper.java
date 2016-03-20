package com.robertsikora.rest.mapper;

import org.springframework.util.Assert;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by robertsikora on 18.03.2016.
 */
public interface Mapper<E, D> {

    D fromEntity(E e);

    E fromDTO(D d);

    default Collection<E> fromDTOs(final Collection<D> dCollection){
        Assert.notEmpty(dCollection);
        return dCollection.stream().map(this::fromDTO).collect(Collectors.toList());
    }

    default Collection<D> fromEntries(final Collection<E> eCollection){
        Assert.notEmpty(eCollection);
        return eCollection.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
