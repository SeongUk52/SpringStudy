package com.SeongUk52.SpringStudy.service;

import com.SeongUk52.SpringStudy.domain.Member;
import com.SeongUk52.SpringStudy.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateUniqueName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateUniqueName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> fineOne(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
