package ru.clevertec.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.clevertec.service.SessionService;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionCleaner {

    private final SessionService sessionService;

    @Scheduled(cron = "${session.time}")
    public void clean() {
        String message = sessionService.deleteAll();
        log.warn(message);
    }
}