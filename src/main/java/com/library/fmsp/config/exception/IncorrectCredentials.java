package com.library.fmsp.config.exception;

public class IncorrectCredentials extends RuntimeException{
    public IncorrectCredentials(String mensaje) {
        super(mensaje);
    }
}
