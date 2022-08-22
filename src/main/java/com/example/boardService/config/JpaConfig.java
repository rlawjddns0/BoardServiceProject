package com.example.boardService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration //config설정 파일 bean으로 만든다
@EnableJpaAuditing
public class JpaConfig {

    //JpaAutditing을 사용할때 누가 수정을 했는지 이름을 설정
    @Bean
    public AuditorAware<String > auditorAware(){
        return () -> Optional.of("kim"); //TODO: 스프링 시큐리티로 인증 기능을 붙일떄 수정 해야한다.
    }

}
