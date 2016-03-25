package repo;

import repo.exception.RepoException;

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
     * @throws RepoException
     */
    void create(IDP parentId, IDCH childId) throws RepoException;

    /**
     * Returns all entities for parent
     * @param parentId
     * @return
     * @throws RepoException
     */
    List<IDCH> findAllByParentId(IDP parentId) throws RepoException;

    /**
     * Returns all entities for parent with paging
     * @param parentId
     * @param firstElement
     * @param size
     * @return
     * @throws RepoException
     */
    List<IDCH> findByParentId(IDP parentId, long firstElement, long size) throws RepoException;

    /**
     * Return count of entries
     * @param parentId
     * @return
     * @throws RepoException
     */
    long count(IDP parentId) throws RepoException;
}
