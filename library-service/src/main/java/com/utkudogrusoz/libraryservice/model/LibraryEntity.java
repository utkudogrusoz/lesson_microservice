package com.utkudogrusoz.libraryservice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

public class LibraryEntity {
    public LibraryEntity(String id, List<String> userBook) {
        this.id = id;
        this.userBook = userBook;
    }

    public LibraryEntity(List<String> userBook) {
        this.userBook = userBook;
    }
    public LibraryEntity() {
    }

    @Id
    @Column(name = "library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ElementCollection
    private List<String> userBook;

    public String getId() {
        return id;
    }

    public List<String> getUserBook() {
        return userBook;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserBook(List<String> userBook) {
        this.userBook = userBook;
    }
}
