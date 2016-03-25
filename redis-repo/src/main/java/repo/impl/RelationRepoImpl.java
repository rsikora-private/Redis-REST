package repo.impl;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import repo.RelationRepo;
import repo.exception.RepoException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by robertsikora on 25.03.2016.
 */
public class RelationRepoImpl<IDP extends Serializable, IDCH extends Serializable> implements RelationRepo<IDP, IDCH> {

    private RedisTemplate<String, IDCH> redisTemplate;
    private String relationName;

    @Override
    public void create(final IDP parentId, final IDCH childId) throws RepoException {
        try {
            redisTemplate.opsForList().leftPush(key(parentId), childId);
        } catch (DataAccessException dae) {
            throw new RepoException(dae);
        }
    }

    @Override
    public List<IDCH> findAllByParentId(final IDP parentId) throws RepoException {
        try {
            return redisTemplate.opsForList().range(key(parentId), 0, count(parentId));
        } catch (DataAccessException dae) {
            throw new RepoException(dae);
        }
    }

    @Override
    public List<IDCH> findByParentId(IDP parentId, long firstElement, long size) throws RepoException {
        try {
            return redisTemplate.opsForList().range(key(parentId), firstElement, firstElement + size);
        } catch (DataAccessException dae) {
            throw new RepoException(dae);
        }
    }

    @Override
    public long count(final IDP parentId) throws RepoException {
        try {
            return redisTemplate.opsForList().size(key(parentId));
        } catch (DataAccessException dae) {
            throw new RepoException(dae);
        }
    }

    private String key(final IDP parentId) {
        return relationName + ":" + parentId.toString();
    }

    @Required
    public void setRedisTemplate(final RedisTemplate<String, IDCH> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Required
    public void setRelationName(final String relationName) {
        this.relationName = relationName;
    }
}
