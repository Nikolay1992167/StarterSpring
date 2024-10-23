package ru.clevertec.starter.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;
import ru.clevertec.starter.dto.SessionRequest;
import ru.clevertec.starter.exception.handler.SessionServiceResponseErrorHandler;
import ru.clevertec.starter.model.Session;

@RequiredArgsConstructor
public class SessionAwareService {

    private final RestClient restClient;
    private final SessionServiceResponseErrorHandler errorHandler;

    public Session findByLogin(String login) {
        Session body = restClient.post()
                .body(new SessionRequest(login))
                .retrieve()
                .onStatus(errorHandler)
                .body(Session.class);
        System.out.println(body);
        return body;
    }
}