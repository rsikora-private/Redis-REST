package controller;

import dto.PostDto;
import dto.UserDto;

import java.util.List;

/**
 * Created by robertsikora on 24.03.2016.
 */
public interface UserController extends BasicController<UserDto> {

    PostDto addPost(long userId, PostDto post);

    List<PostDto> findAllPosts(long userId);
}
