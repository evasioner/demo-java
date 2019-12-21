package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Members implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger memberNo;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;
    @NotEmpty
    @JsonIgnore
    private String password;
    @NotEmpty
    private String role;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}

