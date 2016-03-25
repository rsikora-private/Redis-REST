package repo;

import model.RedisEntity;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

/**
 * Created by robertsikora on 21.03.2016.
 */
public interface ObjectRepo<E extends RedisEntity, ID extends Serializable> {

    /**
     * @param entity
     * @return saved entity
     * @throws DataAccessException
     */
    E create(E entity) throws DataAccessException;

    /**
     * Retrieve entity by id
     *
     * @param id
     * @return
     */
    Optional<E> getById(ID id);

    /**
     * Returns all entries
     *
     * @return
     * @throws DataAccessException
     */
    Map<Object, Object> findAll() throws DataAccessException;

    /**
     * Delete entity by id
     *
     * @param id
     * @throws DataAccessException
     */
    void delete(ID id) throws DataAccessException;
}
