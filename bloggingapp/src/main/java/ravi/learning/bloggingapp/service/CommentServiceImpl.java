package ravi.learning.bloggingapp.service;


import ravi.learning.bloggingapp.dto.CommentDto;
import ravi.learning.bloggingapp.repository.CommentRepository;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository
    }
    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        return null;
    }

}
