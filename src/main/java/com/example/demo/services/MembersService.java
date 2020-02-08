package com.example.demo.services;

import com.example.demo.domain.Members;
import com.example.demo.exception.NotFoundMemberException;
import com.example.demo.repositories.MembersRepository;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
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

    private Keycloak client;

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

    public UserRepresentation signUp(UserRepresentation user) {
        try {
            Response response = client.realm(REALM).users().create(user);
            response.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return user;
    }
}
