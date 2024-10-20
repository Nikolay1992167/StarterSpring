package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dto.SessionRequest;
import ru.clevertec.dto.SessionResponse;
import ru.clevertec.exception.SessionServiceException;
import ru.clevertec.mapper.SessionMapper;
import ru.clevertec.repository.SessionRepository;
import ru.clevertec.service.SessionService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    @Override
    @Transactional
    public SessionResponse findByLoginOrSaveAndReturn(SessionRequest request) {
        return sessionRepository.findByLogin(request.login())
                .map(sessionMapper::toResponse)
                .orElseGet(() -> save(request));
    }

    @Override
    @Transactional
    public String deleteAll() {
        LocalDateTime now = LocalDateTime.now();
        Integer deletedCount = sessionRepository.deleteAllByOpeningTimeBefore(now);
        return deletedCount > 0
                ? "Cleared %s sessions until %s".formatted(deletedCount, now)
                : "No sessions to delete";
    }

    private SessionResponse save(SessionRequest request) {
        return Optional.of(request)
                .map(sessionMapper::fromRequest)
                .map(sessionRepository::save)
                .map(sessionMapper::toResponse)
                .orElseThrow(() -> new SessionServiceException("Can't save session"));
    }
}