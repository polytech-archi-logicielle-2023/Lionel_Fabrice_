package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;

import java.util.*;

@Service
public class FilmService {
    private final FilmRepository repository;
    public List<Film> list = new ArrayList<>();
    public Integer id = 1;
    public FilmService(FilmRepository repository) {
        this.repository = repository;
        this.initFilms();
    }
    public void initFilms() {
        Film film1 = new Film();
        film1.setTitle("Hunger Games");
        film1.setType("SciFi");
        film1.setRealisator("Gary ROSS");
        this.repository.save(film1);
    }

    public List<Film> getAllFilms() {
        return this.repository.findAll();
    }

    public Film getFilmById(Integer id) {

        Optional<Film> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public Film createFilm(Film givenFilm) {
        if (givenFilm.getTitle() != null && givenFilm.getType() != null) {
            return this.repository.save(givenFilm);
        }
        return null;
    }
    public boolean deleteFilm(Integer filmId) {
        Film found = getFilmById(filmId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}