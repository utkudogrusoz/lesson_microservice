package com.utkudogrusoz.bookservice.controller;

import com.utkudogrusoz.bookservice.dto.BookDto;
import com.utkudogrusoz.bookservice.dto.BookIdDto;
import com.utkudogrusoz.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }
}
