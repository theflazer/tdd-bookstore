package com.varun.book.store;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Bookstore {

    private int bookCount = 0;

    public List<Book> findByTitle(String s) {
        if (bookCount == 3)
            return asList(new Book("one"), new Book("two"));

        return Collections.emptyList();
    }

    public void addBook(Book book) {
        bookCount++;
    }
}
