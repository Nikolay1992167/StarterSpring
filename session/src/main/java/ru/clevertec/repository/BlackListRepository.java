package ru.clevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.model.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Long> {
}