package edu.miu.lab4.Service;

import edu.miu.lab4.Dto.CommentDto;
import edu.miu.lab4.Dto.PostDto;
import edu.miu.lab4.Dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    UserDto findUserById(long id);
    List<UserDto> findAllUsers();
    void deleteUser(long id);
    void updateUser(long id, UserDto userDto);
    List<PostDto> findPostsByUserId(long userId);
    List<UserDto> findUserByNumberOfpostsGreaterThanOne();
    List<UserDto> findUserByPostsIsGreaterThan(int numberOfPosts);
    List<UserDto> findUserByPostsTitleContainingIgnoreCase(String title);
    CommentDto findCommentByIds(long userId, long postId, long commentId);
}
