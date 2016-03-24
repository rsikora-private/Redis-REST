package com.robertsikora.rest.dto.mapper;

import com.robertsikora.core.model.Post;
import com.robertsikora.rest.dto.PostDto;
import org.springframework.stereotype.Component;

/**
 * Created by robertsikora on 18.03.2016.
 */

@Component
public class PostMapper implements Mapper <Post, PostDto> {

    @Override
    public PostDto fromEntity(final Post post) {
        final PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        post.setEnterDate(post.getEnterDate());
        return postDto;
    }

    @Override
    public Post fromDTO(final PostDto postDto) {
        final Post post = new Post();
        post.setId(postDto.getId());
        post.setDescription(postDto.getDescription());
        post.setEnterDate(postDto.getEnterDate());
        return post;
    }
}
