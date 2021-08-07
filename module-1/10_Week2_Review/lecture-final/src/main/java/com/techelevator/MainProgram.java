package com.techelevator;

import com.techelevator.cards.Card;
import com.techelevator.cards.Deck;

public class MainProgram {

    private final static String[] suits = {
            "Diamonds",
            "Hearts",
            "Spades",
            "Clubs"
    };
    private final static String[] ranks = {
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "Jack",
            "Queen",
            "King",
            "Ace"
    };

    public static void main(String[] args) {

        Card card = new Card("ABC", "123");

        System.out.println(card);
        card.flip();
        System.out.println(card);

        Deck deck = new Deck(suits, ranks);

        System.out.println(deck);

        deck.shuffle();

        System.out.println(deck);

        deck.cut();
        System.out.println(deck);

        Card firstCard = deck.deal();
        firstCard.flip();
        Card secondCard = deck.deal();
        secondCard.flip();

        System.out.println(firstCard);
        System.out.println(secondCard);

        System.out.println(deck);


    }


}
