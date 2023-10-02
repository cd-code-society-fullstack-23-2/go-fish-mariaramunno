package com.codedifferentlly.labs.cards;

import com.codedifferentlly.labs.cards.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeckTest {

    @Test
    public void createDeck(){
        Deck deck = new Deck();
        Integer actual = deck.getSize();
        Integer expected = 52;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shuffleDeck(){
        Deck deck = new Deck();
        deck.shuffle();

        Assertions.assertTrue(deck.isShuffled());
    }

    @Test
    public void notShuffledDeck(){
        Deck deck = new Deck();

        Assertions.assertFalse(deck.isShuffled());
    }

    @Test
    public void dealDeck(){
        Deck deck = new Deck();
        deck.deal(10);

        Integer expected = 42;
        Integer actual = deck.getSize();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void dealDeckFail(){
        Deck deck = new Deck();

        assertThrows(IllegalArgumentException.class, () -> {
            deck.deal(53);
        });
    }
}
