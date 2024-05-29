package edu.miu.lab1.Service;

import edu.miu.lab1.Dto.PostDto;
import edu.miu.lab1.Entity.Post;
import edu.miu.lab1.Repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepo.findById(id);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void savePost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepo.save(post);
    }

    @Override
    public void deletePost(long id) {
        if(getPostById(id) != null){
            postRepo.delete(id);
        }
    }

    @Override
    public void updatePost(long id, PostDto postDto) {
        if(getPostById(id) != null){
            Post post = modelMapper.map(postDto, Post.class);
            postRepo.update(id, post);
        }
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepo.findAll().stream()
                .map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByAuthor(String author) {
        List<Post> posts =  postRepo.findByAuthor(author);
        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> searchPostByAuthor(String author) {
        return postRepo.SearchByAuthor(author).stream()
                .map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }
}
