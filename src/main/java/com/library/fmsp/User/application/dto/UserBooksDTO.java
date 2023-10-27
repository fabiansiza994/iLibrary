package com.library.fmsp.User.application.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserBooksDTO {
    private Integer idUser;
    private String userName;
    private Integer idBook;
    private String book;
}
