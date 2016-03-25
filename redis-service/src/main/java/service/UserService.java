package service;

import model.Post;
import model.User;

import java.util.List;

/**
 * Created by robertsikora on 18.03.2016.
 */
public interface UserService extends CommonService<User> {

    void addPost(long userId, Post post);

    List<Post> findPostForUserId(long userId);
}
