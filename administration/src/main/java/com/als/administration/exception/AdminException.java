package com.als.administration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AdminException extends Throwable {
    public AdminException(String message) {
    }
}
