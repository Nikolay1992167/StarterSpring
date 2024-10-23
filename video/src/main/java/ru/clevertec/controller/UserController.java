package ru.clevertec.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.dto.channel.ChannelNamesResponse;
import ru.clevertec.dto.user.UserRequest;
import ru.clevertec.dto.user.UserResponse;
import ru.clevertec.service.UserService;
import ru.clevertec.starter.annotation.SessionAware;
import ru.clevertec.starter.model.Session;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @SessionAware(blackList = {"eva", "olega"})
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest request,
                                             Session session) {
        log.info(session.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @SessionAware
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateById(@PathVariable @Positive Long id,
                                                   @RequestBody @Valid UserRequest request,
                                                   Session session) {
        log.info(session.toString());
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateById(id, request));
    }

    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<ChannelNamesResponse> findAllSubscribedChannelNamesById(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(userService.findAllSubscriberChannelNamesById(id));
    }
}