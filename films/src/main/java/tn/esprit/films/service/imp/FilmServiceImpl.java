package tn.esprit.films.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.films.entities.Film;
import tn.esprit.films.repositories.FilmRepository;
import tn.esprit.films.service.FilmService;
import tn.esprit.films.service.dto.FilmDTO;
import tn.esprit.films.service.mappers.FilmMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    public FilmDTO createFilm(FilmDTO filmDTO) {
        Film film = FilmMapper.toEntity(filmDTO);
        return FilmMapper.toDTO(filmRepository.save(film));
    }

    public List<FilmDTO> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(FilmMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FilmDTO getFilmById(String id) {
        return filmRepository.findById(id)
                .map(FilmMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Film not found"));
    }

    public FilmDTO updateFilm(String id, FilmDTO filmDTO) {
        Film existingFilm = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));

        Film updatedFilm = FilmMapper.toEntity(filmDTO);
        updatedFilm.setId(existingFilm.getId());
        return FilmMapper.toDTO(filmRepository.save(updatedFilm));
    }

    public void deleteFilm(String id) {
        filmRepository.deleteById(id);
    }
}
