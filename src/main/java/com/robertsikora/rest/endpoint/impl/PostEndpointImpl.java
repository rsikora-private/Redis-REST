package com.robertsikora.rest.endpoint.impl;

import com.robertsikora.rest.controller.PostController;
import com.robertsikora.rest.dto.PostDto;
import com.robertsikora.rest.endpoint.PostEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RestController
public class PostEndpointImpl implements PostEndpoint {

    @Autowired
    private PostController postController;

    @Override
    public PostDto findById(@PathVariable(value = "id") final Long id) {
        return postController.findById(id);
    }

    @Override
    public void delete(@PathVariable(value = "id") final Long id) {
        postController.delete(id);
    }
}
