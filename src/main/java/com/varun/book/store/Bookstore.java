package com.varun.book.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Bookstore {

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
