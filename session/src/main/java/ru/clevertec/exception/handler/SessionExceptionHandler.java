package ru.clevertec.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.clevertec.exception.SessionNotFoundException;
import ru.clevertec.exception.SessionServiceException;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class SessionExceptionHandler {

    @ExceptionHandler(SessionServiceException.class)
    public ResponseEntity<IncorrectData> handleServiceException(SessionServiceException exception) {
        return getResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SessionNotFoundException.class)
    public ResponseEntity<IncorrectData> handleNotFoundException(SessionNotFoundException exception) {
        return getResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<IncorrectData> getResponse(String message, HttpStatus status) {
        IncorrectData incorrectData = new IncorrectData(LocalDateTime.now(), message, status.value());
        return ResponseEntity.status(status).body(incorrectData);
    }
}