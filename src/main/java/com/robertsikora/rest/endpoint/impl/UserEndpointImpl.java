package com.robertsikora.rest.endpoint.impl;

import com.robertsikora.core.model.User;
import com.robertsikora.rest.endpoint.UserEndpoint;
import com.robertsikora.rest.controller.impl.BasicControllerImpl;
import com.robertsikora.rest.dto.UserDto;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RestController
public class UserEndpointImpl implements UserEndpoint {

    @Resource(name = "userController")
    private BasicControllerImpl<User, UserDto, Long> userController;

    @Override
    public long create(@RequestBody final UserDto dto) {
        Assert.notNull(dto);
        return userController.create(dto);
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
