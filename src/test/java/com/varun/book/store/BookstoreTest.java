package com.varun.book.store;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by flazer on 23/1/2018.
 */
public class BookstoreTest {

    @Test
    public void searchByTitle() {
        Bookstore store = new Bookstore();
        String result = store.findByTitle("Fire and Fury");
        assertEquals(
            result,
            "Fire and Fury"
        );
    }
}
