package com.robertsikora.core.service.exception;

/**
 * Created by robertsikora on 24.03.2016.
 */
public class RedisServiceException extends RuntimeException {

    public RedisServiceException(){
    }

    public RedisServiceException(final Throwable throwable){
        super(throwable);
    }
}
