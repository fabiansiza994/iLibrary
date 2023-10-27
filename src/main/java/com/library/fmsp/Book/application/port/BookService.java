package com.library.fmsp.Book.application.port;

import com.library.fmsp.Book.application.dto.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    List<BookDTO> findAllBooks();
}
