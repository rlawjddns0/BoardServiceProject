package com.example.boardService.repository;

import com.example.boardService.config.JpaConfig;
import com.example.boardService.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("testdb")
@AutoConfigureTestDatabase()
@Import(JpaConfig.class)
@DisplayName("JPA 연결 TEST")
@DataJpaTest
public class japRepositoryTest {
    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleRepository articleRepository;

    public japRepositoryTest(@Autowired ArticleCommentRepository articleCommentRepository, @Autowired ArticleRepository articleRepository) {
        this.articleCommentRepository = articleCommentRepository;
        this.articleRepository = articleRepository;
    }

    @DisplayName("select Test")
    @Test
    void given_when_then() {
        //given
        long previousCount = articleRepository.count();
        Article newArticle = Article.of("new", "new", "#color");

        //when
        Article savedArticle = articleRepository.save(newArticle);


        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);

    }

    @DisplayName("insert Test")
    @Test
    void given_when_then_insert() {
        //given
        long previousCount = articleRepository.count();
        Article newArticle = Article.of("new", "new", "#color");

        //when
        Article savedArticle = articleRepository.save(newArticle);


        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);

    }

    @DisplayName("update Test")
    @Test
    void given_when_then_update() {
        //given
        Article selectArticle = articleRepository.findById(1L).orElseThrow();
        String hashTag = "#springBoot";
        selectArticle.setHashtag("#springBoot");

        //when
        Article savedArticle = articleRepository.saveAndFlush(selectArticle);


        //then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", hashTag);

    }

    @DisplayName("deleete Test")
    @Test
    void given_when_then_deleting() {
        //given
        Article selectArticle = articleRepository.findById(1L).orElseThrow();
        long previousCount = articleRepository.count();

        //when
        articleRepository.delete(selectArticle);


        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount - 1);

    }

}
