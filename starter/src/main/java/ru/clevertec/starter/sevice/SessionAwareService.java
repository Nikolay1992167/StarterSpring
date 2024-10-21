package ru.clevertec.starter.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;
import ru.clevertec.starter.model.Session;

@RequiredArgsConstructor
public class SessionAwareService {

    private final RestClient restClient;

    public Session findByLogin(String login) {
        return restClient.post()
                .body(login)
                .retrieve()
                .body(Session.class);
    }
}