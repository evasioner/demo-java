package com.example.demo.services;

import com.example.demo.clients.Oauth2Client;
import org.springframework.stereotype.Service;

@Service
public class Oauth2Service {
    private final Oauth2Client client;

    Oauth2Service(Oauth2Client client) {
        this.client = client;
    }

    public String auth() {
        return client.auth();
    }
}
