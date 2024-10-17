package com.my.articles.repository;

import com.my.articles.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Articles, Long> {
}
