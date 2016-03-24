package com.robertsikora.core.repo.impl;

import com.robertsikora.core.model.Post;
import com.robertsikora.core.repo.RedisRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by robertsikora on 21.03.2016.
 */

@Repository
public class PostRepo extends RedisRepo<Post, Long> {

}
