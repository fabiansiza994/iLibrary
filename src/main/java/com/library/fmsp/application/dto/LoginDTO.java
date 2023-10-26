package com.library.fmsp.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO {
    @NotBlank(message = "el email es requerido")
    private String email;
    @NotBlank(message = "el password es requerido")
    private String password;
}
