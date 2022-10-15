package com.example.boardService.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@ToString
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityFileds {
    //최초 인서트할때 자동으로 넣어준다.
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;//생성 일시

    @CreatedBy
    @Column(nullable = false , length = 100)
    private String createdBy;//생성자

    //수정할때 자동으로 넣어준다.
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;//수정일시

    //수정자나 생성자는 JpaConfig에서 EnableJpaAuditing을 사용하여 설정했다.
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;//수정자
}
