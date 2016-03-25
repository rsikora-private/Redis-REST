package repo;

import model.RedisEntity;
import repo.exception.RepoException;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * Created by robertsikora on 21.03.2016.
 */
public interface ObjectRepo<E extends RedisEntity, ID extends Serializable> {

    E create(E entity) throws RepoException;

    Optional<E> getById(ID id);

    Map<Object, Object> findAll() throws RepoException;

    void delete(ID id) throws RepoException;
}
