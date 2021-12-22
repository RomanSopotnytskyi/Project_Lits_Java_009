package com.lits.project.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)

@Entity
@Table(name = "movie")
public class Movie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;

    private String title;                                                        // назва

    private int year;                                                            // рік виходу

    private String length;                                                       // довжина

    private String genre;                                                        // жанр

    private String trailer;                                                      // посилання на youtube

    @JsonManagedReference
    @OneToMany(mappedBy = "movie", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Seassion> seassions = new HashSet<>();                           // список сеансів

    @JsonManagedReference
    @OneToMany(mappedBy = "movie", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Response> responses  = new HashSet<>();                          // список відгуків


    public Movie() {
    }

    public Movie(String title, int year, String length, String genre, String trailer, Set<Seassion> seassions, Set<Response> responses) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.genre = genre;
        this.trailer = trailer;
        this.seassions = seassions;
        this.responses = responses;
    }

    public void addSeassion(Seassion seassion){
        seassions.add(seassion);
    }

    public void deleteSeassion(Seassion seassion){
        seassions.remove(seassion);
    }

    public void addResponse(Response response){
        responses.add(response);
    }

    public void deleteResponse(Response response){
        responses.remove(response);
    }


}
