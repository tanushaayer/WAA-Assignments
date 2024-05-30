package edu.miu.lab3.Controller;

import edu.miu.lab3.Dto.CommentDto;
import edu.miu.lab3.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/post/{postId}")
    public void postComment(@PathVariable long postId, @RequestBody CommentDto commentDto){
        commentService.saveComment(postId, commentDto);
    }

    @GetMapping
    public List<CommentDto> getComments(){
        return commentService.getComments();
    }

    @GetMapping("/{commentId}")
    public CommentDto getComment(@PathVariable long commentId){
        return commentService.getCommentById(commentId);
    }
}
