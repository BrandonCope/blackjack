package com.games.crazyUno;

import java.util.*;

class Deck {
    // Fields
    private Map<Integer, Map<Card, Card.CardValue>> deckMap = new TreeMap<>();

    private Card cards;

    // Constructor
    public Deck() {
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
    public Map<Card, Card.CardValue> drawCard() {
        Map<Card, Card.CardValue> newCard;

       List<Map<Card, Card.CardValue>> keys = new ArrayList(getDeckMap().keySet());
        Collections.shuffle(keys);
        newCard =  getDeckMap().get(keys.get(0));
        getDeckMap().remove(keys.get(0));

        return newCard;
    }

    public Map<Integer, Map<Card, Card.CardValue>> getDeckMap() {

        return deckMap;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + getDeckMap() +
                '}';
    }
}