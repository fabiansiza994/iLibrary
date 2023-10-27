package com.library.fmsp.Book.adapter.infrastructure;

import com.library.fmsp.Book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
