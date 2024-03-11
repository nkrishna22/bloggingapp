package ravi.learning.bloggingapp.service;

import ravi.learning.bloggingapp.dto.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
