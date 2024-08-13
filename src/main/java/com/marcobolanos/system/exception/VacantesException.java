package com.marcobolanos.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VacantesException extends RuntimeException{
    public VacantesException(String mensajee){
        super(mensajee);
    }
}
