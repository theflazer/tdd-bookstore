package com.varun.book.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookstoreTest {

    @Test
    public void findsNothingWhenNoBookWithAMatchingTitleExists() {
        Bookstore store = new Bookstore();
        store.addBook(new Book("Lord of the Rings"));

        assertThat(
            store.findByTitle("Fire and Fury"),
            is(empty()));
    }

    @Test
    public void findsAllBooksWithMatchingTitles() {
        Bookstore store = new Bookstore();
        Book book = new Book("Harry Potter and the Chamber of Secrets");
        Book book1 = new Book("Harry potter and the Prisoner of Azkaban");
        Book book2 = new Book("When Harry met sally");
        store.addBook(book);
        store.addBook(book1);
        store.addBook(book2);

        assertThat(
            store.findByTitle("potter harry").size(),
            is(2)
        );

    }
}
