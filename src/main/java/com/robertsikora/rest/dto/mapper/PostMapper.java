package com.robertsikora.rest.dto.mapper;

import com.robertsikora.core.model.Post;
import com.robertsikora.rest.dto.PostDto;
import org.springframework.stereotype.Controller;

/**
 * Created by robertsikora on 18.03.2016.
 */

@Controller
public class PostMapper implements Mapper <Post, PostDto> {

    @Override
    public PostDto fromEntity(Post post) {
        return null;
    }

    @Override
    public Post fromDTO(PostDto postDto) {
        return null;
    }
}
