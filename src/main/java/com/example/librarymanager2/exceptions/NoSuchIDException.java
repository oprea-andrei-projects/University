package com.example.librarymanager2.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchIDException extends RuntimeException{

    public NoSuchIDException (String msg){

        super(msg);
    }
}
