package com.SeongUk52.SpringStudy.service;

import com.SeongUk52.SpringStudy.domain.Member;
import com.SeongUk52.SpringStudy.repository.MemberRepository;
import com.SeongUk52.SpringStudy.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        validateUniqueName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateUniqueName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> fineOne(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
