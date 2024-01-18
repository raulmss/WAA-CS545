package com.exercise1.exercise1.service.Impl;

import com.exercise1.exercise1.entity.Post;
import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.repo.PostRepo;
import com.exercise1.exercise1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public PostDTO getPostById(long id) {

        Post post = postRepo.findById(id).orElseThrow(()->
                new RuntimeException("Post not found with id: " + id + "."));

              return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());

    }

    @Override
    public List<PostDTO> getAll() {
        return postRepo.findAll().stream()
                .map(post -> new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {

        Post post = new Post(postDTO.getTitle(), postDTO.getContent(), postDTO.getAuthor());
        postRepo.save(post);
        return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    @Override
    public PostDTO updatePost(long id, PostDTO postDTO) {
        Post post = postRepo.findById(id).orElseThrow(()->
                new RuntimeException("Post not found with id: " + id + "."));

            if(postDTO.getTitle() != null)
            post.setTitle(postDTO.getTitle());
            if(postDTO.getContent() != null)
            post.setContent(postDTO.getContent());
            if(postDTO.getAuthor() != null)
            post.setAuthor(postDTO.getAuthor());

            postRepo.save(post);

        return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    @Override
    public boolean deletePostById(long id) {
        Post post = postRepo.findById(id).get();
        if(post == null){
            System.out.println("Post not found");
            return false;
        }
        postRepo.delete(post);

        return true;
    }
}
