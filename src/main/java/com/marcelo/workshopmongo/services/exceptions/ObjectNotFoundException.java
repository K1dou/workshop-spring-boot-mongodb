package com.marcelo.workshopmongo.services.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 2055519753639151149L;

    public ObjectNotFoundException(String message) {
        super(message);
    }











}
