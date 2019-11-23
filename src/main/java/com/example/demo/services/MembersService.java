package com.example.demo.services;

import com.example.demo.domain.Members;
import com.example.demo.repositories.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MembersService {
    @Autowired
    private MembersRepository memberRepository;

    public List<Members> getMembers() {
        return memberRepository.findAll();
    }

    public Members getMemberByMemberNo(BigInteger memberNo) {
        return memberRepository.findById(memberNo).get();
    }

//    public Members getMemberByUsername(String username) {
//        return memberRepository.
//    }


}
