package edu.miu.lab4.Service;

import edu.miu.lab4.Dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments();
    CommentDto getCommentById(long id);
    void saveComment(Long postId, CommentDto commentDto);

}
