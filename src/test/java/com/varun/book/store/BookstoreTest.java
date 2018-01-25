package com.varun.book.store;

import org.junit.Test;

import java.util.Random;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookstoreTest {

    public static final Random rnd = new Random(System.currentTimeMillis());

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
        Book _2001_a_space_oddyssey = new Book("2001: A Space Odyssey", 2000);
        Book harry_potter = new Book("Harry Potter and the sorcerer's stone", 1999);
        Book the_master_algorithm = new Book("The Master Algorithm", 2015);
        store.addBook(_2001_a_space_oddyssey);
        store.addBook(harry_potter);
        store.addBook(the_master_algorithm);

        assertThat(
            store.findByPublicationYearBetween(1998, 2000),
            is(asList(_2001_a_space_oddyssey, harry_potter))
        );
    }

    @Test
    public void bookFindingIsInclusive() {
        int begin = 1950 + rnd.nextInt(50);
        int end = begin + rnd.nextInt(20);

        Bookstore store = new Bookstore();
        Book philosophers_stone = new Book("The Philosopher's Stone", begin - 1);
        Book chamber_of_secrets = new Book("The Chamber of Secrets", begin);
        Book prisoner_of_azkaban = new Book("The Prisoner of Azkaban", begin + 1);
        Book goblet_of_fire = new Book("The Goblet of Fire", end - 1);
        Book order_of_the_phoenix = new Book("The Order of the Phoenix", end);
        Book half_blood_prince = new Book("The Half-Blood Prince", end + 1);

        store.addBook(philosophers_stone);
        store.addBook(goblet_of_fire);
        store.addBook(chamber_of_secrets);
        store.addBook(half_blood_prince);
        store.addBook(prisoner_of_azkaban);
        store.addBook(order_of_the_phoenix);

        assertThat(
            store.findByPublicationYearBetween(begin, end),
            is(asList(philosophers_stone, chamber_of_secrets))
        );
    }



}
