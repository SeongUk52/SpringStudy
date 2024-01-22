package com.SeongUk52.SpringStudy;

import com.SeongUk52.SpringStudy.repository.MemberRepository;
import com.SeongUk52.SpringStudy.repository.MemoryMemberRepository;
import com.SeongUk52.SpringStudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
