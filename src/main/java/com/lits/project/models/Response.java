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
@Table(name = "response")
public class Response implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_response")
    private Long idResponse;

    @ManyToOne//(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="id_user")
    private User user;                                                              // юзер

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="id_movie")
    private Movie movie;

    @Column(name = "rating_movies")
    private int rating;                                                             // рейтинг фільму

    @Column(name = "feedback_about_film")
    private String feedback;                                                        // відгук про фільм

    public Response() {
    }

    public Response(User user, Movie movie, int rating, String feedback) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.feedback = feedback;
    }
}
