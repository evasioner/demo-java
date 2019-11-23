package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;
    @NotEmpty
    private String password;
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "authority",
            joinColumns = {@JoinColumn(name = "member_no")},
            inverseJoinColumns = {@JoinColumn(name = "authority_no")})
    private Set<Authority> authorities = new HashSet<>();
}

