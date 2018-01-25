package com.varun.book.store;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {

    private final List<Book> books = new ArrayList<Book>();

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
        return null;
    }
}
