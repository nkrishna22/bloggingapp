package ravi.learning.bloggingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ravi.learning.bloggingapp.dto.PostDto;
import ravi.learning.bloggingapp.dto.PostResponse;
import ravi.learning.bloggingapp.service.PostService;
import ravi.learning.bloggingapp.utils.AppConstants;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postDto1 = postService.createPost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }

    // create Get API to get all Posts
    @GetMapping("")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                                    @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
                                                     ) {
        PostResponse allPostDtos = postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);

        return ResponseEntity.ok(allPostDtos);
    }

    // Create Get Post by ID API
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long postId) {
        PostDto getPostDto = postService.getPostById(postId);
        return ResponseEntity.ok(getPostDto);
    }

    // create Update Post by ID API
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") Long postId, @RequestBody PostDto postDto) {
        PostDto updatedPostDto = postService.updatePost(postId, postDto);
        return ResponseEntity.ok(updatedPostDto);
    }

    // Create Delete Post API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>("Post with id: " + postId + " deleted successfully!", HttpStatus.OK);
    }
}
