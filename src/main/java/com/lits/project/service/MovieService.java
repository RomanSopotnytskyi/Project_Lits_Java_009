package com.lits.project.service;

import com.lits.project.dto.MovieDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO);

    public List<MovieDTO> getAllMovies();

    public MovieDTO getMovieById(Long id);

    public MovieDTO deleteMovie(Long id);

    public MovieDTO updateMovie(MovieDTO movieDTO, Long id);
}
