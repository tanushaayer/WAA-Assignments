package edu.miu.lab5.Dto;

import edu.miu.lab5.Entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long id;
    private String username;
    private String password;
    private List<PostDto> posts;
    private List<Role> roles;
}
