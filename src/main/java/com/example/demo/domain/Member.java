package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private BigInteger memberNo;
    private String memberName;
    private String memberId;
    //    private String password;
//    private String passwordConfirm;
    private String memberEmail;
    private String createdAt;
    private String updatedAt;
}

