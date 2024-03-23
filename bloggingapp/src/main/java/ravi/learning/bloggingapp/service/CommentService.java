package ravi.learning.bloggingapp.service;

import ravi.learning.bloggingapp.dto.CommentDto;
import ravi.learning.bloggingapp.model.Comment;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);
}
