package com.my.articles.dao;

import com.my.articles.dto.ArticleDto;
import com.my.articles.entity.Articles;
import com.my.articles.entity.Comment;
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
        List<Articles> articles = em.createQuery(sql).getResultList();
        return articles;
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

    public List<Comment> getOneComment(Long id) {
        String sql = "SELECT c FROM Comment c WHERE c.article_id = :id";
        return em.createQuery(sql).getResultList();
    }
}
