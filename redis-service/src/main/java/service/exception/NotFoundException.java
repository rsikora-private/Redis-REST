package service.exception;

/**
 * Created by robertsikora on 24.03.2016.
 */
public class NotFoundException extends RedisServiceException {

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final Throwable throwable) {
        super(throwable);
    }
}
