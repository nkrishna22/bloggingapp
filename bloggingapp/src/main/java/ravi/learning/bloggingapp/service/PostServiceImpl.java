package ravi.learning.bloggingapp.service;

import org.springframework.stereotype.Service;
import ravi.learning.bloggingapp.dto.PostDto;
import ravi.learning.bloggingapp.mapper.PostMapper;
import ravi.learning.bloggingapp.model.Post;
import ravi.learning.bloggingapp.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;
    private PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.convertToPost(postDto);
        Post savedPost = postRepository.save(post);
        return postMapper.convertToPostDto(savedPost);
    }
}
