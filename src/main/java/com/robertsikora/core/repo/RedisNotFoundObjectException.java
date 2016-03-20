package com.robertsikora.core.repo;

/**
 * Created by robertsikora on 21.03.2016.
 */
public class RedisNotFoundObjectException extends RuntimeException {

    public RedisNotFoundObjectException(final String message){
        super(message);
    }
}
