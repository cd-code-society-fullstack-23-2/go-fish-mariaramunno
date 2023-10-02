package com.codedifferentlly.labs.games;

import com.codedifferentlly.labs.cards.Deck;
import com.codedifferentlly.labs.players.CardPlayer;


public abstract class CardGame implements Game{

    private Deck deck;

    private CardPlayer player;

    private CardPlayer dealer;

    public CardGame(CardPlayer player){
        this.deck = new Deck();
        this.player = player;
    }

    public abstract void play(CardPlayer player);
}
