package com.robertsikora.rest.controller;

import com.robertsikora.rest.dto.PostDto;
import com.robertsikora.rest.dto.UserDto;

/**
 * Created by robertsikora on 24.03.2016.
 */
public interface UserController extends BasicController<UserDto> {

    long addPost(long userId, PostDto post);
}
