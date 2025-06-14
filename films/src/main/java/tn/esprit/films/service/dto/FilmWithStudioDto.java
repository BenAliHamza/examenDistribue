package tn.esprit.films.service.dto;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class FilmWithStudioDto {
    private FilmResponse film;
    private StudioResponse studio;
}
