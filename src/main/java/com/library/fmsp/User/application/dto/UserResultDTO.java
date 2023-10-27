package com.library.fmsp.User.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResultDTO {
    private Integer id;
    private String nombre;
    private String email;
    private String role;
    private Boolean status;
}
