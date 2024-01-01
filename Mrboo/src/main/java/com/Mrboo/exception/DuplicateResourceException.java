package com.Mrboo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT) //for already present
public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message){
        super(message);
    }

}
