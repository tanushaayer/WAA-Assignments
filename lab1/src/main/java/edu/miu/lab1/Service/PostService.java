package edu.miu.lab1.Service;

import edu.miu.lab1.Dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto getPostById(long id);
    void savePost(PostDto postDto);
    void deletePost(long id);
    void updatePost(long id, PostDto postDto);
    List<PostDto> getAllPosts();
    List<PostDto> getPostByAuthor(String author);
    List<PostDto> searchPostByAuthor(String author);
}
