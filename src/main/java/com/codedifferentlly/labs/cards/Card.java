package com.codedifferentlly.labs.cards;

public class Card {

    private CardSuite suit;
    private CardValue value;


    public Card(CardSuite suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit.name();
    }

    public String getNumber() {
        return value.name();
    }

    public String toString() {
        return "The " + value + " of " + suit;
    }
}