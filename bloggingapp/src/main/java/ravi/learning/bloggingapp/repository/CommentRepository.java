package ravi.learning.bloggingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ravi.learning.bloggingapp.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);

}
