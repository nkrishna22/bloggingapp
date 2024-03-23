package ravi.learning.bloggingapp.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String name;
    private String email;
    private String body;
    private PostDto postDto;
}
