package com.example.demo.repositories;

import com.example.demo.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MembersRepository extends JpaRepository<Members, BigInteger> {
}
