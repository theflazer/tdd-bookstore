package com.varun.book.store;

import java.util.*;

import static java.util.Arrays.asList;

public class Bookstore {

//    private int bookCount = 0;
    private List<Book> booklist = new ArrayList<Book>();


    public List<Book> findByTitle(String s) {
        List<Book> foundBooks = new ArrayList<Book>();
        Set<String> titleWords = new HashSet<String>();

        for (String word: s.split(" ")) {
            titleWords.add(word.toLowerCase());
        }

        for (Book book: booklist) {
            Set<String> bookTitleWords = new HashSet<String>();

            for (String word: book.title.split(" ")) {
                bookTitleWords.add(word.toLowerCase());
            }

            if(bookTitleWords.containsAll(titleWords)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void addBook(Book book) {
        booklist.add(book);
    }
}
