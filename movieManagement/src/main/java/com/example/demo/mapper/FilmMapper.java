package com.example.demo.mapper;
import com.example.demo.dto.FilmDTO;
import com.example.demo.model.Film;

import java.util.*;

public class FilmMapper {

    public static FilmDTO toFilmDTO(Film film) {
        return FilmDTO.builder()
                .title(film.getTitle())
                .realisator(film.getRealisator())
                .type(film.getType())
                .build();
    }

    public static List<FilmDTO> toFilmDTOList(List<Film> list) {
        List<FilmDTO> dtoList = new ArrayList<>();
        for (Film film : list) {
            dtoList.add(toFilmDTO(film));
        }
        return dtoList;
    }

    public static Film toFilm(FilmDTO dto) {
        return Film.builder()
                .title(dto.getTitle())
                .realisator(dto.getRealisator())
                .type(dto.getType())
                .build();
    }

    public static List<Film> toFilmList(List<FilmDTO> list) {
        List<Film> filmList = new ArrayList<>();
        for (FilmDTO dto : list) {
            filmList.add(toFilm(dto));
        }
        return filmList;
    }

}