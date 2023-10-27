package com.library.fmsp.Book.application.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDTO {
    private Integer id;
    private String nombre;
    private Boolean status;
}
