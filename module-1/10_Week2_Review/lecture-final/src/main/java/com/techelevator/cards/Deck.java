package com.techelevator.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*Deck
    Properties:  cards, countOfCards, isShuffled
    Method: deal(), shuffle(), cut(), dealRandomCard()

 */
public class Deck {

    private List<Card> cards = new ArrayList<Card>();
    private boolean isShuffled = false;
    private Random random = new Random();


    public Deck(String[] suits, String[] ranks) {
        for (String suit : suits) {
            for (String rank: ranks) {
                Card currentCard = new Card(suit, rank);
                cards.add(currentCard);
            }
        }
    }

    public Card deal() {
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    public Card dealRandomCard() {
        int rangeMax = cards.size() - 1;
        int rangeMin = 0;
        int randomIndex = random.nextInt( (rangeMax - rangeMin) + 1 ) + rangeMin;
        return cards.remove(randomIndex);
    }

    public void placeCardInDeck(Card card, int index) {
        cards.add(index, card);
    }


    public void cut() {

        // If there are less than 2 cards don't do the cut
        if (cards == null || cards.size() < 2) {
            return;
        }

        // Calculate a pseudo-random cut point by getting the middle index,
        // picking a random number +-1/5 the deck size as an offset
        int rangeMax = cards.size() / 5;
        int rangeMin = rangeMax * -1;
        int offset = random.nextInt( (rangeMax - rangeMin) + 1 ) + rangeMin;
        int cutPoint = (cards.size() / 2) + offset;

        // Cut the deck from 0 to the cutPoint (exclusive)
        List<Card> firstHalf = cards.subList(0, cutPoint);
        // Cut the deck from the cutPoint (inclusive) to the end of the deck
        List<Card> secondHalf = cards.subList(cutPoint, cards.size());

        // Create a ne Array to hold the rearranged deck
        List<Card> restoredCards = new ArrayList<Card>();
        // Put the 2 halves in the new arraylist, the second first.
        restoredCards.addAll(secondHalf);
        restoredCards.addAll(firstHalf);

        // Set the cards in the deck to the rearranged array
        this.cards = restoredCards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
        this.isShuffled = true;
    }


    public boolean isShuffled() {
        return this.isShuffled;
    }

    /*
    Delegate method
     */
    public int size() {
        return cards.size();
    }

    private void flipAllCards() {
        for (Card card: cards) {
            card.flip();
        }
    }

    @Override
    public String toString() {
        flipAllCards();
        String deckAsString = "Deck " + cards;
        flipAllCards();
        return deckAsString;
    }
}
