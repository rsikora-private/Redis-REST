package dto.mapper;

import dto.PostDto;
import model.Post;

/**
 * Created by robertsikora on 18.03.2016.
 */

public class PostMapper implements Mapper<Post, PostDto> {

    @Override
    public PostDto fromEntity(final Post post) {
        final PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        postDto.setEnterDate(post.getEnterDate());
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
