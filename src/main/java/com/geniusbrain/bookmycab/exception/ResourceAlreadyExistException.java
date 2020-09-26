package com.geniusbrain.bookmycab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistException extends Exception {

    public ResourceAlreadyExistException(String message) {
        super(message);
    }
}
