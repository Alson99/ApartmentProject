package com.als.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleToAddOrderException extends RuntimeException {
    public ImpossibleToAddOrderException(String message) {
        super(message);
    }
}
