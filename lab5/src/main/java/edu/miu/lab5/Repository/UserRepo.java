package edu.miu.lab5.Repository;

import edu.miu.lab5.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE size(u.posts) > 1")
    List<User> findUserByPostsIsGreaterThanOne();

    @Query("select u from User u where size(u.posts) > :postNum")
    List<User> findUserByPostsIsGreaterThan(@Param("postNum") int postNum);

    @Query("select u from User u JOIN u.posts p where p.title = :title")
    List<User> findUserByPostsTitleContainingIgnoreCase(@Param("title") String title);

    User findByEmail(String email);
    
}
