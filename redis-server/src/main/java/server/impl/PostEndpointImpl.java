package server.impl;

import controller.PostController;
import dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.PostEndpoint;

import java.util.Map;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RestController
public class PostEndpointImpl implements PostEndpoint {

    @Autowired
    private PostController postController;

    @Override
    public Long create(@RequestBody final PostDto post) {
        Assert.notNull(post);
        return postController.create(post);
    }

    @Override
    public PostDto findById(@PathVariable(value = "id") final Long id) {
        return postController.findById(id);
    }

    @Override
    public Map<Object, Object> findAll() {
        return postController.findAll();
    }

    @Override
    public void delete(@PathVariable(value = "id") final Long id) {
        postController.delete(id);
    }
}
