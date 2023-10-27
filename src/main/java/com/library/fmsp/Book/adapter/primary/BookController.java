package com.library.fmsp.Book.adapter.primary;

import com.library.fmsp.Book.application.dto.BookDTO;
import com.library.fmsp.Book.application.usecase.CreateBookUseCase;
import com.library.fmsp.Book.application.usecase.FindAllBooksUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
@Tag(name = "Books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final FindAllBooksUseCase findAllBooksUseCase;

    @Operation(description = "Post endpoint for create book",
            responses = {@ApiResponse(description = "Success", responseCode = "201"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PostMapping("/create_book")
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO){
        var book = createBookUseCase.createBook(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @Operation(description = "Post endpoint for list all Books",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        var books = findAllBooksUseCase.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
