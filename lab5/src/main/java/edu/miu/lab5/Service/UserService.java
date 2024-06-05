package edu.miu.lab5.Service;

import edu.miu.lab5.Dto.CommentDto;
import edu.miu.lab5.Dto.PostDto;
import edu.miu.lab5.Dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);
    UserDto findById(long id);
    List<UserDto> findAll();
    void delete(long id);
    void update(long id, UserDto userDto);
    List<PostDto> findPostsByUserId(long userId);
    List<UserDto> findUserByNumberOfpostsGreaterThanOne();
    List<UserDto> findUserByPostsIsGreaterThan(int numberOfPosts);
    List<UserDto> findUserByPostsTitleContainingIgnoreCase(String title);
    CommentDto findCommentByIds(long userId, long postId, long commentId);
}
