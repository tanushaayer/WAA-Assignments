package edu.miu.lab2.Service;

import edu.miu.lab2.Dto.PostDto;
import edu.miu.lab2.Dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);
    UserDto findById(long id);
    List<UserDto> findAll();
    void delete(long id);
    void update(long id, UserDto userDto);
    List<PostDto> findPostsByUserId(long userId);
    List<UserDto> findUserByNumberOfpostsGreaterThanOne();
}
