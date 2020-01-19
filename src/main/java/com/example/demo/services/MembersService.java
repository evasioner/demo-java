package com.example.demo.services;

import com.example.demo.domain.Members;
import com.example.demo.domain.Roles;
import com.example.demo.exception.NotFoundMemberException;
import com.example.demo.repositories.MembersRepository;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembersService {

    @Value("${keycloak.credentials.secret}")
    private String SECRETKEY;

    @Value("${keycloak.resource}")
    private String CLIENTID;

    @Value("${keycloak.auth-server-url}")
    private String AUTHURL;

    @Value("${keycloak.realm}")
    private String REALM;

    private final MembersRepository memberRepository;

    MembersService(MembersRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Members> getMembers() {
        return memberRepository.findAll();
    }

    public Members getMemberByMemberNo(Long memberNo) throws NotFoundMemberException {
        return memberRepository.findById(memberNo).orElseThrow(NotFoundMemberException::new);
    }

    @Transactional
    public Members joinMembers(Members members) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        members.setPassword(passwordEncoder.encode(members.getPassword()));
        members.setRole(Roles.USER.getValue());
        return memberRepository.save(members);
    }

    public UserRepresentation signUp(UserRepresentation user) {
        try {

            UsersResource usersResource = getKeycloakUserResource();

        } catch (Exception e) {

        }
        return user;
    }


    private UsersResource getKeycloakUserResource() {
        Keycloak kc = KeycloakBuilder.builder().serverUrl(AUTHURL).realm("master").username("admin").password("admin")
                .clientId("spring-app").build();
        RealmResource realmResource = kc.realm(REALM);
        UsersResource userRessource = realmResource.users();
        return userRessource;
    }
}
