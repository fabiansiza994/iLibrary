package com.library.fmsp.config.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String mensaje) {
        super(mensaje);
    }
}
