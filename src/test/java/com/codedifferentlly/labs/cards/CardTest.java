package com.codedifferentlly.labs.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codedifferentlly.labs.cards.CardSuite.HEARTS;
import static com.codedifferentlly.labs.cards.CardValue.TWO;

public class CardTest {

    @Test
    public void getSuitTest() {
        Card card = new Card(HEARTS, TWO);

        String expected = "HEARTS";
        String actual = card.getSuit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getNumberTest() {
        Card card = new Card(HEARTS, TWO);

        String expected = "TWO";
        String actual = card.getNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        Card card = new Card(HEARTS, TWO);

        String expected = "The TWO of HEARTS";
        String actual = card.toString();

        Assertions.assertEquals(expected, actual);
    }
}
