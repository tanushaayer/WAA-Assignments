package edu.miu.lab5.Service.impl;

import edu.miu.lab5.Entity.Comment;
import edu.miu.lab5.Dto.CommentDto;
import edu.miu.lab5.Entity.Post;
import edu.miu.lab5.Repository.CommentRepo;
import edu.miu.lab5.Repository.PostRepo;
import edu.miu.lab5.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CommentDto> getComments() {
        return commentRepo.findAll()
                .stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long id) {
        Optional<Comment> comment =  commentRepo.findById(id);
        return comment
                .map(c -> modelMapper.map(c, CommentDto.class))
                .orElseThrow(() -> new RuntimeException("No Such Comment Id exists"));
    }

    @Override
    public void saveComment(Long postId, CommentDto commentDto) {
        Optional<Post> post = postRepo.findById(postId);
        if(post.isPresent()){
            Post p = post.get();
            Comment comment = new Comment();
            comment.setComment(commentDto.getComment());
            List<Comment> comments = p.getComments();
            comments.add(comment);
            p.setComments(comments);
            postRepo.save(p);
        }
    }
}
