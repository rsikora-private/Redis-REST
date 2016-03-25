package server.impl;

import controller.UserController;
import dto.PostDto;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.UserEndpoint;

import java.util.List;

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
    public UserDto findById(@PathVariable(value = "id") final Long id) {
        return userController.findById(id);
    }

    @Override
    public void delete(@PathVariable(value = "id") final Long id) {
        userController.delete(id);
    }

    @Override
    public void addPost(@PathVariable(value = "userId") final Long userId, @RequestBody final PostDto post) {
        userController.addPost(userId, post);
    }

    @Override
    public List<PostDto> findAllPosts(@PathVariable(value = "userId") final Long userId) {
        return userController.findAllPosts(userId);
    }
}
