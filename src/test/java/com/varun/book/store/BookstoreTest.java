package com.varun.book.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookstoreTest {

    @Test public void findsNothingWhenNoBookWithAMatchingTitleExists() {
        Bookstore store = new Bookstore();
        store.addBook(new Book("Lord of the Rings"));

        assertThat(
            store.findByTitle("Fire and Fury"),
            is(empty()));;
    }
}
