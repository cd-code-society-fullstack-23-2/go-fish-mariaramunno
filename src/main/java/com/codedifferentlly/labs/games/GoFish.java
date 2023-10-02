package com.codedifferentlly.labs.games;

import com.codedifferentlly.labs.cards.Card;
import com.codedifferentlly.labs.cards.CardSuite;
import com.codedifferentlly.labs.cards.CardValue;
import com.codedifferentlly.labs.cards.Deck;
import com.codedifferentlly.labs.players.CardPlayer;
import com.codedifferentlly.labs.players.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends CardGame{

    private CardPlayer dealer = new CardPlayer("Computer");
    Scanner scanner = new Scanner(System.in);

    private Deck deck = new Deck();

    public GoFish(CardPlayer player) {
        super(player);
    }

    public void listOptions(CardPlayer player) {
        if( player.getNumberOfCards() == 0 && deck.getSize()==0){
            winner(player);
            System.exit(0);
        }
        System.out.println("====🃏Your cards🃏====");
        System.out.println();
        player.listCards();
        System.out.println();
    }

    public void checkCardsForPoints(CardPlayer player) {
        for (CardValue number : CardValue.values()){
            if (player.getCount(number.name()) == 4){
                player.addPoints();
                player.removeACardValue(number);
                System.out.println("Lucky!!! You got a pair!🎉 You got a book of " + number + "S!");
                System.out.printf("\nYou now have %d points!%n", player.getPoints());

                if(player.getNumberOfCards() == 0 && deck.getSize() < 5){
                    player.addCards(deck.deal(deck.getSize()));
                }
                if (player.getNumberOfCards() == 0){
                    player.addCards(deck.deal(5));
                }
                else if (dealer.getNumberOfCards() == 0 || player.getNumberOfCards() == 0  && deck.getSize() < 0) {
                    winner(player);
                    System.exit(0);
                }

            }
        }
    }

    public void checkOpponentHand(CardPlayer player, CardPlayer dealer, CardValue cardValue) {
        if (dealer.getNumberOfCards() == 0 || player.getNumberOfCards() == 0  && deck.getSize() < 0) {
            winner(player);
            System.exit(0);
        }
        ArrayList<Card> addedCards = new ArrayList<>();
        Integer total = dealer.getCount(cardValue.name());

        if (total == 0){
            System.out.printf("\nGo fish!🐠 The computer does not have a %s.\n", cardValue);
            ArrayList<Card> dealt = new ArrayList<>();
            dealt = deck.deal(1);
            System.out.println("Drawn Card: " + dealt.toString());
            player.addCards(dealt);
            if (dealt.get(0).getNumber().equals(cardValue.name())){
                System.out.println("\nYou fished you wish.⭐️ Please go again!\n");
                checkCardsForPoints(player);
                getUserInputAndCheck(player);
            }

        } else {
            Integer countdown = total;
            while (countdown > 0) {
                for (CardSuite suite : CardSuite.values()) {
                    Card check = new Card(suite, cardValue);
                    if (dealer.hasCard(check)) {
                        addedCards.add(check);
                        countdown--;
                    }
                }
            }
            dealer.removeACardValue(cardValue);
            player.addCards(addedCards);
            System.out.println("\nGood job, you stole " + total + " cards with value: " + cardValue + "✅");
            System.out.println();
            checkCardsForPoints(player);
            getUserInputAndCheck(player);
        }
    }

    public void getUserInputAndCheck(CardPlayer player){
        if(dealer.getNumberOfCards() == 0 && deck.getSize() < 5){
            player.addCards(deck.deal(deck.getSize()));
        } else if (dealer.getNumberOfCards() == 0){
            player.addCards(deck.deal(5));
        } else if (dealer.getNumberOfCards() == 0 || player.getNumberOfCards() == 0  && deck.getSize() < 0) {
            winner(player);
            System.exit(0);
        }
        listOptions(player);
        System.out.print("Please enter a value of a card (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING): ");
        String value = scanner.nextLine();
        CardValue cardValue = CardValue.valueOf(value.toUpperCase());

        while(player.getCount(cardValue.name()) == 0) {
            System.out.print("\nThat Value isn't already contained in your deck, " + "Please enter another value: ");
            value = scanner.nextLine();
            cardValue = CardValue.valueOf(value.toUpperCase());
        }
        System.out.println("\nDo you have any " + cardValue + "'s?");
        checkOpponentHand(player, dealer, cardValue);
    }

    public void checkPlayerHand(CardPlayer dealer, CardPlayer player, CardValue cardValue) {
        if(player.getNumberOfCards() == 0 || dealer.getNumberOfCards() == 0 && deck.getSize() == 0){
            winner(player);
            System.exit(0);
        }
        ArrayList<Card> addedCards = new ArrayList<>();
        System.out.println("Do you have any " + cardValue + "'s?");
        Integer total = player.getCount(cardValue.name());
        if (total == 0) {
            System.out.printf("\nGo fish!🐠 %s does not have a %s.\n", player.getName(), cardValue);
            ArrayList<Card> dealt = new ArrayList<>();
            dealt = deck.deal(1);
            dealer.addCards(dealt);
            if (dealt.get(0).getNumber().equals(cardValue.name())) {
                System.out.println("\nThe computer fished their wish.⭐️ They will go again!\n");
                checkCardsForPoints(dealer);
                checkPlayerHand(dealer, player, dealer.randomCard());
            }
        } else {
            Integer countdown = total;
            while (countdown > 0) {
                for (CardSuite suite : CardSuite.values()) {
                    Card check = new Card(suite, cardValue);
                    if (player.hasCard(check)) {
                        addedCards.add(check);
                        countdown--;
                    }
                }
            }
            player.removeACardValue(cardValue);
            dealer.addCards(addedCards);
            System.out.println("\nGood job, the computer stole " + total + " cards with value: " + cardValue + "✅");
            System.out.println();
            checkCardsForPoints(dealer);
            if (deck.getSize() == 0){
                winner(player);
                System.exit(0);
            }
            else{checkPlayerHand(dealer, player, dealer.randomCard());}
        }

    }

    public void userTurn(CardPlayer player){
        if(player.getNumberOfCards() == 0 || dealer.getNumberOfCards() == 0 && deck.getSize() == 0){
            winner(player);
            System.exit(0);
        }
        System.out.printf("\n\n--------%s's turn!--------\n\n", player.getName());
        checkCardsForPoints(player);
        getUserInputAndCheck(player);

    }

    public void compTurn(CardPlayer player){
        if(player.getNumberOfCards() == 0 || dealer.getNumberOfCards() == 0 && deck.getSize() == 0){
            winner(player);
            System.exit(0);
        }
        System.out.println("\n\n--------Computer's turn!--------\n");
        checkCardsForPoints(dealer);

        if(player.getNumberOfCards() == 0 && deck.getSize() < 5){
            player.addCards(deck.deal(deck.getSize()));
        } else if (player.getNumberOfCards() == 0) {
            player.addCards(deck.deal(5));
        }
        else if (dealer.getNumberOfCards() == 0 || player.getNumberOfCards() == 0  && deck.getSize() < 0) {
            winner(player);
            System.exit(0);
        }
        checkPlayerHand(dealer, player, dealer.randomCard());
    }

    public void winner(CardPlayer player){
        if(player.getPoints() > dealer.getPoints()){
            player.addWin();
            System.out.printf("\n%s wins!⭐\n", player.getName());
            System.out.println(player.toString());
        } else if (player.getPoints() < dealer.getPoints()){
            dealer.addWin();
            System.out.println("\nThe computer wins!☹️\n");
            System.out.println(dealer.toString());
        }else {
            System.out.println("It was a tie. Better luck next time :) ");
        }


        System.out.println(String.format("Thanks for playing %s!", player.getName()));
    }

    @Override
    public void play(CardPlayer player) {
        System.out.println(String.format("\nWelcome to Go Fish %s!🐠🎣🃏", player.getName()));
        deck.shuffle();
        player.addCards(deck.deal(7));
        dealer.addCards(deck.deal(7));

        System.out.println("As a guest, you will go first!");

        while (player.getNumberOfCards() > 0 && dealer.getNumberOfCards() > 0 ) {
            userTurn(player);
            compTurn(player);
        }

        winner(player);
    }

    @Override
    public void play(Player player) {
        System.out.println("Must be a Card Player");
    }

    @Override
    public String getMenuOption() {
        return "To play Go Fish";
    }
}
