package com.my.articles.service;

import com.my.articles.dao.CommentDao;
import com.my.articles.dto.CommentDto;
import com.my.articles.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public Long deleteComment(Long id) {
        return commentDao.deleteComment(id);
    }

    public void insertComment(Long articleId, CommentDto dto) {
        commentDao.insertComment(articleId, CommentDto.fromDto(dto));
    }

    public Map<String, Object> findByIdComment(Long commentId) {
        Comment comment = commentDao.findByIdComment(commentId);
        Map<String, Object> map = new HashMap<>();
        map.put("dto", CommentDto.fromEntity(comment));
        map.put("articleId", comment.getArticles().getArticle_id());
        return map;
    }

    public void updateComment(CommentDto dto) {
        commentDao.updateComment(CommentDto.fromDto(dto));
    }
}
