package com.my.articles.dto;

import com.my.articles.entity.Articles;
import com.my.articles.entity.Comment;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String nickname;
    private String body;

    public static CommentDto fromEntity(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }

    public static Comment fromDto(CommentDto dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setNickname(dto.getNickname());
        comment.setBody(dto.getBody());
        return comment;
    }
}
