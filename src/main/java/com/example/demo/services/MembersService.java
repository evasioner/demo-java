package com.example.demo.services;

import com.example.demo.domain.Members;
import com.example.demo.domain.Roles;
import com.example.demo.repositories.MembersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class MembersService implements UserDetailsService {
    private final MembersRepository memberRepository;

    MembersService(MembersRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Members> getMembers() {
        return memberRepository.findAll();
    }

    public Members getMemberByMemberNo(BigInteger memberNo) {
        return memberRepository.findById(memberNo).get();
    }

    @Transactional
    public Members joinMembers(Members members) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        members.setPassword(passwordEncoder.encode(members.getPassword()));
        members.setRole(Roles.USER.getValue());
        return memberRepository.save(members);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
