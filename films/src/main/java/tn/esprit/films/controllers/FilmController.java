package tn.esprit.films.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.films.service.FilmService;
import tn.esprit.films.service.dto.FilmDTO;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<FilmDTO> createFilm(@RequestBody FilmDTO filmDTO) {
        return new ResponseEntity<>(filmService.createFilm(filmDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilmById(@PathVariable String id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO> updateFilm(@PathVariable String id, @RequestBody FilmDTO filmDTO) {
        return ResponseEntity.ok(filmService.updateFilm(id, filmDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable String id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
