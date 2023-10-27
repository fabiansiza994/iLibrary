package com.library.fmsp.Book.application.usecase;

import com.library.fmsp.Book.application.dto.BookDTO;
import com.library.fmsp.Book.application.port.BookService;
import org.springframework.stereotype.Service;

@Service
public class CreateBookUseCase {

    private final BookService bookService;

    public CreateBookUseCase(BookService bookService) {
        this.bookService = bookService;
    }

    public BookDTO createBook(BookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }
}
