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

    @Test
    public void actuallyFindAllBooksWithMatchingTitles() {
        Bookstore store = new Bookstore();
        Book lord_of_the_rings = new Book("Lord of the Rings");
        Book the_hobbit = new Book("The Hobbit");
        Book return_of_the_king = new Book("The Return of the King");
        store.addBook(lord_of_the_rings);
        store.addBook(the_hobbit);
        store.addBook(return_of_the_king);

        assertThat(
            store.findByTitle("OF tHE"),
            is(asList(lord_of_the_rings, return_of_the_king))
        );
    }

    @Test
    public void findsNoBooksSinceQueryContainsMoreWordsThanBookTitle() {
        Bookstore bookstore = new Bookstore();
        bookstore.addBook(new Book("FIRE"));
        assertThat(
            bookstore.findByTitle("fire fire"),
            is(empty())
        );
    }

}
