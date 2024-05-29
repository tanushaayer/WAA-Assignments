package edu.miu.lab1.Repository;

import edu.miu.lab1.Entity.Post;

import java.util.List;


public interface PostRepo {
    void save(Post post);
    Post findById(long id);
    List<Post> findAll();
    void delete(long id);
    void update(long id, Post post);
    List<Post> findByAuthor(String author);
    List<Post> SearchByAuthor(String author);
}
