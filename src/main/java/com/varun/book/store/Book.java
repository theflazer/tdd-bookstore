package com.varun.book.store;

public class Book {

    public final String title;

    public Book(String title, int publicationYear) {
        this.title = title;
    }

    public String toString() { return title; }
}
