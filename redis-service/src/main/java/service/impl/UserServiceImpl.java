package service.impl;

import model.Post;
import model.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import repo.impl.UserPostsRelation;
import service.PostService;
import service.UserService;
import service.exception.RedisServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsikora on 18.03.2016.
 */

class UserServiceImpl extends CommonServiceImpl<User> implements UserService {

    private PostService postService;
    private UserPostsRelation userPostsRelation;

    @Override
    public Post addPost(final long userId, final Post post) {
        final Post dbPost = postService.create(post);
        try {
            userPostsRelation.create(userId, dbPost.getId());
        } catch (DataAccessException e) {
            throw new RedisServiceException(e);
        }
        return dbPost;
    }

    @Override
    public List<Post> findPostForUserId(long userId) {
        final List<Long> ids;
        try {
            ids = userPostsRelation.findAllByParentId(userId);
        } catch (DataAccessException e) {
            throw new RedisServiceException(e);
        }
        final List<Post> result = new ArrayList<>();
        ids.forEach(id -> result.add(postService.findById(id)));
        return result;
    }

    @Required
    public void setPostService(final PostService postService) {
        this.postService = postService;
    }

    @Required
    public void setUserPostsRelation(final UserPostsRelation userPostsRelation) {
        this.userPostsRelation = userPostsRelation;
    }
}
