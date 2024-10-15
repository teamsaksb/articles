package com.my.articles.dto;

import com.my.articles.entity.Articles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public static ArticleDto fromEntity(Articles articles) {
        return new ArticleDto(
                articles.getId(),
                articles.getTitle(),
                articles.getContent()
        );
    }

    public static Articles fromDto(ArticleDto dto) {
        Articles articles = new Articles();
        articles.setId(dto.getId());
        articles.setTitle(dto.getTitle());
        articles.setContent(dto.getContent());
        return articles;
    }

//    public static Articles fromDto(ArticleDto dto) {
//        return new Articles(
//                dto.getId(),
//                dto.getTitle(),
//                dto.getContent()
//        );
//    }
}
