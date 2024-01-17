package com.exercise1.exercise1.controller;

import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable long id) {
        PostDTO post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(@RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "subStringAuthor", required = false) String subStringAuthor) {
        List<PostDTO> posts = postService.getAll();

        return ResponseEntity.ok(posts.stream()
                .filter(post -> !(StringUtils.isEmpty(author)) ? post.getAuthor().toLowerCase().equals(author.toLowerCase()) : true)
                .filter(post -> !(StringUtils.isEmpty(subStringAuthor)) ? post.getAuthor().toLowerCase().contains(subStringAuthor.toLowerCase()) : true)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO postDTO) {
        PostDTO post = postService.createNewPost(postDTO);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable long id, @RequestBody PostDTO postDTO) {
        PostDTO post = postService.updatePost(id, postDTO);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable long id) {
        boolean deleted = postService.deletePostById(id);
        if (deleted) {
            return ResponseEntity.ok("Post with ID: " + id + " has been deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
