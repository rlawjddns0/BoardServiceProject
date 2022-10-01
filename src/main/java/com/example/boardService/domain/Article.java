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
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),

})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;  //Id는 setter로 변경이 안되게끔 해야 한다. 그래서 @Setter를 안걸었다


    @Setter @Column(nullable = false) private String title; //제목
    @Setter @Column(nullable = false, length = 10000) private String content;//본문

    @Setter private String hashtag;//해시태그


    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @ToString.Exclude //순환 참조가 일어날수 있는걸 끊는다
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();



    //최초 인서트할때 자동으로 넣어준다.
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;//생성 일시
    @CreatedBy
    @Column(nullable = false , length = 100)
    private String createdBy;//생성자

    //수정할때 자동으로 넣어준다.
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;//수정일시
    //수정자나 생성자는 JpaConfig에서 EnableJpaAuditing을 사용하여 설정했다.
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;//수정자

    protected Article(){} //new로 생성 못하게 막는다

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        return new Article(title,content,hashtag);
    }

    //동등성 검사
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Id !=null && Id.equals(article.Id);//아직 영속화(id가 부여받지 않았으면)가 안됐으면 다른걸로 간주한다.(처리하지 않는다) 같으면(null이 아니면) equals
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
