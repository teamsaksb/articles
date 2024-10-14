package com.my.articles.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 1000)
    private String content;
}
