package com.exercise1.exercise1.service.Impl;

import com.exercise1.exercise1.entity.Post;
import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.repo.PostRepo;
import com.exercise1.exercise1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public PostDTO getPostById(long id) {

       Post post = postRepo.findById(id);
         if(post != null){
              return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
         }else{
            System.out.println("Post not found");
            return null;
         }

    }

    @Override
    public List<PostDTO> getAll() {
        return postRepo.findAll();
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {

        Post post = postRepo.createPost(postDTO.getTitle(), postDTO.getContent(), postDTO.getAuthor());
        return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    @Override
    public PostDTO updatePost(long id, PostDTO postDTO) {
        return postRepo.updatePost(id, postDTO);
    }

    @Override
    public boolean deletePostById(long id) {
        return postRepo.deletePost(id);
    }
}
