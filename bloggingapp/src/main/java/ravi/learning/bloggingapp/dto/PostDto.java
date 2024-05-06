package ravi.learning.bloggingapp.dto;

import lombok.Data;
import ravi.learning.bloggingapp.model.Comment;

import java.util.Set;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;
}
