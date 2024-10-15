package ru.clevertec.dto;

import java.util.Set;

public record BlackListResponse(Set<String> logins) {
}