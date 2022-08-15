package com.games.crazyUno;

import java.util.*;

class Deck {
    // Fields
    private static Map<Integer, Map<Card, Card.CardValue>> deckMap = new TreeMap<>();

    private Card cards;

    // Constructor
    public Deck() {
    }

    public Deck(Map<Integer, Map<Card, Card.CardValue>> deckMap) {
        this.deckMap = deckMap;
    }



    //Methods
    /*
     method creates deck by using all possible
     variations of the card enum

     */
    public Map<Integer, Map<Card, Card.CardValue>> buildDeck(){

        int cardCount = 0;
        for (Card card : Card.values()) {
            for (Card.CardValue value : Card.CardValue.values()) {
                Map<Card, Card.CardValue> newCard = new HashMap<>();
                newCard.put(card, value);

                cardCount += 1;

                deckMap.put(cardCount, newCard);
            }
        }
        return deckMap;
    }
    /*
     * gets top card from deckMap, and returns card
     */
    public static Map<Integer, Map<Card, Card.CardValue>> drawCard() {
        Map<Integer, Map<Card, Card.CardValue>> result = deckMap;

        return result;
    }


    public Map<Integer, Map<Card, Card.CardValue>> getDeckMap() {
        return deckMap;
    }

    // resets deck
    public void reset() {
        deckMap = new TreeMap<Integer, Map<Card, Card.CardValue>>();
        buildDeck();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + getDeckMap() +
                '}';
    }
}