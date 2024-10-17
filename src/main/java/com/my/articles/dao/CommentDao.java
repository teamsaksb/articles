package com.my.articles.dao;

import com.my.articles.entity.Articles;
import com.my.articles.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class CommentDao {
    @Autowired
    EntityManager em;

    public void insertComment(Long articleId, Comment comment) {
        Articles articles = em.find(Articles.class, articleId);
        comment.setArticles(articles);
        articles.getCommentList().add(comment);
        em.persist(articles);
    }

    public Long deleteComment(Long id) {
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
        return comment.getArticles().getId();
    }

    public Comment findByIdComment(Long commentId) {
        return em.find(Comment.class, commentId);
    }

    public void updateComment(Comment comment) {
        Comment updateCommnet = em.find(Comment.class, comment.getId());
        updateCommnet.setBody(comment.getBody());
    }
}
