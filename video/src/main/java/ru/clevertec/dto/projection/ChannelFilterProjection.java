package ru.clevertec.dto.projection;

public interface ChannelFilterProjection {

    Long getId();

    String getTitle();

    Integer getSubscribersCount();

    String getMainLanguage();

    byte[] getAvatar();

    String getCategory();
}