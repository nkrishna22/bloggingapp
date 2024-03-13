package ravi.learning.bloggingapp.service;

import ravi.learning.bloggingapp.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(Long id);
}
