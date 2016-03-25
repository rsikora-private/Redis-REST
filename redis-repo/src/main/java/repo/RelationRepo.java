package repo;

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

    void create(IDP parentId, IDCH childId);

    List<IDCH> findAllByParentId(IDP parentId);

    List<IDCH> findByParentId(IDP parentId, long firstElement, long size);

    long count(IDP parentId);
}
