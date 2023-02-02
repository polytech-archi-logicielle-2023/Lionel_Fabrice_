package com.example.demo.dto;
import lombok.*;

@Data
@Builder
public class FilmDTO {
    private String title;
    private String realisator;
    private String type;
}
