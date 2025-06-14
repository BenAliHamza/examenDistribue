package tn.esprit.films.service;

import tn.esprit.films.entities.Film;
import tn.esprit.films.service.dto.FilmRequest;
import tn.esprit.films.service.dto.FilmResponse;

import java.util.List;

public interface FilmService {
    FilmResponse createFilm(FilmRequest request);
    List<FilmResponse> getAllFilms();
    FilmResponse getFilmById(String id);
    FilmResponse updateFilm(String id, FilmRequest request);
    void deleteFilm(String id);
    // In FilmService
    List<FilmResponse> getFilmsByStudioId(String studioId);
    // interface
    Film getEntityById(String id);

}