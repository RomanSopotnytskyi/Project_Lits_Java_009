package com.lits.project.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class PlainUserDTO {

    private Long idUser;
    private String username;
    //private String firstname;
    //private String lastname;
}
