package com.codedifferentlly.labs.cards;

import com.codedifferentlly.labs.players.CardPlayer;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final int MAX_NUMBER_OF_CARDS = 52;
    private ArrayList<Card> cards;
    private boolean shuffled;

    public Deck() {
        initializeDeck();
        shuffled = false;
    }

    private void initializeDeck() {
        cards = new ArrayList<>();
        for (CardSuite suit : CardSuite.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public Integer getSize() { return cards.size(); }

    public void shuffle() {
        if (getSize() > 0) {
            Collections.shuffle(cards);
            shuffled = true;
        }
    }

    public boolean isShuffled() { return shuffled; }

    public ArrayList<Card> deal(int numberOfCards) {
        if (!shuffled) {
            shuffle();
        }

        if (numberOfCards > cards.size()) {
            System.out.println("No more cards to deal.");
            ArrayList<Card> empty = new ArrayList<>();
            return empty;
        }
        else {
        ArrayList<Card> dealtCards = new ArrayList<>();

        for (int i = 0; i < numberOfCards; i++) {
            dealtCards.add(cards.remove(0));
        }

        return dealtCards;
    }}
}