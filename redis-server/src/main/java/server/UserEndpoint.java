package server;

import dto.PostDto;
import dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RequestMapping("/users")
public interface UserEndpoint {

    @RequestMapping(method = RequestMethod.POST)
    Long create(UserDto user);

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    UserDto findById(Long id);

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    void delete(Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/posts")
    void addPost(Long userId, PostDto post);

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/posts")
    List<PostDto> findAllPosts(Long userId);
}
