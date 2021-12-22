package com.lits.project.dto;

import lombok.Data;

@Data
public class PlainResponseDTO {
    private Long idResponse;
    //private PlainUserDTO plainUserDTO;                                              // юзер
    //private PlainMovieDTO plainMovieDTO;                                            // фільм
    private int rating;                                                             // рейтинг фільму
    private String feedback;                                                        // відгук про фільм
}
