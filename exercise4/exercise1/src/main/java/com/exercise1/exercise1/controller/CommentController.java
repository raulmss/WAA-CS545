package com.exercise1.exercise1.controller;

import com.exercise1.exercise1.entity.Comment;
import com.exercise1.exercise1.entity.Post;
import com.exercise1.exercise1.entity.dto.CommentDTO;
import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.service.CommentService;
import com.exercise1.exercise1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable long id) {
        try{
            CommentDTO commentDTO = commentService.getComment(id);
            return ResponseEntity.ok(commentDTO);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id) {
        try{
            commentService.deleteComment(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        try{
            List<CommentDTO> commentsDTO = commentService.getAllComments();
            return ResponseEntity.ok(commentsDTO);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO, @PathVariable long postId) {
        Comment comment = new Comment();
        comment.setName(commentDTO.getName());
        try{
            CommentDTO commentDT = commentService.createComment(commentDTO.getName(), postId);
            return ResponseEntity.ok(commentDT);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
