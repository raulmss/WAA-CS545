package com.exercise1.exercise1.entity.dto;

import com.exercise1.exercise1.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UsersDTO {
    long id;
    String name;
    List<Post> posts;

}
