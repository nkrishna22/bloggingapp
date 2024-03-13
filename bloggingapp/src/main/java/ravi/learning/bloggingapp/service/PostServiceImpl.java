package ravi.learning.bloggingapp.service;

import org.springframework.stereotype.Service;
import ravi.learning.bloggingapp.dto.PostDto;
import ravi.learning.bloggingapp.exception.ResourceNotFound;
import ravi.learning.bloggingapp.mapper.PostMapper;
import ravi.learning.bloggingapp.model.Post;
import ravi.learning.bloggingapp.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();

        List<PostDto> postDtos = allPosts.stream().map((x) -> postMapper.convertToPostDto(x)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post getPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post", "id", id));
        return postMapper.convertToPostDto(getPost);
    }
}
