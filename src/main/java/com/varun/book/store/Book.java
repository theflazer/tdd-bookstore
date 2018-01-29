package com.varun.book.store;

import java.util.Comparator;

public class Book{

    public final String title;
    public final int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String toString() { return title; }

}
