package edu.miu.lab4.Controller;

import edu.miu.lab4.Dto.PostDto;
import edu.miu.lab4.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    private List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    private void addPost(@RequestBody PostDto postDto){
        postService.savePost(postDto);
    }

    @PutMapping("/{postId}")
    private void updatePost(@PathVariable long postId, @RequestBody PostDto postDto){
        postService.updatePost(postId, postDto);
    }

    @DeleteMapping("/{postId}")
    private void deletePost(@PathVariable long postId){
        postService.deletePost(postId);
    }

    @GetMapping("/{id}")
    private PostDto getPostById(@PathVariable long id){
        return postService.getPostById(id);
    }

    @GetMapping("/filter")
    private List<PostDto> getPostsByAuthorName(@RequestParam(name = "authorName") String authorName){
        return postService.getPostByAuthor(authorName);
    }

    @GetMapping("/search")
    private List<PostDto> getPostsByAuthor(@RequestParam(name = "authorName") String authorName){
        return postService.searchPostByAuthor(authorName);
    }

    @GetMapping("/searchTitle")
    private List<PostDto> getPostsMatchByTitle(@RequestParam(name = "title") String title){
        return postService.searchPostMatchByTitle(title);
    }
}
