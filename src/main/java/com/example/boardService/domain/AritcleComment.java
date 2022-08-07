package com.example.boardService.domain;

import java.time.LocalDateTime;

public class AritcleComment {
    private  Long Id;
    private Article article;// 게시글 (id)
    private String content;// 댓글 본문

    private LocalDateTime createdAt;//생성 일시
    private String createdBy;//생성자
    private LocalDateTime modifiedAt;//수정일시
    private String modifiedBy;//수정자
}
