package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorityNo;
    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority() {
    }

    public Authority(AuthorityType name) {
        this.name = name;
    }
    // getters and setters
}

