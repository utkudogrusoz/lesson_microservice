package com.utkudogrusoz.libraryservice.client;

import com.utkudogrusoz.libraryservice.dto.BookDto;
import com.utkudogrusoz.libraryservice.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="book-service",path = "/v1/book")
public interface BookServiceClient {
    @GetMapping("/isbn/{isbn}")
     ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn) ;
    @GetMapping("/book/{bookId}")
     ResponseEntity<BookDto> getBookById(@PathVariable String bookId);
}
