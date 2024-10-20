package ru.clevertec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.clevertec.model.Session;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SessionRepository extends MongoRepository<Session, Long> {

    Optional<Session> findByLogin(String login);

    @Query(value = "{ 'openingTime' : { $lt : ?0 } }", delete = true)
    Integer deleteAllByOpeningTimeBefore(LocalDateTime dateTime);
}