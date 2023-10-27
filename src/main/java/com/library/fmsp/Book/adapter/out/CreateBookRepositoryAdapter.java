package com.library.fmsp.Book.adapter.out;

import com.library.fmsp.Book.adapter.infrastructure.BookRepository;
import com.library.fmsp.Book.application.dto.BookDTO;
import com.library.fmsp.Book.application.port.BookService;
import com.library.fmsp.Book.domain.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateBookRepositoryAdapter implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public CreateBookRepositoryAdapter(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        var book = bookRepository.save(modelMapper.map(bookDTO, Book.class));
        return modelMapper.map(book, BookDTO.class);
    }

    @Override
    public List<BookDTO> findAllBooks() {
        var books = bookRepository.findAll();
        return books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
    }
}
