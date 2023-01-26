package com.be.customizedProduct.exceptions.customizedArea;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomizeAreaNotFoundException extends  RuntimeException {

    public CustomizeAreaNotFoundException(String message){
        super(message);
    }


}
