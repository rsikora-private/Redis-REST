package service.impl;

import model.Post;
import service.PostService;

import java.util.Date;

/**
 * Created by robertsikora on 18.03.2016.
 */
class PostServiceImpl extends CommonServiceImpl<Post> implements PostService {

    @Override
    public Post create(final Post post) {
        post.setEnterDate(new Date());
        return super.create(post);
    }
}
