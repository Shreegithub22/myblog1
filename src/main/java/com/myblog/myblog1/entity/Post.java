package com.myblog.myblog1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
     private long id;

     private String description;
     private String content;
     private String title;

     //one post can have multiple comments
     @OneToMany(cascade=CascadeType.ALL,mappedBy = "post")
     private List<Comment> comments;
}
