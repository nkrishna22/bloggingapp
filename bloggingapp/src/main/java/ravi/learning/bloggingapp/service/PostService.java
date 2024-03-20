package ravi.learning.bloggingapp.service;

import ravi.learning.bloggingapp.dto.PostDto;
import ravi.learning.bloggingapp.dto.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int PageSize, String sortBy, String sortDir);
    PostDto getPostById(Long id);
    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);
}
