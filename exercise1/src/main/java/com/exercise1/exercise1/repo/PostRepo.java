package com.exercise1.exercise1.repo;

import com.exercise1.exercise1.entity.Post;
import com.exercise1.exercise1.entity.dto.PostDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo {
    Post findById(long id);
    List<PostDTO> findAll();
    Post createPost(String title, String content, String author);
    PostDTO updatePost(long id, PostDTO postDTO);
    boolean deletePost(long id);

}
