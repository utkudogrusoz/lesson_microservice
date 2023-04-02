package com.utkudogrusoz.libraryservice.controller;

import com.utkudogrusoz.libraryservice.dto.AddBookRequest;
import com.utkudogrusoz.libraryservice.dto.LibraryDto;
import com.utkudogrusoz.libraryservice.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/library")
public class LibraryController {
    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService){
        this.libraryService=libraryService;

    }


    @GetMapping({"{id}"})
    public ResponseEntity<LibraryDto> getlibraryById(@PathVariable String id){
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request) throws Exception {
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }

}
