package com.varun.book.store;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookstoreTest {

    @Test
    public void findsNothingWhenNoBookWithAMatchingTitleExists() {
        Bookstore store = new Bookstore();
        store.addBook(new Book("Lord of the Rings", 2001));

        assertThat(
            store.findByTitle("Fire and Fury"),
            is(empty()));
    }

    @Test
    public void findAllBooksWithMatchingTitles() {
        Bookstore store = new Bookstore();
        Book lord_of_the_rings = new Book("Lord of the Rings", 2001);
        Book the_hobbit = new Book("The Hobbit", 2001);
        Book return_of_the_king = new Book("The Return of the King", 2001);
        store.addBook(lord_of_the_rings);
        store.addBook(the_hobbit);
        store.addBook(return_of_the_king);

        assertThat(
            store.findByTitle("OF tHE"),
            is(asList(lord_of_the_rings, return_of_the_king))
        );
    }

    @Test
    public void findsNothingWhenNoBookWasPublishedWithinTheSpecifiedYearRange() {
        Bookstore store = new Bookstore();
        store.addBook(new Book("2001: A Space Odyssey", 2001));

        assertThat(
            store.findByPublicationYearBetween(1990, 2000),
            is(empty()));
    }

    @Test
    public void findAllBooksThatWasPublishedWithinTheSpecifiedYearRange() {
        Bookstore store = new Bookstore();
        Book toBeFoundBook1 = new Book("2001: A Space Odyssey", 2000);
        Book toBeFoundBook2 = new Book("Harry Potter and the sorcerer's stone", 1999);
        Book notToBeFoundBook = new Book("The Master Algorithm", 2015);
        store.addBook(toBeFoundBook1);
        store.addBook(toBeFoundBook2);
        store.addBook(notToBeFoundBook);

        assertThat(
            store.findByPublicationYearBetween(1998, 2000),
            is(asList(toBeFoundBook1, toBeFoundBook2))
        );

    }
}
