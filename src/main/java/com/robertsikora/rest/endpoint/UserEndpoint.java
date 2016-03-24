package com.robertsikora.rest.endpoint;

import com.robertsikora.rest.dto.PostDto;
import com.robertsikora.rest.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RequestMapping("/users")
public interface UserEndpoint {

    @RequestMapping(method = RequestMethod.POST)
    Long create(UserDto user);

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/posts")
    Long addPost(Long userId, PostDto post);

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    UserDto findById(Long id);

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    void delete(Long id);
}
