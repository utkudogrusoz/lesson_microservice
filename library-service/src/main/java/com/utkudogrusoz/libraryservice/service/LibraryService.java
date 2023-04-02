package com.utkudogrusoz.libraryservice.service;

import com.utkudogrusoz.libraryservice.client.BookServiceClient;
import com.utkudogrusoz.libraryservice.dto.AddBookRequest;
import com.utkudogrusoz.libraryservice.dto.LibraryDto;
import com.utkudogrusoz.libraryservice.exception.LibraryNotFoundException;
import com.utkudogrusoz.libraryservice.model.Library;
import com.utkudogrusoz.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {

        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;

    }

    public LibraryDto getAllBooksInLibraryById(String id) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id"));

        LibraryDto libraryDto = new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .collect(Collectors.toList()));
        return libraryDto;

    }

    public LibraryDto createLibrary() {
        Library library = libraryRepository.save(new Library());
        return new LibraryDto(library.getId());

    }

    public void addBookToLibrary(AddBookRequest request){
        String bookId=bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();
        Library library=libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id"));

        library.getUserBook()
                .add(bookId);

        libraryRepository.save(library);

    }


}
