package ru.clevertec.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.dto.subscriber.SubscriberResponse;
import ru.clevertec.service.SubscriptionService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/{userId}/subscriptions/{channelId}")
    public ResponseEntity<SubscriberResponse> subscribeOn(@PathVariable @Positive Long userId,
                                                          @PathVariable @Positive Long channelId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.subscribeOn(userId, channelId));
    }

    @DeleteMapping("/{userId}/subscriptions/{channelId}")
    public ResponseEntity<SubscriberResponse> subscribeOff(@PathVariable @Positive Long userId,
                                                             @PathVariable @Positive Long channelId) {
        return ResponseEntity.ok(subscriptionService.subscribeOff(userId, channelId));
    }
}