package com.robertsikora.core.repo.id;

import java.io.Serializable;

/**
 * Created by robertsikora on 21.03.2016.
 */
public interface IdGenerator<K extends Serializable> {

    K generate(String key);
}
