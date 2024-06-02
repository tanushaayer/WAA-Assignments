package edu.miu.lab4.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private long postId;
    private String postTitle;
    private String postContent;
    private String postAuthor;
    private List<CommentDto> comments;
}
