package ravi.learning.bloggingapp.mapper;

import ravi.learning.bloggingapp.dto.CommentDto;
import ravi.learning.bloggingapp.model.Comment;

public class CommentMapper {
    public CommentDto toCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setEmail(comment.getEmail());
        commentDto.setName(comment.getName());
        return commentDto;
    }

    public Comment toComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(comment.getBody());
        return comment;
    }
}
