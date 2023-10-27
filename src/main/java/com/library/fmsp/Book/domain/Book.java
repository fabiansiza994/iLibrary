package com.library.fmsp.Book.domain;

import com.library.fmsp.User.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NamedQuery(name = "Book.findAll", query = "select b from Book b where b.status=true")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "el nombre es requerido")
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "books")
    private Set<User> users;

    @Column(name = "status")
    private Boolean status;
}
