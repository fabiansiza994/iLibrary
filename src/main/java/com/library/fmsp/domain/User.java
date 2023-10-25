package com.library.fmsp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email=:email")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numeroDeContacto")
    private String numeroContacto;

    @Column(name = "email")
    private String email;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private Boolean status;
}
