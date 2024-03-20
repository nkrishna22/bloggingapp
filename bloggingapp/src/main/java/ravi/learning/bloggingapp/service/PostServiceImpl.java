package ravi.learning.bloggingapp.service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ravi.learning.bloggingapp.dto.PostDto;
import ravi.learning.bloggingapp.dto.PostResponse;
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

    //adding pagination support
    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        List<Post> allPosts = postRepository.findAll();

        Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);
        List<Post> listOfPosts = posts.getContent();
        List<PostDto> postDtos = listOfPosts.stream().map((x) -> postMapper.convertToPostDto(x)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post getPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post", "id", id));
        return postMapper.convertToPostDto(getPost);
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);

        return postMapper.convertToPostDto(updatedPost);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post", "id", id));
        postRepository.delete(post);
    }
}
