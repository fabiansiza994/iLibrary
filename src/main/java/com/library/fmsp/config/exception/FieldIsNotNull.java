package com.library.fmsp.config.exception;

public class FieldIsNotNull extends RuntimeException{
    public FieldIsNotNull(String mensaje) {
        super(mensaje);
    }
}
