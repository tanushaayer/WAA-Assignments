package edu.miu.lab2.Repository;

import edu.miu.lab2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE size(u.posts) > 1")
    List<User> findUserByPostsIsGreaterThanOne();
}
