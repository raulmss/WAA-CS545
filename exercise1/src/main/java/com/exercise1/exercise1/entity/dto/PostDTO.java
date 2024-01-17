package com.exercise1.exercise1.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDTO {
    long id;
    String title;
    String content;
    String author;
}
