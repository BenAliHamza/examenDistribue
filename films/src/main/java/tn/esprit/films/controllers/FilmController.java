package tn.esprit.films.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.films.service.FilmService;
import tn.esprit.films.service.dto.FilmRequest;
import tn.esprit.films.service.dto.FilmResponse;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<FilmResponse> createFilm(@RequestBody FilmRequest request) {
        return new ResponseEntity<>(filmService.createFilm(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FilmResponse>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponse> getFilmById(@PathVariable String id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmResponse> updateFilm(
            @PathVariable String id,
            @RequestBody FilmRequest request
    ) {
        return ResponseEntity.ok(filmService.updateFilm(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable String id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}