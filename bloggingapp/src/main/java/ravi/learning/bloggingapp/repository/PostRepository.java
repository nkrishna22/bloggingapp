package ravi.learning.bloggingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ravi.learning.bloggingapp.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
