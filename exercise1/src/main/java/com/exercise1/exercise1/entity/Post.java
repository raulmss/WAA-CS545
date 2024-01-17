package com.exercise1.exercise1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;

}
