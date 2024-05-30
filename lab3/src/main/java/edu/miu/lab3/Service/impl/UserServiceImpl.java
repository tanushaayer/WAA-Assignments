package edu.miu.lab3.Service.impl;

import edu.miu.lab3.Dto.CommentDto;
import edu.miu.lab3.Dto.PostDto;
import edu.miu.lab3.Dto.UserDto;
import edu.miu.lab3.Entity.Comment;
import edu.miu.lab3.Entity.Post;
import edu.miu.lab3.Entity.User;
import edu.miu.lab3.Repository.UserRepo;
import edu.miu.lab3.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);
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

    @Override
    public List<UserDto> findUserByPostsIsGreaterThan(int numberOfPosts) {
        return userRepo.findUserByPostsIsGreaterThan(numberOfPosts)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUserByPostsTitleContainingIgnoreCase(String title) {
        return userRepo.findUserByPostsTitleContainingIgnoreCase(title)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto findCommentByIds(long userId, long postId, long commentId) {
       User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Id Not Found" + userId));
       List<Post> posts = user.getPosts();

        return posts.stream()
               .filter(post -> post.getId() == postId)
               .map(Post::getComments)
                .flatMap(Collection::stream)
                .filter(comment -> comment.getId() == commentId)
                .map(comment -> modelMapper.map(comment,CommentDto.class))
                .findAny().orElseThrow(() -> new RuntimeException("Comment Id Not Found" + commentId));

    }
}
