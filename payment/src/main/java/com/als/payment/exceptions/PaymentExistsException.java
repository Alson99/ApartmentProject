package com.als.payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PaymentExistsException extends RuntimeException {
    public PaymentExistsException(String message){
        super(message);
    }
}
