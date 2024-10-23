package ru.clevertec.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import ru.clevertec.enam.Language;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private User author;

    @OneToMany(mappedBy = "channel")
    @ToString.Exclude
    private List<Subscriber> subscribers = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "main_language")
    private Language mainLanguage;

    @Lob
    @Column(name = "avatar")
    private byte[] avatar;

    @Column(name = "category")
    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(id, channel.id) && Objects.equals(title, channel.title) && Objects.equals(description, channel.description) && Objects.equals(author, channel.author) && Objects.equals(createdAt, channel.createdAt) && mainLanguage == channel.mainLanguage && category == channel.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, createdAt, mainLanguage, category);
    }
}