package com.utkudogrusoz.bookservice.model;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        private String id;
        private String title;
        private Integer bookYear;
        private String author;
        private String pressName;
        private String isbn;

        public Book(String id, String title, Integer bookYear, String author, String pressName, String isbn) {
                this.id = id;
                this.title = title;
                this.bookYear = bookYear;
                this.author = author;
                this.pressName = pressName;
                this.isbn = isbn;
        }

        public Book(String title, Integer bookYear, String author, String pressName, String isbn) {
                this.title = title;
                this.bookYear = bookYear;
                this.author = author;
                this.pressName = pressName;
                this.isbn = isbn;
        }

        public Book() {
        }

        public String getId() {
                return id;
        }

        public String getTitle() {
                return title;
        }

        public Integer getBookYear() {
                return bookYear;
        }

        public String getAuthor() {
                return author;
        }

        public String getPressName() {
                return pressName;
        }

        public String getIsbn() {
                return isbn;
        }
}
