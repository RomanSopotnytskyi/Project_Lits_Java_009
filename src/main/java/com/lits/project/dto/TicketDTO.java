package com.lits.project.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TicketDTO {
    private Long idTicket;

    private PlainUserDTO user;                                       // юзер

    private PlainSeassionDTO seassion;                               // сеанс

    @NotBlank(message = "place cannot be empty")
    private int place;                                               // № місця

    @NotBlank(message = "price cannot be empty")
    private int price;                                               // ціна

    private String type;                                             // з промокодом

    private String status;                                           // відьний / заброньовіний / куплений
}
