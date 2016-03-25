package dto;

import java.io.Serializable;

/**
 * Created by robertsikora on 19.03.2016.
 */
public abstract class Dto implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
