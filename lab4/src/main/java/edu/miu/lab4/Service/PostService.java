package edu.miu.lab4.Service;

import edu.miu.lab4.Dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto getPostById(long id);
    void savePost(PostDto postDto);
    void deletePost(long id);
    void updatePost(long id, PostDto postDto);
    List<PostDto> getAllPosts();
    List<PostDto> getPostByAuthor(String author);
    List<PostDto> searchPostByAuthor(String author);
    List<PostDto> searchPostMatchByTitle(String title);
}
