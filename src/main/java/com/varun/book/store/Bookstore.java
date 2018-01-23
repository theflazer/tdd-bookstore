package com.varun.book.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flazer on 23/1/2018.
 */
public class Bookstore {

    private final List<Book> booklist;

    public Bookstore() {
        booklist = new ArrayList<Book>();
    }

    public List<Book> findByTitle(String s) {

        List<Book> foundBooks = new ArrayList<Book>();
        return foundBooks;
    }

    public void addBook(Book book) {
        booklist.add(book);
    }
}
