package com.exercise1.exercise1.controller;

import com.exercise1.exercise1.entity.Users;
import com.exercise1.exercise1.entity.dto.PostDTO;
import com.exercise1.exercise1.entity.dto.UsersDTO;
import com.exercise1.exercise1.repo.UsersRepo;
import com.exercise1.exercise1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersRepo usersRepo;

    @GetMapping()
    public ResponseEntity<List<UsersDTO>> getAllUsers(@RequestParam(value = "moreThanOnePost", required = false) boolean moreThanOne){
        List<UsersDTO> users = usersService.getAll(moreThanOne);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable long id){
        try{
            UsersDTO user = usersService.getUserById(id);
            return ResponseEntity.ok(user);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsersDTO> createNewUser(@RequestBody UsersDTO usersDTO){
        UsersDTO user = usersService.createNewUser(usersDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUserId(@PathVariable long id){
        List<PostDTO> posts = usersService.getPostsByUserId(id);
        return ResponseEntity.ok(posts);
    }

}
