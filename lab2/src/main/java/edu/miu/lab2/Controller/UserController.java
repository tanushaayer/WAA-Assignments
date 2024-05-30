package edu.miu.lab2.Controller;

import edu.miu.lab2.Dto.PostDto;
import edu.miu.lab2.Dto.UserDto;
import edu.miu.lab2.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUser(){
        return userService.findAll();
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUserId(@PathVariable long id){
        return userService.findPostsByUserId(id);
    }

    @PutMapping({"/{userId}"})
    public void updateUser(@PathVariable long userId, @RequestBody UserDto userDto){
        userService.update(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId){
        userService.delete(userId);
    }

    @GetMapping("/filter")
    public List<UserDto> filterUserBasedOnNumberOfPosts(){
        return userService.findUserByNumberOfpostsGreaterThanOne();
    }
}
