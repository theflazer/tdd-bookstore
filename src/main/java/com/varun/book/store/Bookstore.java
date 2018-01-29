package com.varun.book.store;

import java.util.*;

public class Bookstore {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findByTitle(String s) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books)
            if (book.title.toLowerCase().contains(s.toLowerCase()))
                foundBooks.add(book);

        return foundBooks;
    }

    public List<Book> findByPublicationYearBetween(int y1, int y2) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book: books) {
            if (book.publicationYear >= y1 && book.publicationYear <= y2) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> findByPublicationYearBetweenAndTitle(int begin, int end, String query) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books)
            if (book.publicationYear >= begin && book.publicationYear <= end && book.title.toLowerCase().contains(query.toLowerCase()))
                foundBooks.add(book);

        return foundBooks;
    }

    public List<Book> findByPublicationYearBetweenOrTitle(int begin, int end, String query) {
        return null;
    }
}
