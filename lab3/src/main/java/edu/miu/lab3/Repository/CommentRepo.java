package edu.miu.lab3.Repository;

import edu.miu.lab3.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
}
