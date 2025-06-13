package tn.esprit.films.service.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmResponse {
    private String id;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private String studioId;
    private String genre;
    private Integer duration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}