package edu.miu.lab3.Dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long id;
    private String name;
    private List<PostDto> posts;
}
