package tn.esprit.films.service;

import tn.esprit.films.service.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    public FilmDTO createFilm(FilmDTO filmDTO);


    public List<FilmDTO> getAllFilms();
    public FilmDTO getFilmById(String id);
    public FilmDTO updateFilm(String id, FilmDTO filmDTO);
    public void deleteFilm(String id) ;
}
