package ravi.learning.bloggingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ravi.learning.bloggingapp.dto.CommentDto;
import ravi.learning.bloggingapp.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "id") Long postId, @RequestBody CommentDto commentDto) {
        CommentDto commentDto1 = commentService.createComment(postId, commentDto);
        return new ResponseEntity<>(commentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/post/{id}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPost(@PathVariable(value = "id") Long postId) {
        List<CommentDto> allComments = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,@PathVariable(value = "id") Long commentId,@RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }
}
