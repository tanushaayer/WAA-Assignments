package edu.miu.lab5.Service;

import edu.miu.lab5.Dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments();
    CommentDto getCommentById(long id);
    void saveComment(Long postId, CommentDto commentDto);

}
