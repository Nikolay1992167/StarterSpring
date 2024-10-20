package ru.clevertec.service;

import ru.clevertec.dto.SessionRequest;
import ru.clevertec.dto.SessionResponse;

public interface SessionService {

    SessionResponse findByLoginOrSaveAndReturn(SessionRequest request);

    String deleteAll();
}