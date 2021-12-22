package com.lits.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long id){
        super(MessageFormat.format("could not find movie with id: {0}",id));
    }

}
