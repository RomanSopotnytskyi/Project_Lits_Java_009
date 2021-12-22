package com.lits.project.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class MovieDTO {

    private Long idMovie;

    @NotBlank(message = "title cannot be empty")
    private String title;                                                        // назва
    private int year;                                                            // рік виходу
    private String length;                                                       // довжина
    private String genre;                                                        // жанр
    private String trailer;                                                      // посилання на youtube

    private Set<PlainSeassionDTO> seassions = new HashSet<>();                        // список сеансів
    private Set<PlainResponseDTO> responses  = new HashSet<>();                        // список відгуків
}
