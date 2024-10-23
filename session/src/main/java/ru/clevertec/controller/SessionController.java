package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.dto.SessionRequest;
import ru.clevertec.dto.SessionResponse;
import ru.clevertec.service.SessionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public SessionResponse findByLoginOrSaveAndReturn(@RequestBody SessionRequest request) {
        return sessionService.findByLoginOrSaveAndReturn(request);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        return ResponseEntity.ok().body(sessionService.deleteAll());
    }
}