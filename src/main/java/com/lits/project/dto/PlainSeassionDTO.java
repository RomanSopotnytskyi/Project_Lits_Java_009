package com.lits.project.dto;

import lombok.Data;

@Data
public class PlainSeassionDTO {

    private Long idSeassion;
    //private Movie movie;                                                              // фільм
    private String date;                                                                // дата сеансу
    private String seassionStartTime;                                                   // час посчатку

}
