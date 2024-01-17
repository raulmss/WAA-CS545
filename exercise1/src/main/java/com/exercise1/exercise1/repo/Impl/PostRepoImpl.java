package com.exercise1.exercise1.repo.Impl;

import com.exercise1.exercise1.entity.Post;
import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private List<Post> posts = new ArrayList<>();
    private long idCounter = 1;

    public PostRepoImpl() {
        posts.add(new Post(idCounter++,"Blizzard", "Cold Iowa", "God"));
        posts.add(new Post(idCounter++,"Learner", "student", "MIU"));
        posts.add(new Post(idCounter++,"Learner2", "student2", "MIU"));
        posts.add(new Post(idCounter++,"Learner3", "student3", "MIU"));
    }

    @Override
    public Post findById(long id) {
        return posts.stream()
                .filter(post -> post.getId() == Long.valueOf(id))
                .findFirst().get();

    }

    @Override
    public List<PostDTO> findAll() {
        return posts.stream()
                .map(post -> new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public Post createPost(String title, String content, String author) {
        Post post = new Post(idCounter++,title, content, author);
        posts.add(post);
        return post;
    }

    @Override
    public PostDTO updatePost(long id,PostDTO postDTO) {
        Post post = findById(id);

        if (post != null) {
            if(postDTO.getTitle() != null)
                post.setTitle(postDTO.getTitle());
            if(postDTO.getContent() != null){
                post.setContent(postDTO.getContent());
            }
            if(postDTO.getAuthor() != null)
                post.setAuthor(postDTO.getAuthor());

            return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
        }else {
            System.out.println("Post not found");
            return null;
        }
    }

    @Override
    public boolean deletePost(long id) {
        Post post = findById(id);
        if (post != null) {
            posts.remove(post);
            return true;
        }
        return false;
    }
}
