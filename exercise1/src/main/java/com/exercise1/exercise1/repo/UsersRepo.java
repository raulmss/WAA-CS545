package com.exercise1.exercise1.repo;

import com.exercise1.exercise1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u JOIN u.posts p GROUP BY u HAVING COUNT(p) > 1")
    List<Users> getAllUsersWithMoreThanOnePost();
    @Query("SELECT u FROM Users u JOIN u.posts p GROUP BY u HAVING COUNT(p) > :n")
    List<Users> getAllUsersWithMoreThanNPost(@Param("n") int n);

    List<Users> findAllByPostsTitle(String title);
}
