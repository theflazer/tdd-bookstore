package com.varun.book.store;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Bookstore {

//    private int bookCount = 0;
    private List<Book> booklist = new ArrayList<Book>();


    public List<Book> findByTitle(String s) {
        List<Book> foundBooks = new ArrayList<>();
        Set<String> queryWords = Arrays.asList(s.split(" "))
                .stream().map(n -> n.toLowerCase())
                .collect(Collectors.toSet());

        for (Book book: booklist) {
            Set<String> bookTitleWords = Arrays.asList(book.title.split(" "))
                    .stream().map(n -> n.toLowerCase())
                    .collect(Collectors.toSet());

            if(bookTitleWords.containsAll(queryWords)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void addBook(Book book) {
        booklist.add(book);
    }
}
