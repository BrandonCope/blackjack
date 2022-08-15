package com.games.crazyUno;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Deck {
    // Fields
    private static Map<Integer, Card> deckMap;


    // Constructor
    public Deck() {
    }

    public Deck(Map<Integer, Card> deckMap) {
        this.deckMap = deckMap;
    }




    //Methods
    /*
     method creates deck by using all possible
     variations of the card enum

     */
    public Map<Integer, Card> buildDeck(){

        return deckMap;
    }
    /*
     * gets top card from deckMap, and returns card
     */
    public static Map<Integer, Card> drawCard() {
        Map<Integer, Card> result = deckMap;

        return result;
    }


    public Map<Integer, Card> getDeckMap() {
        return deckMap;
    }

    // resets deck
    public void reset() {
        deckMap = new TreeMap<>();
        buildDeck();
    }
}