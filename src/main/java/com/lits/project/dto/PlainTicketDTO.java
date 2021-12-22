package com.lits.project.dto;

import lombok.Data;

@Data
public class PlainTicketDTO {

    private Long idTicket;
    private int place;                                               // № місця
    //private int price;                                               // ціна
    //private String type;                                             // з промокодом
    private String status;                                           // відьний / заброньовіний / куплений

}
