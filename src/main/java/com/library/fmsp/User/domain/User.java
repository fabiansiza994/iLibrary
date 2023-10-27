package com.library.fmsp.User.domain;

import com.library.fmsp.Book.domain.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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


    @Column(name = "email")
    private String email;


    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "role")
    private String role;

    // Relación muchos a muchos con Books
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_book",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private Set<Book> books;

    @Column(name = "status")
    private Boolean status;
}
