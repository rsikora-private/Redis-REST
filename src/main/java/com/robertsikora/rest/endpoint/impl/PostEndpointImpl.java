package com.robertsikora.rest.endpoint.impl;

import com.robertsikora.core.model.Post;
import com.robertsikora.core.model.User;
import com.robertsikora.rest.controller.PostController;
import com.robertsikora.rest.controller.impl.BasicControllerImpl;
import com.robertsikora.rest.dto.PostDto;
import com.robertsikora.rest.dto.UserDto;
import com.robertsikora.rest.endpoint.PostEndpoint;
import com.robertsikora.rest.endpoint.UserEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RestController
public class PostEndpointImpl implements PostEndpoint {

    @Autowired
    private PostController postController;

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }
}
