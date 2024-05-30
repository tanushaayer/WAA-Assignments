package edu.miu.lab3.Service.impl;

import edu.miu.lab3.Dto.PostDto;
import edu.miu.lab3.Entity.Post;
import edu.miu.lab3.Repository.PostRepo;
import edu.miu.lab3.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    @Override
    public List<PostDto> searchPostMatchByTitle(String title) {
        return postRepo.findPostByTitleContaining(title)
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    private final ModelMapper modelMapper;

    @Override
    public PostDto getPostById(long id) {
        Optional<Post> post = postRepo.findById(id);
        if(post.isPresent()) {
            return modelMapper.map(post, PostDto.class);
        }else{
            return null;
        }
    }

    @Override
    public void savePost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepo.save(post);
    }

    @Override
    public void deletePost(long id) {
        if (postRepo.existsById(id)) {
            postRepo.deleteById(id);
        }else{
            throw new RuntimeException("Post not found");
        }
    }

    @Override
    public void updatePost(long id, PostDto postDto) {
        if (postRepo.existsById(id)) {
            Optional<Post> postOpt = postRepo.findById(id);
            if(postOpt.isPresent()){
                Post post = postOpt.get();
                post.setTitle(postDto.getPostTitle());
                post.setContent(postDto.getPostContent());
                post.setAuthor(postDto.getPostAuthor());
                postRepo.save(post);
            }
        }
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepo.findAll().stream()
                .map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByAuthor(String author) {
        List<Post> posts =  postRepo.findAllByAuthor(author);
        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> searchPostByAuthor(String author) {
        return postRepo.findAllByAuthorContainsIgnoreCase(author).stream()
                .map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }
}
