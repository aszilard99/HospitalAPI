package com.example.hospitalapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServerException extends RuntimeException{

    public ServerException(String message){
        super(message);
    }
}
