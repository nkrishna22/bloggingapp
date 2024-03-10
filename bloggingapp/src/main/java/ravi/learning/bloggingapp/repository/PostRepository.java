package ravi.learning.bloggingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ravi.learning.bloggingapp.model.Posts;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
