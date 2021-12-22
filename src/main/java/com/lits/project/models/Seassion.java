package com.lits.project.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)

@Entity
@Table(name = "seassion")
public class Seassion implements Serializable{                                                          //сеанс

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seassion")
    private Long idSeassion;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="id_movie")
    private Movie movie;                                                                                // фільм

    @Column(name = "date_seassion")
    private String date;                                                                                // дата сеансу

    @Column(name = "seassion_start_ttime")
    private String seassionStartTime;                                                                   // час посчатку

    @JsonManagedReference
    @OneToMany(mappedBy = "seassion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)               //, список квитків
    private Set<Ticket> tickets;

    public void addTickets(Ticket ticket){
        tickets.add(ticket);
    }

    public void deleteTickets(Ticket ticket){
        tickets.remove(ticket);
    }

}
