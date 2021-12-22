package com.lits.project.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)

@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;


    private String username;            // нік

    private String password;            // пароль

    @Column(name = "userstatus")
    private String status;              // користувач / адмін

    private String email;

    private String firstname;
    private String lastname;
    private int age;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();                                              // список білетів

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Response> responses = new HashSet<>();                                          // список білетів

    public User() {
    }

    public User(String username, String password, String status, String email, String firstname, String lastname, int age, Set<Ticket> tickets, Set<Response> responses) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.tickets = tickets;
        this.responses = responses;
    }

    public void addTickets(Ticket ticket){
        tickets.add(ticket);
    }

    public void deleteTickets(Ticket ticket){
        tickets.remove(ticket);
    }

    public void addResponse(Response response){
        responses.add(response);
    }

    public void deleteResponse(Response response){
        responses.remove(response);
    }
}
