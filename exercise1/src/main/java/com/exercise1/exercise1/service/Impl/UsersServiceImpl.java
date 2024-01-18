package com.exercise1.exercise1.service.Impl;

import com.exercise1.exercise1.entity.Users;
import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.entity.dto.UsersDTO;
import com.exercise1.exercise1.repo.PostRepo;
import com.exercise1.exercise1.repo.UsersRepo;
import com.exercise1.exercise1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private PostRepo postRepo;
    @Override
    public List<UsersDTO> getAll(boolean moreThanOnePost) {

        if(moreThanOnePost){
            return usersRepo.getAllUsersWithMoreThanOnePost()
                    .stream()
                    .map(user -> new UsersDTO(user.getId(), user.getName(), user.getPosts()))
                    .collect(Collectors.toList());
        }
        return usersRepo.findAll()
                .stream()
                .map(user -> new UsersDTO(user.getId(), user.getName(), user.getPosts()))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDTO getUserById(long id) {
            Users user = usersRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("No User found with id: "+id+"."));
            return new UsersDTO(user.getId(), user.getName(), user.getPosts());
    }

    @Override
    public UsersDTO createNewUser(UsersDTO usersDTO) {
        Users user = new Users(usersDTO.getName(), usersDTO.getPosts());
        usersRepo.save(user);
        usersDTO.setId(user.getId());
        return usersDTO;
    }

    @Override
    public List<PostDTO> getPostsByUserId(long id) {
        Users user = usersRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No Posts found with user id: "+id+"."));
        return user.getPosts()
                .stream()
                .map(post -> new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor()))
                .collect(Collectors.toList());
    }

}
