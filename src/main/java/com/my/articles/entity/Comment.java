package com.my.articles.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String body;
    @Column(name = "article_id")
    private Articles articles;


}
