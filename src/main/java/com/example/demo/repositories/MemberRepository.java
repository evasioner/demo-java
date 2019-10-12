package com.example.demo.repositories;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MemberRepository extends JpaRepository<Member, BigInteger> {
}
