package com.example.boardService.repository;

import com.example.boardService.domain.Article;
import com.example.boardService.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource

public interface ArticleRepository
        extends JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,// 검색 기능을 기본적으로 제공한다.
        QuerydslBinderCustomizer<QArticle> {


    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title,root.content,root.hashtag,root.createdAt,root.createdBy);//검색 조건을 설정한다.
        bindings.bind(root.title).first((StringExpression::containsIgnoreCase));
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase));
        bindings.bind(root.hashtag).first((StringExpression::containsIgnoreCase));
        bindings.bind(root.createdBy).first((StringExpression::containsIgnoreCase));
        bindings.bind(root.createdAt).first((DateTimeExpression::eq));


    };
}