package edu.miu.lab3.Service;

import edu.miu.lab3.Dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments();
    CommentDto getCommentById(long id);
    void saveComment(Long postId, CommentDto commentDto);

}
