package ravi.learning.bloggingapp.service;


import ravi.learning.bloggingapp.dto.CommentDto;
import ravi.learning.bloggingapp.exception.ResourceNotFound;
import ravi.learning.bloggingapp.mapper.CommentMapper;
import ravi.learning.bloggingapp.model.Comment;
import ravi.learning.bloggingapp.model.Post;
import ravi.learning.bloggingapp.repository.CommentRepository;
import ravi.learning.bloggingapp.repository.PostRepository;

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

}
