package com.library.fmsp.User.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    @NotBlank(message = "el nombre es requerido")
    private String nombre;
    @NotBlank(message = "el email es requerido")
    private String email;
    @NotBlank(message = "el password es requerido")
    private String password;
    private String role;
    private Boolean status;
}
