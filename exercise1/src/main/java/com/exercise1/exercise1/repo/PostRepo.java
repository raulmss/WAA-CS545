package com.exercise1.exercise1.repo;

import com.exercise1.exercise1.entity.Post;
import com.exercise1.exercise1.entity.dto.PostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    //List<Post> findAllByTitleEqualsOrderByidAsc(String title);

    List<Post> findAllByTitleEquals(String title);
}
