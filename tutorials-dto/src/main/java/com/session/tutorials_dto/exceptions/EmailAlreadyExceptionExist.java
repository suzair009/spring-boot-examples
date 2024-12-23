package com.session.tutorials_dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExceptionExist extends RuntimeException{
    private String message;

    public EmailAlreadyExceptionExist(String message){
        super(message);
    }
}
