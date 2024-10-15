package ru.clevertec.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.dto.SessionRequest;
import ru.clevertec.dto.SessionResponse;
import ru.clevertec.model.Session;

@Mapper
public interface SessionMapper {

    Session fromRequest(SessionRequest request);

    SessionResponse toResponse(Session session);
}