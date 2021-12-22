package com.lits.project.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {

    private Long idUser;

    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "password cannot be empty")
    @Size(min = 5, max = 30)
    private String password;            // пароль

    @NotBlank(message = "user_status cannot be empty")
    private String status;              // користувач / адмін

    @Email(message = "invalid email")
    private String email;

    @Min(18)
    private int age;
    private String firstname;
    private String lastname;

    private Set<PlainTicketDTO> tickets = new HashSet<>();
    private Set<PlainResponseDTO> responses = new HashSet<>();
}
