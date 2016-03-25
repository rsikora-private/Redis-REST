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

    /**
     *
     * @param entity
     * @return saved entity
     * @throws RepoException
     */
    E create(E entity) throws RepoException;

    /**
     * Retrieve entity by id
     * @param id
     * @return
     */
    Optional<E> getById(ID id);

    /**
     * Returns all entries
     * @return
     * @throws RepoException
     */
    Map<Object, Object> findAll() throws RepoException;

    /**
     * Delete entity by id
     * @param id
     * @throws RepoException
     */
    void delete(ID id) throws RepoException;
}
