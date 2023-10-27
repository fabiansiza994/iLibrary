package com.library.fmsp.Book.application.usecase;

import com.library.fmsp.Book.application.dto.BookDTO;
import com.library.fmsp.Book.application.port.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllBooksUseCase {

    private final BookService bookService;

    public FindAllBooksUseCase(BookService bookService) {
        this.bookService = bookService;
    }

    public List<BookDTO> findAllBooks(){
        return bookService.findAllBooks();
    }
}
