package com.lits.project.service.impl;

import com.lits.project.dto.MovieDTO;
import com.lits.project.exception.MovieNotFoundException;
import com.lits.project.models.Movie;
import com.lits.project.repository.MovieRepository;
import com.lits.project.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = StreamSupport.stream(movieRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return movies.stream().map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO){
        Movie movie = movieRepository.save(modelMapper.map(movieDTO, Movie.class));
        return modelMapper.map(movie, MovieDTO.class);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        return modelMapper.map(movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id)), MovieDTO.class);
    }

    @Override
    public MovieDTO deleteMovie(Long id){
        MovieDTO movieDTO = getMovieById(id);
        movieRepository.delete(modelMapper.map(movieDTO, Movie.class));
        return movieDTO;
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO, Long id) {
        return movieRepository.findById(id).map(movieToEdit -> {
            movieToEdit.setTitle(movieDTO.getTitle());
            movieToEdit.setGenre(movieDTO.getGenre());
            movieToEdit.setLength(movieDTO.getLength());
            movieToEdit.setTrailer(movieDTO.getTrailer());
            movieToEdit.setYear(movieDTO.getYear());
            movieRepository.save(movieToEdit);
            return modelMapper.map(movieToEdit, MovieDTO.class);
        }).orElseThrow(() -> new MovieNotFoundException(id));
    }
}
