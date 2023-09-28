package com.codedifferentlly.labs.players;

import com.codedifferentlly.labs.cards.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CardPlayerTest {

    @Test
    public void addCardsTest01(){
        Card card = new Card();
        ArrayList cards = new ArrayList();
        cards.add(card);

        CardPlayer player = new CardPlayer("Beyonce");
        player.addCards(cards);

        Integer expected = 1;
        Integer actual = player.getNumberOfCards();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeCardsTest01(){
        Card card = new Card();
        Card cardieb = new Card();
        Card playBoiCard = new Card();
        ArrayList cards = new ArrayList();
        cards.add(card);
        cards.add(cardieb);
        cards.add(playBoiCard);

        CardPlayer player = new CardPlayer("Beyonce");
        player.addCards(cards);
        player.removeCards(2);
        Integer expected = 1;
        Integer actual = player.getNumberOfCards();

        Assertions.assertEquals(expected, actual);
    }
}
