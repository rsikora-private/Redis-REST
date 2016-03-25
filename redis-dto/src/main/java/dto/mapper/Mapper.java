package dto.mapper;

import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robertsikora on 18.03.2016.
 */
public interface Mapper<E, D> {

    D fromEntity(E e);

    E fromDTO(D d);

    default List<E> fromDTOs(final Collection<D> dCollection) {
        Assert.notEmpty(dCollection);
        return dCollection.stream().map(this::fromDTO).collect(Collectors.toList());
    }

    default List<D> fromEntries(final Collection<E> eCollection) {
        Assert.notEmpty(eCollection);
        return eCollection.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
