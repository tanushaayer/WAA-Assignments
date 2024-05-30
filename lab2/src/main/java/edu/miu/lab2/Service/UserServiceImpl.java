package edu.miu.lab2.Service;

import edu.miu.lab2.Dto.PostDto;
import edu.miu.lab2.Dto.UserDto;
import edu.miu.lab2.Entity.Post;
import edu.miu.lab2.Entity.User;
import edu.miu.lab2.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }

    @Override
    public UserDto findById(long id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return modelMapper.map(user.get(), UserDto.class);
        }else{
            return null;
        }
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(long id, UserDto userDto) {
        if(userRepo.existsById(id)){
            User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User Id Not Found" + id));
            user.setName(userDto.getName());
        }
    }

    @Override
    public List<PostDto> findPostsByUserId(long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Id Not Found" + userId));
        return user.getPosts().stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUserByNumberOfpostsGreaterThanOne() {
        return userRepo.findUserByPostsIsGreaterThanOne().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }
}
