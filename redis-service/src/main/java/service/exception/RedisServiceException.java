package service.exception;

/**
 * Created by robertsikora on 24.03.2016.
 */
public class RedisServiceException extends RuntimeException {

    public RedisServiceException(final String message) {
        super(message);
    }

    public RedisServiceException(final Throwable throwable) {
        super(throwable);
    }
}
