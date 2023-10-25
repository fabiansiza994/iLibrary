package com.library.fmsp.application.dto;

import com.library.fmsp.config.exception.FieldIsNotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String nombre;
    private String numeroContacto;
    private String email;
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
    private String role;
    private Boolean status;

    public void validateFields(){
        if(Objects.isNull(password)){
            throw new FieldIsNotNull("password is required");
        }
        if(Objects.isNull(nombre)){
            throw new FieldIsNotNull("nombre is required");
        }
        if(password.equals("")){
            throw new FieldIsNotNull("password is required");
        }
        if(nombre.equals("")){
            throw new FieldIsNotNull("nombre is required");
        }
        if(password.length() <= 4){
            throw new FieldIsNotNull("password must have more than 4 characters");
        }
    }
}
