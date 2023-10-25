package com.library.fmsp.config.exception;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist(String mensaje) {
        super(mensaje);
    }
}
