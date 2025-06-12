package tn.esprit.films.service.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDTO {
    private String id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Director is required")
    private String director;

    private LocalDate releaseDate;

    @NotBlank(message = "Studio ID is required")
    private String studioId;

    private String genre;

    private Integer duration;
}