package service.impl;

import model.Post;
import model.User;
import org.springframework.beans.factory.annotation.Required;
import repo.exception.RepoException;
import repo.impl.UserPostsRelation;
import service.PostService;
import service.UserService;
import service.exception.NotFoundException;
import service.exception.RedisServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsikora on 18.03.2016.
 */

class UserServiceImpl extends CommonServiceImpl<User> implements UserService {

    private PostService         postService;
    private UserPostsRelation   userPostsRelation;

    @Override
    public void addPost(final long userId, final Post post) {
        final User user = findById(userId);
        if (user == null) {
            throw new NotFoundException("Cannot find user for id:" + userId);
        }
        final Post dbPost = postService.create(post);
        try {
            userPostsRelation.create(userId, dbPost.getId());
        } catch (RepoException e) {
            throw new RedisServiceException(e);
        }
    }

    @Override
    public List<Post> findPostForUserId(long userId) {
        final List<Long> ids;
        try {
            ids = userPostsRelation.findAllByParentId(userId);
        } catch (RepoException e) {
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
