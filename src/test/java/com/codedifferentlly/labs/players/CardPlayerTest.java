package com.codedifferentlly.labs.players;

import com.codedifferentlly.labs.cards.Card;
import com.codedifferentlly.labs.cards.CardSuite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.codedifferentlly.labs.cards.CardSuite.*;
import static com.codedifferentlly.labs.cards.CardValue.*;

public class CardPlayerTest {

    @Test
    public void addCardsTest01(){
        Card card1 = new Card(HEARTS, ACE);
        Card card2 = new Card(HEARTS, ACE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);

        Integer expected = 2;
        Integer actual = player.getNumberOfCards();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addCardsTest02(){
        Card card1 = new Card(SPADES, TEN);
        Card card2 = new Card(DIAMONDS, KING);
        Card card3 = new Card(HEARTS, ACE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);

        Integer expected = 3;
        Integer actual = player.getNumberOfCards();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeCardsTest01(){
        Card card1 = new Card(HEARTS, ACE);
        Card card2 = new Card(HEARTS, ACE);
        Card card3 = new Card(HEARTS, ACE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);
        player.removeCards(2);
        Integer expected = 1;
        Integer actual = player.getNumberOfCards();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeCardsTest02(){
        Card card1 = new Card(SPADES, TEN);
        Card card2 = new Card(DIAMONDS, KING);
        Card card3 = new Card(HEARTS, ACE);
        Card card4 = new Card(SPADES, TWO);
        Card card5 = new Card(DIAMONDS, FOUR);
        Card card6 = new Card(HEARTS, QUEEN);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);
        player.removeCards(2);
        Integer expected = 4;
        Integer actual = player.getNumberOfCards();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void listCards() {
        Card card1 = new Card(SPADES, TEN);
        Card card2 = new Card(DIAMONDS, KING);
        Card card3 = new Card(HEARTS, ACE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);

        String actual = player.listCards();

        String expected = "The TEN of SPADES" +
                "\nThe KING of DIAMONDS" +
                "\nThe ACE of HEARTS\n";

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void getAddPointsTest() {
        CardPlayer player = new CardPlayer("Name");
        player.addPoints();
        player.addPoints();

        Integer actual = player.getPoints();
        Integer expected = 2;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void getCountOfCards() {
        Card card1 = new Card(SPADES, TEN);
        Card card2 = new Card(DIAMONDS, TEN);
        Card card3 = new Card(HEARTS, TEN);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);

        Integer actual = player.getCount("TEN");

        Integer expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeACardValue() {
        Card card1 = new Card(SPADES,TEN);
        Card card2 = new Card(DIAMONDS,TEN);
        Card card3 = new Card(HEARTS,TEN);
        Card card4 = new Card(HEARTS,ACE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);
        player.removeACardValue(TEN);

        Integer actual = player.getNumberOfCards();
        Integer expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeACardValue02() {
        Card card1 = new Card(SPADES,ACE);
        Card card2 = new Card(DIAMONDS,ACE);
        Card card3 = new Card(HEARTS,ACE);
        Card card4 = new Card(CLUBS,ACE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);
        player.removeACardValue(ACE);

        Integer actual = player.getNumberOfCards();
        Integer expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeACard() {
        Card card1 = new Card(SPADES,TEN);
        Card card2 = new Card(DIAMONDS,KING);
        Card card3 = new Card(CLUBS,THREE);
        Card card4 = new Card(HEARTS,ACE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);
        Card test = new Card(CLUBS,THREE);
        player.removeACard(test);

        Integer actual = player.getNumberOfCards();
        Integer expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeACard01() {
        Card card1 = new Card(SPADES,TEN);
        Card card2 = new Card(DIAMONDS,KING);
        Card card3 = new Card(CLUBS,THREE);
        Card card4 = new Card(HEARTS,KING);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);
        ArrayList addedCards = new ArrayList();
        for (CardSuite suite : CardSuite.values()) {
            Card check = new Card(suite, KING);
            if (player.hasCard(check)) {
                addedCards.add(check);
                player.removeACard(check);
            }
        }

        Integer actual = player.getNumberOfCards();
        Integer expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void randomCardTest() {
        Card card1 = new Card(SPADES,TEN);
        Card card2 = new Card(DIAMONDS,KING);
        Card card3 = new Card(CLUBS,THREE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);

        String card = String.valueOf(player.randomCard());
        assert player.getCount(card) > 0;
    }

    @Test
    public void hasCardTest() {
        Card card1 = new Card(SPADES,TEN);
        Card card2 = new Card(DIAMONDS,KING);
        Card card3 = new Card(CLUBS,THREE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);

        Assertions.assertTrue(player.hasCard(card1));
    }

    @Test
    public void hasCardTest02() {
        Card card1 = new Card(SPADES,TEN);
        Card card2 = new Card(DIAMONDS,KING);
        Card card3 = new Card(CLUBS,THREE);

        ArrayList cards = new ArrayList();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        CardPlayer player = new CardPlayer("Name");
        player.addCards(cards);

        Card test = new Card(CLUBS,THREE);
        Assertions.assertTrue(player.hasCard(test));
    }

}
