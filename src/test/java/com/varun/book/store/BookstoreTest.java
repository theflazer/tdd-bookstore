package com.varun.book.store;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class BookstoreTest {

    public static final Random rnd = new Random(System.currentTimeMillis());
    private Bookstore store;
    private int begin;
    private int end;
    private String identifier;
    private Book game_of_thrones;
    private Book philosophers_stone;
    private Book clash_of_kings;
    private Book chamber_of_secrets;
    private Book storm_of_swords;
    private Book prisoner_of_azkaban;
    private Book feast_for_crows;
    private Book goblet_of_fire;
    private Book dance_with_dragons;
    private Book order_of_the_phoenix;
    private Book half_blood_prince;

    @Before
    public void setupTests() {
        store = new Bookstore();
        begin = 1950 + rnd.nextInt(70);
        end = begin + rnd.nextInt(30);
        identifier = Integer.toString(rnd.nextInt(10000));
        game_of_thrones = new Book("A Game of Thrones", begin - 1);
        philosophers_stone = new Book("The Philosopher's Stone " + identifier, begin - 1);
        clash_of_kings = new Book("A Clash of Kings", begin);
        chamber_of_secrets = new Book("The Chamber of " + identifier + " Secrets", begin);
        storm_of_swords = new Book("A Storm of Swords", begin + 1);
        prisoner_of_azkaban = new Book("The Prisoner from " + identifier, begin + 1);
        feast_for_crows = new Book("A Feast for Crows", end);
        goblet_of_fire = new Book("The Goblet of " + identifier + " Fires", end);
        dance_with_dragons = new Book("A Dance with Dragons", end + 1);
        order_of_the_phoenix = new Book("The Order of " + identifier + " Phoenix", end + 1);
        half_blood_prince = new Book("The Half-Blood Prince", end + 1);

    }

    @Test
    public void findsNothingWhenNoBookWithAMatchingTitleExists() {
        store.addBook(new Book("Lord of the Rings", 2001));

        assertThat(
            store.findByTitle("Fire and Fury"),
            is(empty()));
    }

    @Test
    public void findAllBooksWithMatchingTitles() {
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
        store.addBook(new Book("2001: A Space Odyssey", 2001));

        assertThat(
            store.findByPublicationYearBetween(1990, 2000),
            is(empty()));
    }

    @Test
    public void findAllBooksThatWasPublishedWithinTheSpecifiedYearRange() {
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
        store.addBook(philosophers_stone);
        store.addBook(goblet_of_fire);
        store.addBook(chamber_of_secrets);
        store.addBook(half_blood_prince);
        store.addBook(feast_for_crows);
        store.addBook(order_of_the_phoenix);

        assertThat(
            store.findByPublicationYearBetween(begin, end),
            is(asList(goblet_of_fire, chamber_of_secrets, feast_for_crows))
        );
    }

    @Test
    public void findBooksThatWasPublishedDuringASpecifiedRangeAndHasMatchingTitle() {
        store.addBook(philosophers_stone);
        store.addBook(clash_of_kings);
        store.addBook(game_of_thrones);
        store.addBook(chamber_of_secrets);
        store.addBook(storm_of_swords);
        store.addBook(feast_for_crows);
        store.addBook(prisoner_of_azkaban);
        store.addBook(goblet_of_fire);
        store.addBook(order_of_the_phoenix);
        store.addBook(dance_with_dragons);

        assertThat(
            store.findByPublicationYearBetweenAndTitle(begin, end, identifier),
            is(asList(chamber_of_secrets, prisoner_of_azkaban, goblet_of_fire))
        );
    }

    @Test
    public void findBooksThatWerePublishedDuringASpecifiedRangeOrHasMatchingTitle() {
        store.addBook(philosophers_stone);
        store.addBook(clash_of_kings);
        store.addBook(game_of_thrones);
        store.addBook(chamber_of_secrets);
        store.addBook(storm_of_swords);
        store.addBook(feast_for_crows);
        store.addBook(goblet_of_fire);
        store.addBook(order_of_the_phoenix);
        store.addBook(dance_with_dragons);
        assertThat(
            store.findByPublicationYearBetweenOrTitle(begin, end, identifier),
            is(asList(
                philosophers_stone,
                clash_of_kings,
                chamber_of_secrets,
                storm_of_swords,
                feast_for_crows,
                goblet_of_fire,
                order_of_the_phoenix))
        );
    }
}
