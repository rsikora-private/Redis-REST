package com.robertsikora.rest.endpoint;

import com.robertsikora.rest.dto.PostDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by robertsikora on 24.03.2016.
 */

@RequestMapping("/posts")
public interface PostEndpoint {

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    PostDto findById(Long id);

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    void delete(Long id);
}
