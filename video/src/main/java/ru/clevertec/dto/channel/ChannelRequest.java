package ru.clevertec.dto.channel;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.clevertec.enam.Language;
import ru.clevertec.validation.annotation.UniqueChannelTitle;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ChannelRequest(@NotBlank
                             @Size(max = 40)
                             @UniqueChannelTitle
                             String title,

                             @NotBlank
                             @Size(max = 100)
                             String description,

                             Language mainLanguage,

                             @NotBlank
                             String category) {
}