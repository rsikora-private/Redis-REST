package controller.impl;

import controller.UserController;
import dto.PostDto;
import dto.UserDto;
import dto.mapper.PostMapper;
import model.User;
import org.springframework.beans.factory.annotation.Required;
import service.UserService;

import java.util.List;

/**
 * Created by robertsikora on 24.03.2016.
 */
class UserControllerImpl extends BasicControllerImpl<User, UserDto> implements UserController {

    private PostMapper postMapper;

    @Override
    public PostDto addPost(final long userId, final PostDto post) {
        return postMapper.fromEntity(getService().addPost(userId, postMapper.fromDTO(post)));
    }

    @Override
    public List<PostDto> findAllPosts(final long userId) {
        return postMapper.fromEntries(getService().findPostForUserId(userId));
    }

    private UserService getService() {
        return (UserService) commonService;
    }

    @Required
    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }
}
