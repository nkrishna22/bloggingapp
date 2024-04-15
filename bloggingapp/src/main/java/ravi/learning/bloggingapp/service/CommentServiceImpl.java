package ravi.learning.bloggingapp.service;


import org.springframework.http.HttpStatus;
import ravi.learning.bloggingapp.dto.CommentDto;
import ravi.learning.bloggingapp.exception.BlogAPIException;
import ravi.learning.bloggingapp.exception.ResourceNotFound;
import ravi.learning.bloggingapp.mapper.CommentMapper;
import ravi.learning.bloggingapp.model.Comment;
import ravi.learning.bloggingapp.model.Post;
import ravi.learning.bloggingapp.repository.CommentRepository;
import ravi.learning.bloggingapp.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, CommentMapper commentMapper) {

        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.commentMapper = commentMapper;
    }
    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", "id", postId));
        Comment comment = commentMapper.covertToComment(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.convertToDto(savedComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map((comment) -> commentMapper.convertToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFound("Comment", "id", commentId));

        if(comment.getPost().getId()!=post.getId()) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return commentMapper.convertToDto(comment);
    }

}
