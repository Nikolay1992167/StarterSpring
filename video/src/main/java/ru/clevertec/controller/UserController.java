package ru.clevertec.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.dto.channel.ChannelNamesResponse;
import ru.clevertec.dto.user.UserRequest;
import ru.clevertec.dto.user.UserResponse;
import ru.clevertec.service.UserService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateById(@PathVariable @Positive Long id,
                                                   @RequestBody @Valid UserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateById(id, request));
    }

    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<ChannelNamesResponse> findAllSubscribedChannelNamesById(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(userService.findAllSubscriberChannelNamesById(id));
    }
}