package com.exercise1.exercise1.service;

import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.entity.dto.UsersDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<UsersDTO> getAll(boolean moreThanOnePost);

    List<UsersDTO> getAllUsersWithMoreThanNPost(int n);
    UsersDTO getUserById(long id);
    UsersDTO createNewUser(UsersDTO usersDTO);

    List<PostDTO> getPostsByUserId(long id);

    void deleteUser(long id);

    List<UsersDTO> getAllUserByPostTitle(String title);

}
