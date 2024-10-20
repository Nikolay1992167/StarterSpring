package ru.clevertec.dto.user;

public record UserResponse(Long id,
                           String login,
                           String name,
                           String email) {
}