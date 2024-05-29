package edu.miu.lab1.Repository;

import edu.miu.lab1.Entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    List<Post> posts = new ArrayList<Post>();

    @Override
    public void save(Post post) {
        posts.add(post);
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public void delete(long id) {
            Post post = findById(id);
            posts.remove(post);
    }

    @Override
    public void update(long id, Post post) {
            posts.stream()
                    .filter(p -> p.getId() == id)
                    .forEach(p -> {
                        p.setTitle(post.getTitle());
                        p.setContent(post.getContent());
                        p.setAuthor(post.getAuthor());
                    });
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts.stream().filter(post -> post.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Post> SearchByAuthor(String author) {
        return posts.stream().filter(post -> post.getAuthor().contains(author)).collect(Collectors.toList());
    }
}
