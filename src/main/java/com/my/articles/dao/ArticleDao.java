package com.my.articles.dao;

import com.my.articles.dto.ArticleDto;
import com.my.articles.entity.Articles;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 붙여야 스프링이 알아서 관리
@Transactional
public class ArticleDao {
    @Autowired
    EntityManager em;

    public List<Articles> getAllArticle() {
        String sql = "SELECT a FROM Articles a ORDER BY a.id DESC";
        return em.createQuery(sql).getResultList();
    }

    public Articles getOneArticle(Long id) {
        return em.find(Articles.class, id);
    }

    public void deleteArticle(Long id) {
        Articles articles = em.find(Articles.class, id);
        em.remove(articles);
    }

    public void updateArticle(ArticleDto dto) {
        Articles articles = em.find(Articles.class, dto.getId());
        articles.setTitle(dto.getTitle());
        articles.setContent(dto.getContent());
    }

    public void insertArticle(Articles articles) {
        em.persist(articles);
    }
}
