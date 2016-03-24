package com.robertsikora.rest.endpoint.impl;

import com.robertsikora.rest.controller.UserController;
import com.robertsikora.rest.dto.PostDto;
import com.robertsikora.rest.endpoint.UserEndpoint;
import com.robertsikora.rest.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RestController
public class UserEndpointImpl implements UserEndpoint {

    @Autowired
    private UserController userController;

    @Override
    public Long create(@RequestBody final UserDto dto) {
        Assert.notNull(dto);
        return userController.create(dto);
    }

    @Override
    public Long addPost(@PathVariable(value = "userId") final Long userId, final PostDto post) {
        return userController.addPost(userId, post);
    }

    @Override
    public UserDto findById(@PathVariable(value = "id") final Long id) {
        return userController.findById(id);
    }

    @Override
    public void delete(@PathVariable(value = "id") final Long id) {
        userController.delete(id);
    }
}
