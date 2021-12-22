package com.lits.project.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class SeassionDTO {

    private Long idSeassion;

    private PlainMovieDTO movie;                                                        // фільм

    @NotBlank(message = "date cannot be empty")
    private String date;                                                                // дата сеансу

    private String seassionStartTime;                                                   // час посчатку

    private Set<PlainTicketDTO> tickets = new HashSet<>();                              // список квитків

}
