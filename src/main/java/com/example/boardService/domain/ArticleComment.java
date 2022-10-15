package com.example.boardService.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),

})
@Entity
public class ArticleComment extends EntityFileds{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Setter @ManyToOne(optional = false)//1개의 게시글에 여러개의 댓글 가능 1:N
    private Article article;// 게시글 (id)

    @Setter @Column(nullable = false, length = 500) private String content;// 댓글 본문


    protected ArticleComment() {

    }

    private ArticleComment(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    public static ArticleComment of(Article article, String content){
        return new ArticleComment(article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleComment that = (ArticleComment) o;
        return Id !=null && Id.equals(that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
