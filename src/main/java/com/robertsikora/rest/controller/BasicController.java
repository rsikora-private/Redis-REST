package com.robertsikora.rest.controller;

import com.robertsikora.rest.dto.Dto;
import java.io.Serializable;

/**
 * Created by robertsikora on 24.03.2016.
 */
public interface BasicController <D extends Dto, K extends Serializable> {

   K create(D dto);

   D findById(K id);

   void delete(K id);
}
