package com.lits.project.rest;

import com.lits.project.dto.MovieDTO;
import com.lits.project.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDTO> getAll() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    public MovieDTO getById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieDTO> addMovie(@Validated @RequestBody MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.addMovie(movieDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/movie/{id}")
    public MovieDTO delete(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }

    @PutMapping("/movie/{id}")
    public MovieDTO updateMovie(@PathVariable("id") Long id,@Validated @RequestBody MovieDTO movieDTO) {
        return movieService.updateMovie(movieDTO, id);
    }
}