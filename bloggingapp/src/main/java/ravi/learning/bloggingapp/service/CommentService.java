package ravi.learning.bloggingapp.service;

import ravi.learning.bloggingapp.dto.CommentDto;
import ravi.learning.bloggingapp.model.Comment;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(Long postId);
    CommentDto getCommentById(Long postId, Long commentId);

}
