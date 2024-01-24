package com.exercise1.exercise1.service;

import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.entity.Post;

import java.util.List;

public interface PostService {
    PostDTO getPostById(long id);
    List<PostDTO> getPostByTitle(String title);
    List<PostDTO> getAll();
    PostDTO createNewPost(PostDTO postDTO);
    PostDTO updatePost(long id,PostDTO postDTO);
    boolean deletePostById(long id);
}
