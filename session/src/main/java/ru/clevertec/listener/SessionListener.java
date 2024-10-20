//package ru.clevertec.listener;
//
//import jakarta.persistence.PrePersist;
//import ru.clevertec.model.Session;
//
//import java.time.LocalDateTime;
//
//public class SessionListener {
//
//    @PrePersist
//    public void prePersist(Session session) {
//        session.setOpeningTime(LocalDateTime.now());
//    }
//}