package com.robertsikora.core.service.impl;

import com.robertsikora.core.model.Post;
import com.robertsikora.core.service.PostService;
import java.util.Date;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class PostServiceImpl extends CommonServiceImpl<Post, Long> implements PostService {

    @Override
    public Post create(final Post post) {
        post.setEnterDate(new Date());
        return super.create(post);
    }
}
