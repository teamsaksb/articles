package com.my.articles.service;

import com.my.articles.dao.ArticleDao;
import com.my.articles.dto.ArticleDto;
import com.my.articles.dto.CommentDto;
import com.my.articles.entity.Articles;
import com.my.articles.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    EntityManager em;

    @Autowired
    ArticleDao dao;

    public List<ArticleDto> showAll() {
//        String sql = "SELECT a FROM Articles a";
//        Query query = em.createQuery(sql);
//        List<Articles> articlesList = query.getResultList();
//        return articlesList;
        List<Articles> articles = dao.getAllArticle();
        if (ObjectUtils.isEmpty(articles)) {
            return Collections.emptyList();
        }
        List<ArticleDto> dtoList = articles.stream().map(x -> ArticleDto.fromEntity(x)).toList();
        return dtoList;
    }

    public ArticleDto findById(Long id) {
        Articles article = dao.getOneArticle(id);
        if(ObjectUtils.isEmpty(article)) return null;
        return ArticleDto.fromEntity(article);
//        List<Articles> articlesList = (List<Articles>) em.find(Articles.class, id);
//        String sql = "SELECT a FROM Articles a WHERE a.id = :id";
//        Query query = em.createQuery(sql);
//        List<Articles> articlesList = query.getResultList();
//        return articlesList;
    }

    public void deleteArticle(Long id) {
        dao.deleteArticle(id);
    }

    public void updateArticle(ArticleDto dto) {
        dao.updateArticle(dto);
    }

    public void insertArticle(ArticleDto dto) {
        dao.insertArticle(ArticleDto.fromDto(dto));
    }

    public List<Comment> commentFindById(Long id) {
        List<Comment> comment = dao.getOneComment(id);
        if(ObjectUtils.isEmpty(comment)) return null;
        return comment;
    }

//    public List<Comment> showCommentAll(Long id) {
//        String sql = "SELECT c FROM Comment c WHERE c.articles.article_id = :id";
//        Query query = em.createQuery(sql);
//        List<Comment> commentList = query.setParameter("id", id).getResultList();
//        return commentList;
//    }
}
