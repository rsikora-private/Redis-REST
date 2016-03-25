package controller;

import dto.PostDto;
import dto.UserDto;

/**
 * Created by robertsikora on 24.03.2016.
 */
public interface UserController extends BasicController<UserDto> {

    long addPost(long userId, PostDto post);
}
