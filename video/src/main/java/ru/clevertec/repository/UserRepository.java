package ru.clevertec.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"subscriptions.channel"})
    Optional<User> findWithSubscriptionsChannelById(Long id);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByEmail(String email);
}