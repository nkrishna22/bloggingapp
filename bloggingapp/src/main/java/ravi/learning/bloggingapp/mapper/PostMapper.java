package ravi.learning.bloggingapp.mapper;

import org.springframework.stereotype.Component;
import ravi.learning.bloggingapp.dto.PostDto;
import ravi.learning.bloggingapp.model.Post;

@Component
public class PostMapper {

    public PostDto convertToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    public Post convertToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
