package com.robertsikora.rest.controller.impl;

import com.robertsikora.core.model.User;
import com.robertsikora.rest.controller.UserController;
import com.robertsikora.rest.dto.PostDto;
import com.robertsikora.rest.dto.UserDto;

/**
 * Created by robertsikora on 24.03.2016.
 */
public class UserControllerImpl extends BasicControllerImpl<User, UserDto, Long> implements UserController {

    @Override
    public Long addPost(final Long userId, final PostDto post) {
        final User user = commonService.findById(userId);

        return null;
    }
}
