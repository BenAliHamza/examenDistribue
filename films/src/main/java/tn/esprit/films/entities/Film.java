package tn.esprit.films.entities;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "films")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id
    private String id;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private String studioId; // Reference to Studio service
    private String genre;
    private int duration;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}