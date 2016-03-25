package repo;

import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
/**
 * Created by robertsikora on 25.03.2016.
 */

/**
 * Repo for relations between objects.
 *
 * @param <IDP>  id of parent object
 * @param <IDCH> id of child object
 */

public interface RelationRepo<IDP extends Serializable, IDCH extends Serializable> {

    /**
     * Create relation One to many between parent and child entity
     * @param parentId
     * @param childId
     * @throws DataAccessException
     */
    void create(IDP parentId, IDCH childId) throws DataAccessException;

    /**
     * Returns all entities for parent
     * @param parentId
     * @return
     * @throws DataAccessException
     */
    List<IDCH> findAllByParentId(IDP parentId) throws DataAccessException;

    /**
     * Returns all entities for parent with paging
     * @param parentId
     * @param firstElement
     * @param size
     * @return
     * @throws DataAccessException
     */
    List<IDCH> findByParentId(IDP parentId, long firstElement, long size) throws DataAccessException;

    /**
     * Return count of entries
     * @param parentId
     * @return
     * @throws DataAccessException
     */
    long count(IDP parentId) throws DataAccessException;
}
