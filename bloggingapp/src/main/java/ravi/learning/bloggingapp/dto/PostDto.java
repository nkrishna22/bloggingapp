package ravi.learning.bloggingapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ravi.learning.bloggingapp.model.Comment;

import java.util.Set;

@Data
public class PostDto {
    private Long id;

//    title should not be empty or null
//    title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

//    Post description should not be empty or null
//    Post description should at least have 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 chracters")
    private String description;
    private String content;
    private Set<CommentDto> comments;
}
