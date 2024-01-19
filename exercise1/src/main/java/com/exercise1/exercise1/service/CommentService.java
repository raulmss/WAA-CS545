package com.exercise1.exercise1.service;

import com.exercise1.exercise1.entity.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    public CommentDTO createComment(String name, long postId);
    public void deleteComment(long id);
    public CommentDTO updateComment(long id, String name);
    public CommentDTO getComment(long id);
    public List<CommentDTO> getAllComments();
}
