package com.lits.project.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class ResponseDTO {

    private Long idResponse;
    private PlainUserDTO user;                                                      // юзер
    private PlainMovieDTO movie;                                                    // фільм
    private int rating;                                                             // рейтинг фільму

    @NotBlank(message = "feedback cannot be empty")
    private String feedback;                                                        // відгук про фільм

}
