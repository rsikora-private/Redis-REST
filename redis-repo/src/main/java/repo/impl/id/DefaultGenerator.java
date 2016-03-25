package repo.impl.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.util.Assert;

/**
 * Created by robertsikora on 21.03.2016.
 */

class DefaultGenerator implements IdGenerator<Long> {

    @Autowired
    private RedisTemplate<String, Long> redisTemplate;

    @Override
    public Long generate(final String key) {
        Assert.hasText(key);
        final RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return counter.incrementAndGet();
    }
}
