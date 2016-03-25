package controller;

import dto.Dto;

import java.util.Map;

/**
 * Created by robertsikora on 24.03.2016.
 */
public interface BasicController<D extends Dto> {

    long create(D dto);

    D findById(long id);

    void delete(long id);

    Map<Object, Object> findAll();
}
