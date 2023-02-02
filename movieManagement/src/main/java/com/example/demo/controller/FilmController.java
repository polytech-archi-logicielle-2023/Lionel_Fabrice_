package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Film;
import com.example.demo.service.FilmService;
import com.example.demo.dto.FilmDTO;
import com.example.demo.mapper.FilmMapper;

import java.util.*;

@RequestMapping("/films")
@Controller
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("")
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        List<FilmDTO> filmsDtos = FilmMapper.toFilmDTOList(films);
        return ResponseEntity.ok(filmsDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<FilmDTO> getFilmById(@PathVariable Integer filmId) {

        Film film = filmService.getFilmById(filmId);

        if (film == null) {
            return ResponseEntity.notFound().build();
        }
        FilmDTO dto = FilmMapper.toFilmDTO(film);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<FilmDTO> createFilm(@RequestBody FilmDTO dto) {
        Film fromDto = FilmMapper.toFilm(dto);
        Film createdFilm = filmService.createFilm(fromDto);
        if (createdFilm == null) {
            return ResponseEntity.badRequest().build();
        }
        FilmDTO createdFilmDto = FilmMapper.toFilmDTO(createdFilm);
        return ResponseEntity.ok(createdFilmDto);
    }

    @DeleteMapping("/{filmId}")
    public ResponseEntity<Film> deleteFilmById(@PathVariable Integer filmId) {
        filmService.deleteFilm(filmId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}