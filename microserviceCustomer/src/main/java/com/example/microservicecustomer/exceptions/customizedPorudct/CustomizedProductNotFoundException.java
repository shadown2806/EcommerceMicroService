package com.example.microservicecustomer.exceptions.customizedPorudct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class CustomizedProductNotFoundException extends RuntimeException{
    public CustomizedProductNotFoundException(String message){super(message);}
}
