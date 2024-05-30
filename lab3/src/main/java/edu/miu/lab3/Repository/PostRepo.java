package edu.miu.lab3.Repository;

import edu.miu.lab3.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthor(String author);
    List<Post> findAllByAuthorContainsIgnoreCase(String author);
    List<Post> findPostByTitleContaining(String title);
}
