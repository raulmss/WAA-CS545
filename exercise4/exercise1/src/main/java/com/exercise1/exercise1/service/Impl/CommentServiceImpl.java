package com.exercise1.exercise1.service.Impl;

import com.exercise1.exercise1.entity.Comment;
import com.exercise1.exercise1.entity.Post;
import com.exercise1.exercise1.entity.dto.CommentDTO;
import com.exercise1.exercise1.repo.CommentRepo;
import com.exercise1.exercise1.repo.PostRepo;
import com.exercise1.exercise1.service.CommentService;
import com.exercise1.exercise1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public CommentDTO createComment(String name, long postId) {
        Comment comment = new Comment();
        comment.setName(name);

        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.addComment(comment);
        postRepo.save(post);
        return new CommentDTO(comment.getId(), comment.getName());
    }

    @Override
    public void deleteComment(long id) {
    commentRepo.deleteById(id);
    }

    @Override
    public CommentDTO updateComment(long id, String name) {
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setName(name);
        commentRepo.save(comment);

        return new CommentDTO(comment.getId(), comment.getName());

    }

    @Override
    public CommentDTO getComment(long id) {
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        return new CommentDTO(comment.getId(), comment.getName());
    }

    @Override
    public List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepo.findAll();
        return comments
                .stream()
                .map(comment -> new CommentDTO(comment.getId(), comment.getName()))
                .collect(Collectors.toList());
    }
}
