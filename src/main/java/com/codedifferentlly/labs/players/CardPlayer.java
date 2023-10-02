package com.codedifferentlly.labs.players;

import com.codedifferentlly.labs.cards.Card;
import com.codedifferentlly.labs.cards.CardSuite;
import com.codedifferentlly.labs.cards.CardValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

public class CardPlayer extends Player{
    private ArrayList<Card> hand;

    private Integer points = 0;


    public CardPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    public Integer getNumberOfCards(){
        return hand.size();
    }

    public String listCards() {
        String message = "";
        for (Card card : hand){
            System.out.println(card.toString());
            message += card.toString();
            message += "\n";
        }
    return message;
  }
    public Integer getPoints(){
        return points;
    }

    public ArrayList<Card> getCards() {
        return hand;
    }

    public Integer getCount(String value){
        String newValue = value.toUpperCase();
        Integer occurences = 0;
        for (int i = 0; i < hand.size(); i++){
            if(hand.get(i).getNumber().equals(newValue)){
                occurences++;
            }
        }
        return occurences;
    }

    public Boolean hasCard(Card card){
        String suit = card.getSuit();
        String number = card.getNumber();
        for (Card cards : hand){
            if(cards.getNumber().equals(number) && cards.getSuit().equals(suit)){
                return true;
            }
        }
        return false;
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

    public void removeACardValue(CardValue cardValue){
        Iterator<Card> iterator = hand.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getNumber().equals(cardValue.name())) {
                iterator.remove();
            }
        }
    }

    public ArrayList<Card> removeACard(Card card){
        String suit = card.getSuit();
        String number = card.getNumber();
        for (Card cards : hand){
            if(card.getNumber().equals(number) && cards.getSuit().equals(suit)){
                hand.remove(cards);
                ArrayList<Card> updatedCards = new ArrayList<>(hand);
                return updatedCards;
            }
        }
        throw new IllegalArgumentException("You do not have this card.");
    }

    public Integer addPoints() {return points++;}

    public CardValue randomCard(){
        Random rand = new Random();
        int index = rand.nextInt(getNumberOfCards());
        CardValue randomValue = CardValue.valueOf(hand.get(index).getNumber());
        return randomValue;
    }
}
