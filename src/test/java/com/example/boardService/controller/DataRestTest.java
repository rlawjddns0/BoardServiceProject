package com.example.boardService.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("SPsring Data Rest 통합 테스트는 제외")
@DisplayName("Data Rest TEst")
@SpringBootTest
@AutoConfigureMockMvc
public class DataRestTest {
    private MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc){
        this.mvc=mvc;
    }

    @DisplayName("게시글 list 조회")
    @Transactional
    @Test
    void geivenNothing_whenRequesting_thenReturnArticlesResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal_json")));
    }

    @DisplayName("게시글 단건 조회")
    @Transactional
    @Test
    void geivenNothing_whenRequestingArticle_thenReturnArticlesResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal_json")));
    }

    @DisplayName("게시글 댓글 리스트 조회")
    @Transactional
    @Test
    void geivenNothing_whenRequestingArticleCommentsFromArticle_thenReturnArticlesResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal_json")));
    }

    @DisplayName("게시글 댓글 조회")
    @Transactional
    @Test
    void geivenNothing_whenRequestingArticleComments_thenReturnArticlesResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal_json")));
    }

    @DisplayName("게시글 댓글 단건 조회")
    @Transactional
    @Test
    void geivenNothing_whenRequestingArticleComment_thenReturnArticlesResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal_json")));
    }
}
