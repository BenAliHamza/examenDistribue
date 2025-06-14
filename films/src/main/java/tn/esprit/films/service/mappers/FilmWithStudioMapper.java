package tn.esprit.films.service.mappers;

import tn.esprit.films.entities.Film;
import tn.esprit.films.service.dto.FilmWithStudioDto;
import tn.esprit.films.service.dto.StudioResponse;

public class FilmWithStudioMapper {
    public static FilmWithStudioDto toDto(Film film, StudioResponse studio) {
        return FilmWithStudioDto.builder()
                .film(FilmMapper.toResponse(film))
                .studio(studio)
                .build();
    }
}
