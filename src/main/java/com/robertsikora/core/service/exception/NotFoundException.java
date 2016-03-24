package com.robertsikora.core.service.exception;

/**
 * Created by robertsikora on 24.03.2016.
 */
public class NotFoundException extends RedisServiceException {

    public NotFoundException(){
    }

    public NotFoundException(final Throwable throwable) {
        super(throwable);
    }
}
