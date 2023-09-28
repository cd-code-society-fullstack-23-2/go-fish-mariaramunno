package com.codedifferentlly.labs.players;

import com.codedifferentlly.labs.cards.Card;

import java.util.ArrayList;

public class CardPlayer extends Player{
    private ArrayList<Card> hand;


    public CardPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    public Integer getNumberOfCards(){
        return hand.size();
    }

    public Boolean hasCard(Card card){
        return hand.contains(card);
    }

    public void addCards(ArrayList<Card> cards){
        hand.addAll(cards);
    }

    public ArrayList<Card> removeCards(Integer numberOfCards){
        ArrayList<Card> cards = new ArrayList<>();
        for(int x = 0; x < numberOfCards; x ++){
            Card card = hand.remove(x);
            cards.add(card);
        }
        return cards;
    }

}
