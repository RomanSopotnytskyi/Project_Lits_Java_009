
package com.lits.project.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long idTicket;

    @ManyToOne//(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="id_user")
    private User user;                              // юзер

    @ManyToOne
    @JsonProperty
    @JoinColumn(name = "id_seassion")
    private Seassion seassion;

    private int place;                              // № місця

    private int price;                              // ціна

    private String type;                            // з промокодом

    private String status;                          // відьний / заброньовіний / куплений

    public Ticket() {
    }

    public Ticket(User user, Seassion seassion, int place, int price, String type, String status) {
        this.user = user;
        this.seassion = seassion;
        this.place = place;
        this.price = price;
        this.type = type;
        this.status = status;
    }
}
