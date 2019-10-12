package com.example.demo.services;

import com.example.demo.domain.Member;
import com.example.demo.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberByMemberNo(BigInteger memberNo) {
        return memberRepository.findById(memberNo).get();
    }

    public void passwordEncoder() {

    }
}
