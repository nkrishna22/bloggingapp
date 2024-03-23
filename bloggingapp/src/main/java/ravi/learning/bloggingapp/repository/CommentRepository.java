package ravi.learning.bloggingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ravi.learning.bloggingapp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
